package com.cbdic.service;

import com.cbdic.entity.CallLog;
import com.cbdic.entity.User;
import com.cbdic.mapper.CallLogMapper;
import com.cbdic.mapper.UserMapper;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.json.JSONObject;

/**
 * Created by sqzhang on 2018/8/17.
 * data service
 */
@Service
public class DataService {

    @Value("${resource.data.datapath}")
    private String dataPath;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CallLogMapper callLogMapper;

    /**
    * 从文件上传用户数据
    */
    public Integer uploadUser(String filename) {
        Integer count = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(dataPath + filename));
            reader.readLine();
            String line;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            while((line = reader.readLine()) != null){
                String item[] = line.split(",");
                User user = new User();
                user.setUuid(Long.valueOf(item[0]));
                user.setCreatedAt(sdf.parse(item[1]));
                user.setPhone(item[2]);
                user.setName(item[3]);
                user.setIdNo(item[4]);
                int result = userMapper.insert(user);
                if(result > 0) {
                    count++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * 从文件上传通话记录
     */
    public Integer uploadCallLog(String filename) {
        Integer count = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(dataPath + filename));
            String line;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            CallLog callLog = new CallLog();
            while((line = reader.readLine()) != null){
                JSONObject dataJson = new JSONObject(line);
                JSONArray callLogs = dataJson.getJSONArray("call_log");
                Long uuid = Long.valueOf(dataJson.getString("uuid"));
                for(int i = 0;i < callLogs.length();i++) {
                    JSONObject callLogJson = callLogs.getJSONObject(i);
                    callLog.setUuid(uuid);
                    callLog.setDuration(Integer.valueOf(callLogJson.getString("duration")));
                    callLog.setDeviceId(callLogJson.getString("deviceId"));
                    callLog.setCallTime(sdf.parse(callLogJson.getString("callTime")));
                    callLog.setCallType(Byte.valueOf(callLogJson.getString("callType")));
                    callLog.setCreatedAt(sdf.parse(callLogJson.getString("createdAt")));
                    callLog.setPhone(callLogJson.getString("phone"));
                    int result = callLogMapper.insert(callLog);
                    if (result > 0) {
                        count++;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
}
