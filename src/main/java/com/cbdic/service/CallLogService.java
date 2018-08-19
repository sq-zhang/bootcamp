package com.cbdic.service;

import com.cbdic.entity.*;
import com.cbdic.mapper.CallLogFeatureMapper;
import com.cbdic.mapper.CallLogMapper;
import com.cbdic.utils.DateUtil;
import java.time.LocalDateTime;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sqzhang on 2018/8/19.
 * call log service
 */
@Service
public class CallLogService {

    private static final Logger logger = LoggerFactory.getLogger(CallLogService.class);

    @Autowired
    private CallLogMapper callLogMapper;

    @Autowired
    private CallLogFeatureMapper callLogFeatureMapper;

    @Autowired
    private UserService userService;

    CallLogFeature getFeature(Long uuid) {
        CallLogExample callLogExample = new CallLogExample();
        callLogExample.createCriteria().andUuidEqualTo(uuid);
        List<CallLog> callLogList = callLogMapper.selectByExample(callLogExample);
        if(callLogList == null || callLogList.isEmpty()) {
            return null;
        }
        callLogList = filterInValidPhone(callLogList);
        for (CallLog callLog : callLogList) {
            callLog.setCallDateTime();
        }

        User user = userService.selectUserByUuid(uuid);
        CallLogFeature callLogFeature = getCallLogFeature(callLogList, uuid, user.getPhone());

        insertOrUpdateCallLogFeature(uuid, callLogFeature);

        Integer score = getRiskScore(callLogFeature);
        userService.setUserSystemStatus(uuid, score, callLogFeature.getSelfCallInNinetyDays());

        return callLogFeature;
    }

    private void insertOrUpdateCallLogFeature(Long uuid, CallLogFeature callLogFeature) {
        CallLogFeatureExample example = new CallLogFeatureExample();
        example.createCriteria().andUuidEqualTo(uuid);
        CallLogFeature uuidFeature = callLogFeatureMapper.selectByPrimaryKey(uuid);
        if (uuidFeature != null) {
            callLogFeatureMapper.updateByPrimaryKey(callLogFeature);
        } else {
            callLogFeatureMapper.insert(callLogFeature);
        }
    }

    private CallLogFeature getCallLogFeature(List<CallLog> callLogList, Long uuid, String userPhone) {
        LocalDateTime lastCallDate = Collections.max(callLogList).getCallDateTime();
        CallLogFeature callLogFeature = new CallLogFeature();
        callLogFeature.setUuid(uuid);
        callLogFeature.setCallsInNinetyDays(getCallsInNinetyDays(callLogList, lastCallDate));
        callLogFeature.setPhonesInNinetyDays(getPhonesInNinetyDays(callLogList, lastCallDate));
        callLogFeature.setCallInInFourWeeks(getCallInInFourWeeks(callLogList, lastCallDate));
        callLogFeature.setCallOutInFourWeeks(getCallOutInFourWeeks(callLogList, lastCallDate));
        callLogFeature.setCallInPhonesInFourWeeks(getCallInPhonesInFourWeeks(callLogList, lastCallDate));
        callLogFeature.setCallOutPhonesInFourWeeks(getCallOutPhonesInFourWeeks(callLogList, lastCallDate));
        callLogFeature.setMinIntervalWithFriends(getMinIntervalWithFriends(callLogList, lastCallDate));
        callLogFeature.setSelfCallInNinetyDays(getSelfCallInNinetyDays(callLogList, lastCallDate, userPhone));
        callLogFeature.setUpdatedAt(new Date());
        return callLogFeature;
    }

    private List<CallLog> filterInValidPhone(List<CallLog> callLogList) {
        return callLogList.stream()
            .filter(callLog -> DateUtil.isValidDate(callLog.getCallTime()))
            .collect(Collectors.toList());
    }

    private Integer getCallsInNinetyDays(List<CallLog> callLogList, LocalDateTime lastCallDate) {
        return callLogList.stream()
            .filter(callLog -> DateUtil.isInNinetyDays(callLog.getCallDateTime(), lastCallDate))
            .collect(Collectors.toList()).size();
    }

    private Integer getPhonesInNinetyDays(List<CallLog> callLogList, LocalDateTime lastCallDate) {
        Set<String> phoneSet = new HashSet<>();
        for (CallLog callLog : callLogList) {
            if(DateUtil.isInNinetyDays(callLog.getCallDateTime(), lastCallDate)) {
                phoneSet.add(callLog.getPhone());
            }
        }
        return phoneSet.size();
    }

    private Integer getCallInInFourWeeks(List<CallLog> callLogList, LocalDateTime lastCallDate) {
        return callLogList.stream().filter(callLog ->
            callLog.isCallIn() && DateUtil.isInFourWeeks(callLog.getCallDateTime(), lastCallDate)
                && DateUtil.isBetweenZeroToThree(callLog.getCallDateTime()))
            .collect(Collectors.toList()).size();
    }

    private Integer getCallOutInFourWeeks(List<CallLog> callLogList, LocalDateTime lastCallDate) {
        return callLogList.stream().filter(callLog ->
            callLog.isCallOut() && DateUtil.isInFourWeeks(callLog.getCallDateTime(), lastCallDate)
                && DateUtil.isBetweenZeroToThree(callLog.getCallDateTime()))
            .collect(Collectors.toList()).size();
    }

    private Integer getCallInPhonesInFourWeeks(List<CallLog> callLogList, LocalDateTime lastCallDate) {
        Set<String> phoneSet = new HashSet<>();
        for (CallLog callLog : callLogList) {
            if(DateUtil.isInFourWeeks(callLog.getCallDateTime(), lastCallDate)
                && DateUtil.isBetweenZeroToThree(callLog.getCallDateTime())
                && callLog.isCallIn()) {
                phoneSet.add(callLog.getPhone());
            }
        }
        return phoneSet.size();
    }

    private Integer getCallOutPhonesInFourWeeks(List<CallLog> callLogList, LocalDateTime lastCallDate) {
        Set<String> phoneSet = new HashSet<>();
        for (CallLog callLog : callLogList) {
            if(DateUtil.isInFourWeeks(callLog.getCallDateTime(), lastCallDate)
                && DateUtil.isBetweenZeroToThree(callLog.getCallDateTime())
                && callLog.isCallOut()) {
                phoneSet.add(callLog.getPhone());
            }
        }
        return phoneSet.size();
    }

    private Long getMinIntervalWithFriends(List<CallLog> callLogList, LocalDateTime lastCallDate) {
        Map<String, List<CallLog>> phoneMap = new HashMap<>();
        for (CallLog callLog : callLogList) {
            if(DateUtil.isInHalfYear(callLog.getCallDateTime(), lastCallDate)) {
                if(phoneMap.containsKey(callLog.getPhone())) {
                    phoneMap.get(callLog.getPhone()).add(callLog);
                } else {
                    List<CallLog> callLogs = new ArrayList<>();
                    callLogs.add(callLog);
                    phoneMap.put(callLog.getPhone(), callLogs);
                }
            }
        }

        List<Map.Entry<String,List<CallLog>>> phoneMapList = new ArrayList<>(phoneMap.entrySet());
        phoneMapList.sort((o1, o2) -> Integer.valueOf(o1.getValue().size()).compareTo(o2.getValue().size()));
        Integer maxCallTimes = phoneMapList.get(0).getValue().size();
        long minDays = Long.MAX_VALUE;
        for (Map.Entry<String,List<CallLog>> entry : phoneMapList) {
            if(entry.getValue().size() == maxCallTimes) {
                LocalDateTime date = Collections.min(entry.getValue()).getCallDateTime();
                long days = DateUtil.until(date, lastCallDate);
                minDays = (minDays < days) ? minDays : days;
            } else {
                break;
            }
        }
        return minDays;
    }

    private Integer getSelfCallInNinetyDays(List<CallLog> callLogList, LocalDateTime lastCallDate, String phone) {
        return callLogList.stream().filter(callLog ->
            (callLog.getPhone().equals(phone)) && DateUtil.isInNinetyDays(callLog.getCallDateTime(), lastCallDate)
        ).collect(Collectors.toList()).size();
    }

    private Integer getRiskScore(CallLogFeature callLogFeature) {
        Integer score = 0;
        if (callLogFeature.getCallsInNinetyDays() < 200) {
            score += 3;
        }
        if (callLogFeature.getPhonesInNinetyDays() < 100) {
            score += 2;
        }
        if (callLogFeature.getCallInInFourWeeks() > 5 || callLogFeature.getCallOutInFourWeeks() > 5) {
            score += 1;
        }
        if (callLogFeature.getCallInPhonesInFourWeeks() > 5) {
            score += 3;
        }
        if (callLogFeature.getCallOutPhonesInFourWeeks() > 5) {
            score += 3;
        }
        if (callLogFeature.getMinIntervalWithFriends() > 20) {
            score += 3;
        }
        if (callLogFeature.getSelfCallInNinetyDays() > 3) {
            score += 3;
        }
        return score;
    }

}
