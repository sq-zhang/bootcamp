package com.cbdic.service;

import com.cbdic.entity.*;
import com.cbdic.mapper.CallLogMapper;
import com.cbdic.mapper.UserMapper;
import com.cbdic.utils.DateUtil;
import com.cbdic.utils.IdCardUtil;
import com.cbdic.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class RecordService {

    @Autowired
    private CallLogMapper callLogMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CallLogService callLogService;


    /**
     * 数据脱敏处理
     * @return
     */
    public Object getAllCookedRecord(Integer page,Integer nums, String phone, String name, String idNo){
        Map<String,Object> res = new HashMap<String,Object>();
        List<User> userlist = new ArrayList<>();
        UserExample example = new UserExample();
        List<User> totalList = userMapper.selectByExample(example);
        if (phone != null & phone != "") {
            phone = '%' + phone + '%';
        } else {
            phone = "%%";
        }

        if (name != null & name != "") {
            name = '%' + name + '%';
        } else {
            name = "%%";
        }
        if (idNo != null & idNo != "") {
            idNo = '%' + idNo + '%';
        } else {
            idNo = "%%";
        }
        List<User> allRecordList = userMapper.selectByExampleWithCondition(example,(page - 1) * nums, nums,
            name,phone,idNo);
        //对得到的结果进行过滤
        for(int i = 0;i < allRecordList.size();i++){
            allRecordList.get(i).setIdNo(Utils.cookPhoneIdNo(allRecordList.get(i).getIdNo()));
            allRecordList.get(i).setPhone(Utils.cookPhoneIdNo(allRecordList.get(i).getPhone()));
            userlist.add(allRecordList.get(i));
        }
        res.put("total",totalList.size());
        res.put("data",allRecordList);
        return res;
    }

    /**
     * 数据脱敏处理
     * @return
     */
    public Object getDetailCookedRecord(Long uuid){
        Map<String,Object> res = new HashMap<>();
        UserExample example = new UserExample();
        example.createCriteria().andUuidEqualTo(uuid);
        List<User> allRecordList = userMapper.selectByExample(example);
        if(allRecordList==null||allRecordList.size()==0)
            return null;
        User user = allRecordList.get(0);
        //对得到的结果进行过滤
        String idNo = user.getIdNo();
        String phone = user.getPhone();
        user.setIdNo(Utils.cookPhoneIdNo(idNo));
        user.setPhone(Utils.cookPhoneIdNo(phone));

        //得到top3信息
        List top3 = getTop3Contacts(uuid);

        //得到详情页信息
        CallLogFeature feature = callLogService.getFeature(uuid);
        res.put("user",user);
        res.put("top3",top3);
        res.put("feature",feature);
        return res;
    }


    /**
     *    得到top3contacts常用联系人
     */
    public List getTop3Contacts(Long uuid){
        CallLogExample callLogExample = new CallLogExample();
        callLogExample.createCriteria().andUuidEqualTo(uuid);
        List<CallLog> callLogList1 = callLogMapper.selectByExample(callLogExample);
        for(int i = 0;i < callLogList1.size();i++)
            callLogList1.get(i).setCallDateTime();
        LocalDateTime lastCallDate = Collections.max(callLogList1).getCallDateTime();
        List<CallLog> callLogList = callLogList1.stream()
                .filter(callLog -> DateUtil.isInHalfYear(callLog.getCallDateTime(), lastCallDate))
                .collect(Collectors.toList());
        if(callLogList == null || callLogList.isEmpty()) {
            return null;
        }
        Map<String,Integer> phoneCounts = new HashMap<String,Integer>();
        //将callLogList按照通话时间进行逆向排序
        Collections.sort(callLogList, new Comparator<CallLog>() {
            @Override
            public int compare(CallLog o1, CallLog o2) {
                return o2.getCallTime().compareTo(o1.getCallTime());
            }
        });
        for(int i = 0;i < callLogList.size();i++){
            if(phoneCounts.get(callLogList.get(i).getPhone())!=null){
                phoneCounts.put(callLogList.get(i).getPhone(),phoneCounts.get(callLogList.get(i).getPhone())+1);
            }else{
                phoneCounts.put(callLogList.get(i).getPhone(),1);
            }
        }
        //返回top3
        List<String> top3Contacts = new ArrayList<>();
        List<Map.Entry<String,Integer>> phoneCountsList = new ArrayList<>(phoneCounts.entrySet());
        Collections.sort(phoneCountsList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        for(int i = 0;i < phoneCountsList.size()&&i<3;i++){
            top3Contacts.add(phoneCountsList.get(i).getKey());
        }
        return top3Contacts;
    }
}
