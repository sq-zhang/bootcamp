package com.cbdic.service;

import com.cbdic.entity.*;
import com.cbdic.mapper.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sqzhang on 2018/8/18.
 * review service
 */
@Service
public class ReviewService {

    @Autowired
    private CallLogFeatureMapper callLogFeatureMapper;

    @Autowired
    private CallLogService callLogService;

    @Autowired
    private UserMapper userMapper;

    public CallLogFeature getCallLogFeature(Long uuid, Boolean update) {
        CallLogFeatureExample example = new CallLogFeatureExample();
        example.createCriteria().andUuidEqualTo(uuid);
        List<CallLogFeature> callLogFeatures = callLogFeatureMapper.selectByExample(example);
        if ((callLogFeatures != null && callLogFeatures.isEmpty()) || update) {
            return callLogService.getFeature(uuid);
        } else {
            return callLogFeatures.get(0);
        }
    }

    public List<CallLogFeature> getAllCallLogFeature() {
        UserExample userExample = new UserExample();
        List<User> users = userMapper.selectByExample(userExample);
        List<CallLogFeature> callLogFeatures = new ArrayList<>();
        Integer count = 0;
        for(User user : users) {
            CallLogFeatureExample example = new CallLogFeatureExample();
            example.createCriteria().andUuidEqualTo(user.getUuid());
            List<CallLogFeature> callLogFeatureList = callLogFeatureMapper.selectByExample(example);
            if(callLogFeatureList.size() >= 10) {
                callLogFeatures.add(callLogFeatureList.get(0));
            } else {
                CallLogFeature callLogFeature = callLogService.getFeature(user.getUuid());
                System.out.println(count + " -> " + user.getUuid() + callLogFeature.getUpdatedAt());
                callLogFeatures.add(callLogFeature);
                count++;
            }
        }
        return callLogFeatures;
    }
}
