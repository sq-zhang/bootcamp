package com.cbdic.controller;

import com.cbdic.entity.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cbdic.service.*;

/**
 * Created by sqzhang on 2018/8/17.
 * data upload
 */
@RestController
@RequestMapping("/data")
public class DataController {

    @Autowired
    DataService dataService;

    @GetMapping("/upload/user")
    public ResponseObject<Integer> uploadUserData(@RequestParam String filename) {
        Integer count = dataService.uploadUser(filename);
        return new ResponseObject<>(ResponseObject.STATUS_OK, ResponseObject.STATUS_OK, count);
    }

    @GetMapping("/upload/call")
    public ResponseObject<Integer> uploadCallLog(@RequestParam String filename) {
        Integer count = dataService.uploadCallLog(filename);
        return new ResponseObject<>(ResponseObject.STATUS_OK, ResponseObject.STATUS_OK, count);
    }
}
