package com.cbdic.entity;

import java.util.Date;

public class CallLog {
    private Integer callLogId;

    private Long uuid;

    private String deviceId;

    private Byte callType;

    private Date callTime;

    private Integer duration;

    private String phone;

    private Date createdAt;

    public Integer getCallLogId() {
        return callLogId;
    }

    public void setCallLogId(Integer callLogId) {
        this.callLogId = callLogId;
    }

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public Byte getCallType() {
        return callType;
    }

    public void setCallType(Byte callType) {
        this.callType = callType;
    }

    public Date getCallTime() {
        return callTime;
    }

    public void setCallTime(Date callTime) {
        this.callTime = callTime;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}