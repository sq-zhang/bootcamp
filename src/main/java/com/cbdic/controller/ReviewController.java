package com.cbdic.controller;

import com.cbdic.entity.ResponseObject;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/info")
    public ResponseObject<String> getReviewInfo(@RequestParam String uuid) {
        return new ResponseObject<>(ResponseObject.STATUS_OK, ResponseObject.STATUS_OK, uuid);
    }
}
