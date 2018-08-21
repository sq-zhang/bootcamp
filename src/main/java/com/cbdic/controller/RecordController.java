package com.cbdic.controller;

import com.cbdic.entity.User;
import com.cbdic.service.CallLogService;
import com.cbdic.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 进件信息展示
 */
@RestController
public class RecordController {
    @Autowired
    RecordService recordService;

    @Autowired
    CallLogService callLogService;


    /**
     * 得到所有的user信息
     * page 页数
     * nums 每页个数
     * @return
     */
    @CrossOrigin(origins = "http://10.106.164.188:3000")
    @GetMapping("/record")
    public Object getAllRecords(@RequestParam Integer page,@RequestParam Integer nums, @RequestParam String name,
        @RequestParam String phone, @RequestParam String id_no){
        if(page == null) page = 1;
        if(nums == null) nums = 10;
        Object res  = recordService.getAllCookedRecord(page,nums, phone, name, id_no);
        return res;
    }
    @CrossOrigin(origins = "http://10.106.164.188:3000")
    @GetMapping("/detail_record")
    public Object getDetailRecords(@RequestParam Long uuid){
        Object obj =  recordService.getDetailCookedRecord(uuid);
        return obj;
    }

}
