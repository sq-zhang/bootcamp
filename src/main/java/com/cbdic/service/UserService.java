package com.cbdic.service;

import com.cbdic.entity.User;
import com.cbdic.entity.UserExample;
import com.cbdic.mapper.UserMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sqzhang on 2018/8/19.
 * User service
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    private static final String SYSTEM_PASS = "SYSTEM_PASS";

    private static final String SYSTEM_DENY = "SYSTEM_DENY";

    private static final String MANUAL_PASS = "MANUAL_PASS";

    private static final String MANUAL_DENY = "MANUAL_DENY";

    public User selectUserByUuid(Long uuid) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUuidEqualTo(uuid);
        List<User> users = userMapper.selectByExample(userExample);
        if (users != null && users.size() >= 1) {
            return users.get(0);
        }
        return null;
    }

    public void submitReview(Long uuid, Boolean isPass) {
        User user = new User();
        if (isPass) {
            user.setStatus(MANUAL_PASS);
        } else {
            user.setStatus(MANUAL_DENY);
        }
        UserExample example = new UserExample();
        example.createCriteria().andUuidEqualTo(uuid);
        userMapper.updateByExampleSelective(user, example);
    }

    public void setUserSystemStatus(Long uuid, Integer score, Integer selfCallTimes) {
        User user = new User();
        user.setScore(score);
        if (score > 4 || selfCallTimes > 5) {
            user.setStatus(SYSTEM_DENY);
        } else {
            user.setStatus(SYSTEM_PASS);
        }
        UserExample example = new UserExample();
        example.createCriteria().andUuidEqualTo(uuid);
        userMapper.updateByExampleSelective(user, example);
    }

}
