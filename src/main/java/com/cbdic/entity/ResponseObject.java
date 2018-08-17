package com.cbdic.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * Created by sqzhang on 2018/8/17.
 * response data
 */
@Data
public class ResponseObject<T> implements Serializable {

    public static final String STATUS_OK = "ok";
    public static final String STATUS_FAIL = "fail";

    private String status;

    private String msg;

    private T data;

    public ResponseObject() {
        this.status = STATUS_OK;
    }

    public ResponseObject(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public ResponseObject(String status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ResponseObject(String status, T data) {
        this.status = status;
        this.data = data;
    }
}
