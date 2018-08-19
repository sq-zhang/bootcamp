package com.cbdic.entity;

import java.util.Date;

public class CallLogFeature {
    private Long uuid;

    private Integer callsInNinetyDays;

    private Integer phonesInNinetyDays;

    private Integer callInInFourWeeks;

    private Integer callOutInFourWeeks;

    private Integer callInPhonesInFourWeeks;

    private Integer callOutPhonesInFourWeeks;

    private Long minIntervalWithFriends;

    private Integer selfCallInNinetyDays;

    private Date updatedAt;

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public Integer getCallsInNinetyDays() {
        return callsInNinetyDays;
    }

    public void setCallsInNinetyDays(Integer callsInNinetyDays) {
        this.callsInNinetyDays = callsInNinetyDays;
    }

    public Integer getPhonesInNinetyDays() {
        return phonesInNinetyDays;
    }

    public void setPhonesInNinetyDays(Integer phonesInNinetyDays) {
        this.phonesInNinetyDays = phonesInNinetyDays;
    }

    public Integer getCallInInFourWeeks() {
        return callInInFourWeeks;
    }

    public void setCallInInFourWeeks(Integer callInInFourWeeks) {
        this.callInInFourWeeks = callInInFourWeeks;
    }

    public Integer getCallOutInFourWeeks() {
        return callOutInFourWeeks;
    }

    public void setCallOutInFourWeeks(Integer callOutInFourWeeks) {
        this.callOutInFourWeeks = callOutInFourWeeks;
    }

    public Integer getCallInPhonesInFourWeeks() {
        return callInPhonesInFourWeeks;
    }

    public void setCallInPhonesInFourWeeks(Integer callInPhonesInFourWeeks) {
        this.callInPhonesInFourWeeks = callInPhonesInFourWeeks;
    }

    public Integer getCallOutPhonesInFourWeeks() {
        return callOutPhonesInFourWeeks;
    }

    public void setCallOutPhonesInFourWeeks(Integer callOutPhonesInFourWeeks) {
        this.callOutPhonesInFourWeeks = callOutPhonesInFourWeeks;
    }

    public Long getMinIntervalWithFriends() {
        return minIntervalWithFriends;
    }

    public void setMinIntervalWithFriends(Long minIntervalWithFriends) {
        this.minIntervalWithFriends = minIntervalWithFriends;
    }

    public Integer getSelfCallInNinetyDays() {
        return selfCallInNinetyDays;
    }

    public void setSelfCallInNinetyDays(Integer selfCallInNinetyDays) {
        this.selfCallInNinetyDays = selfCallInNinetyDays;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}