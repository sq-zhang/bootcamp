package com.cbdic.controller;

import com.cbdic.entity.CallLogFeature;
import com.cbdic.entity.ResponseObject;
import com.cbdic.entity.User;
import com.cbdic.service.ReviewService;
import com.cbdic.service.UserService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sqzhang on 2018/8/17.
 * controller for review
 */
@RestController
@RequestMapping("/review")
public class ReviewController {

    private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);

    @Autowired
    ReviewService reviewService;

    @Autowired
    UserService userService;

    @CrossOrigin(origins = "http://10.106.164.188:3000")
    @GetMapping("/info")
    public ResponseObject<CallLogFeature> getReviewInfo(@RequestParam Long uuid) {
        CallLogFeature callLogFeatures = reviewService.getCallLogFeature(uuid);
        return new ResponseObject<>(ResponseObject.STATUS_OK, ResponseObject.STATUS_OK, callLogFeatures);
    }

    @CrossOrigin(origins = "http://10.106.164.188:3000")
    @GetMapping("/info/all")
    public ResponseObject<List<CallLogFeature>> getAllCallLogFeature() {
        List<CallLogFeature> callLogFeatures = reviewService.getAllCallLogFeature();
        return new ResponseObject<>(ResponseObject.STATUS_OK, ResponseObject.STATUS_OK, callLogFeatures);
    }

    @CrossOrigin(origins = "http://10.106.164.188:3000")
    @PostMapping("/submit")
    public ResponseObject submitReviewResult(@RequestParam Long uuid, @RequestParam Boolean isPass) {
        userService.submitReview(uuid, isPass);
        return new ResponseObject<>(ResponseObject.STATUS_OK, ResponseObject.STATUS_OK);
    }

    @CrossOrigin(origins = "http://10.106.164.188:3000")
    @GetMapping("/user")
    public ResponseObject<List<User>> getUsers(@RequestParam Long uuid) {
        return new ResponseObject<>(ResponseObject.STATUS_OK, ResponseObject.STATUS_OK);
    }
}
