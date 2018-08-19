package com.cbdic.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CallLogFeatureExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CallLogFeatureExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andUuidIsNull() {
            addCriterion("uuid is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("uuid is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(Long value) {
            addCriterion("uuid =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(Long value) {
            addCriterion("uuid <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(Long value) {
            addCriterion("uuid >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(Long value) {
            addCriterion("uuid >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(Long value) {
            addCriterion("uuid <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(Long value) {
            addCriterion("uuid <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<Long> values) {
            addCriterion("uuid in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<Long> values) {
            addCriterion("uuid not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(Long value1, Long value2) {
            addCriterion("uuid between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(Long value1, Long value2) {
            addCriterion("uuid not between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andCallsInNinetyDaysIsNull() {
            addCriterion("calls_in_ninety_days is null");
            return (Criteria) this;
        }

        public Criteria andCallsInNinetyDaysIsNotNull() {
            addCriterion("calls_in_ninety_days is not null");
            return (Criteria) this;
        }

        public Criteria andCallsInNinetyDaysEqualTo(Integer value) {
            addCriterion("calls_in_ninety_days =", value, "callsInNinetyDays");
            return (Criteria) this;
        }

        public Criteria andCallsInNinetyDaysNotEqualTo(Integer value) {
            addCriterion("calls_in_ninety_days <>", value, "callsInNinetyDays");
            return (Criteria) this;
        }

        public Criteria andCallsInNinetyDaysGreaterThan(Integer value) {
            addCriterion("calls_in_ninety_days >", value, "callsInNinetyDays");
            return (Criteria) this;
        }

        public Criteria andCallsInNinetyDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("calls_in_ninety_days >=", value, "callsInNinetyDays");
            return (Criteria) this;
        }

        public Criteria andCallsInNinetyDaysLessThan(Integer value) {
            addCriterion("calls_in_ninety_days <", value, "callsInNinetyDays");
            return (Criteria) this;
        }

        public Criteria andCallsInNinetyDaysLessThanOrEqualTo(Integer value) {
            addCriterion("calls_in_ninety_days <=", value, "callsInNinetyDays");
            return (Criteria) this;
        }

        public Criteria andCallsInNinetyDaysIn(List<Integer> values) {
            addCriterion("calls_in_ninety_days in", values, "callsInNinetyDays");
            return (Criteria) this;
        }

        public Criteria andCallsInNinetyDaysNotIn(List<Integer> values) {
            addCriterion("calls_in_ninety_days not in", values, "callsInNinetyDays");
            return (Criteria) this;
        }

        public Criteria andCallsInNinetyDaysBetween(Integer value1, Integer value2) {
            addCriterion("calls_in_ninety_days between", value1, value2, "callsInNinetyDays");
            return (Criteria) this;
        }

        public Criteria andCallsInNinetyDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("calls_in_ninety_days not between", value1, value2, "callsInNinetyDays");
            return (Criteria) this;
        }

        public Criteria andPhonesInNinetyDaysIsNull() {
            addCriterion("phones_in_ninety_days is null");
            return (Criteria) this;
        }

        public Criteria andPhonesInNinetyDaysIsNotNull() {
            addCriterion("phones_in_ninety_days is not null");
            return (Criteria) this;
        }

        public Criteria andPhonesInNinetyDaysEqualTo(Integer value) {
            addCriterion("phones_in_ninety_days =", value, "phonesInNinetyDays");
            return (Criteria) this;
        }

        public Criteria andPhonesInNinetyDaysNotEqualTo(Integer value) {
            addCriterion("phones_in_ninety_days <>", value, "phonesInNinetyDays");
            return (Criteria) this;
        }

        public Criteria andPhonesInNinetyDaysGreaterThan(Integer value) {
            addCriterion("phones_in_ninety_days >", value, "phonesInNinetyDays");
            return (Criteria) this;
        }

        public Criteria andPhonesInNinetyDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("phones_in_ninety_days >=", value, "phonesInNinetyDays");
            return (Criteria) this;
        }

        public Criteria andPhonesInNinetyDaysLessThan(Integer value) {
            addCriterion("phones_in_ninety_days <", value, "phonesInNinetyDays");
            return (Criteria) this;
        }

        public Criteria andPhonesInNinetyDaysLessThanOrEqualTo(Integer value) {
            addCriterion("phones_in_ninety_days <=", value, "phonesInNinetyDays");
            return (Criteria) this;
        }

        public Criteria andPhonesInNinetyDaysIn(List<Integer> values) {
            addCriterion("phones_in_ninety_days in", values, "phonesInNinetyDays");
            return (Criteria) this;
        }

        public Criteria andPhonesInNinetyDaysNotIn(List<Integer> values) {
            addCriterion("phones_in_ninety_days not in", values, "phonesInNinetyDays");
            return (Criteria) this;
        }

        public Criteria andPhonesInNinetyDaysBetween(Integer value1, Integer value2) {
            addCriterion("phones_in_ninety_days between", value1, value2, "phonesInNinetyDays");
            return (Criteria) this;
        }

        public Criteria andPhonesInNinetyDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("phones_in_ninety_days not between", value1, value2, "phonesInNinetyDays");
            return (Criteria) this;
        }

        public Criteria andCallInInFourWeeksIsNull() {
            addCriterion("call_in_in_four_weeks is null");
            return (Criteria) this;
        }

        public Criteria andCallInInFourWeeksIsNotNull() {
            addCriterion("call_in_in_four_weeks is not null");
            return (Criteria) this;
        }

        public Criteria andCallInInFourWeeksEqualTo(Integer value) {
            addCriterion("call_in_in_four_weeks =", value, "callInInFourWeeks");
            return (Criteria) this;
        }

        public Criteria andCallInInFourWeeksNotEqualTo(Integer value) {
            addCriterion("call_in_in_four_weeks <>", value, "callInInFourWeeks");
            return (Criteria) this;
        }

        public Criteria andCallInInFourWeeksGreaterThan(Integer value) {
            addCriterion("call_in_in_four_weeks >", value, "callInInFourWeeks");
            return (Criteria) this;
        }

        public Criteria andCallInInFourWeeksGreaterThanOrEqualTo(Integer value) {
            addCriterion("call_in_in_four_weeks >=", value, "callInInFourWeeks");
            return (Criteria) this;
        }

        public Criteria andCallInInFourWeeksLessThan(Integer value) {
            addCriterion("call_in_in_four_weeks <", value, "callInInFourWeeks");
            return (Criteria) this;
        }

        public Criteria andCallInInFourWeeksLessThanOrEqualTo(Integer value) {
            addCriterion("call_in_in_four_weeks <=", value, "callInInFourWeeks");
            return (Criteria) this;
        }

        public Criteria andCallInInFourWeeksIn(List<Integer> values) {
            addCriterion("call_in_in_four_weeks in", values, "callInInFourWeeks");
            return (Criteria) this;
        }

        public Criteria andCallInInFourWeeksNotIn(List<Integer> values) {
            addCriterion("call_in_in_four_weeks not in", values, "callInInFourWeeks");
            return (Criteria) this;
        }

        public Criteria andCallInInFourWeeksBetween(Integer value1, Integer value2) {
            addCriterion("call_in_in_four_weeks between", value1, value2, "callInInFourWeeks");
            return (Criteria) this;
        }

        public Criteria andCallInInFourWeeksNotBetween(Integer value1, Integer value2) {
            addCriterion("call_in_in_four_weeks not between", value1, value2, "callInInFourWeeks");
            return (Criteria) this;
        }

        public Criteria andCallOutInFourWeeksIsNull() {
            addCriterion("call_out_in_four_weeks is null");
            return (Criteria) this;
        }

        public Criteria andCallOutInFourWeeksIsNotNull() {
            addCriterion("call_out_in_four_weeks is not null");
            return (Criteria) this;
        }

        public Criteria andCallOutInFourWeeksEqualTo(Integer value) {
            addCriterion("call_out_in_four_weeks =", value, "callOutInFourWeeks");
            return (Criteria) this;
        }

        public Criteria andCallOutInFourWeeksNotEqualTo(Integer value) {
            addCriterion("call_out_in_four_weeks <>", value, "callOutInFourWeeks");
            return (Criteria) this;
        }

        public Criteria andCallOutInFourWeeksGreaterThan(Integer value) {
            addCriterion("call_out_in_four_weeks >", value, "callOutInFourWeeks");
            return (Criteria) this;
        }

        public Criteria andCallOutInFourWeeksGreaterThanOrEqualTo(Integer value) {
            addCriterion("call_out_in_four_weeks >=", value, "callOutInFourWeeks");
            return (Criteria) this;
        }

        public Criteria andCallOutInFourWeeksLessThan(Integer value) {
            addCriterion("call_out_in_four_weeks <", value, "callOutInFourWeeks");
            return (Criteria) this;
        }

        public Criteria andCallOutInFourWeeksLessThanOrEqualTo(Integer value) {
            addCriterion("call_out_in_four_weeks <=", value, "callOutInFourWeeks");
            return (Criteria) this;
        }

        public Criteria andCallOutInFourWeeksIn(List<Integer> values) {
            addCriterion("call_out_in_four_weeks in", values, "callOutInFourWeeks");
            return (Criteria) this;
        }

        public Criteria andCallOutInFourWeeksNotIn(List<Integer> values) {
            addCriterion("call_out_in_four_weeks not in", values, "callOutInFourWeeks");
            return (Criteria) this;
        }

        public Criteria andCallOutInFourWeeksBetween(Integer value1, Integer value2) {
            addCriterion("call_out_in_four_weeks between", value1, value2, "callOutInFourWeeks");
            return (Criteria) this;
        }

        public Criteria andCallOutInFourWeeksNotBetween(Integer value1, Integer value2) {
            addCriterion("call_out_in_four_weeks not between", value1, value2, "callOutInFourWeeks");
            return (Criteria) this;
        }

        public Criteria andCallInPhonesInFourWeeksIsNull() {
            addCriterion("call_in_phones_in_four_weeks is null");
            return (Criteria) this;
        }

        public Criteria andCallInPhonesInFourWeeksIsNotNull() {
            addCriterion("call_in_phones_in_four_weeks is not null");
            return (Criteria) this;
        }

        public Criteria andCallInPhonesInFourWeeksEqualTo(Integer value) {
            addCriterion("call_in_phones_in_four_weeks =", value, "callInPhonesInFourWeeks");
            return (Criteria) this;
        }

        public Criteria andCallInPhonesInFourWeeksNotEqualTo(Integer value) {
            addCriterion("call_in_phones_in_four_weeks <>", value, "callInPhonesInFourWeeks");
            return (Criteria) this;
        }

        public Criteria andCallInPhonesInFourWeeksGreaterThan(Integer value) {
            addCriterion("call_in_phones_in_four_weeks >", value, "callInPhonesInFourWeeks");
            return (Criteria) this;
        }

        public Criteria andCallInPhonesInFourWeeksGreaterThanOrEqualTo(Integer value) {
            addCriterion("call_in_phones_in_four_weeks >=", value, "callInPhonesInFourWeeks");
            return (Criteria) this;
        }

        public Criteria andCallInPhonesInFourWeeksLessThan(Integer value) {
            addCriterion("call_in_phones_in_four_weeks <", value, "callInPhonesInFourWeeks");
            return (Criteria) this;
        }

        public Criteria andCallInPhonesInFourWeeksLessThanOrEqualTo(Integer value) {
            addCriterion("call_in_phones_in_four_weeks <=", value, "callInPhonesInFourWeeks");
            return (Criteria) this;
        }

        public Criteria andCallInPhonesInFourWeeksIn(List<Integer> values) {
            addCriterion("call_in_phones_in_four_weeks in", values, "callInPhonesInFourWeeks");
            return (Criteria) this;
        }

        public Criteria andCallInPhonesInFourWeeksNotIn(List<Integer> values) {
            addCriterion("call_in_phones_in_four_weeks not in", values, "callInPhonesInFourWeeks");
            return (Criteria) this;
        }

        public Criteria andCallInPhonesInFourWeeksBetween(Integer value1, Integer value2) {
            addCriterion("call_in_phones_in_four_weeks between", value1, value2, "callInPhonesInFourWeeks");
            return (Criteria) this;
        }

        public Criteria andCallInPhonesInFourWeeksNotBetween(Integer value1, Integer value2) {
            addCriterion("call_in_phones_in_four_weeks not between", value1, value2, "callInPhonesInFourWeeks");
            return (Criteria) this;
        }

        public Criteria andCallOutPhonesInFourWeeksIsNull() {
            addCriterion("call_out_phones_in_four_weeks is null");
            return (Criteria) this;
        }

        public Criteria andCallOutPhonesInFourWeeksIsNotNull() {
            addCriterion("call_out_phones_in_four_weeks is not null");
            return (Criteria) this;
        }

        public Criteria andCallOutPhonesInFourWeeksEqualTo(Integer value) {
            addCriterion("call_out_phones_in_four_weeks =", value, "callOutPhonesInFourWeeks");
            return (Criteria) this;
        }

        public Criteria andCallOutPhonesInFourWeeksNotEqualTo(Integer value) {
            addCriterion("call_out_phones_in_four_weeks <>", value, "callOutPhonesInFourWeeks");
            return (Criteria) this;
        }

        public Criteria andCallOutPhonesInFourWeeksGreaterThan(Integer value) {
            addCriterion("call_out_phones_in_four_weeks >", value, "callOutPhonesInFourWeeks");
            return (Criteria) this;
        }

        public Criteria andCallOutPhonesInFourWeeksGreaterThanOrEqualTo(Integer value) {
            addCriterion("call_out_phones_in_four_weeks >=", value, "callOutPhonesInFourWeeks");
            return (Criteria) this;
        }

        public Criteria andCallOutPhonesInFourWeeksLessThan(Integer value) {
            addCriterion("call_out_phones_in_four_weeks <", value, "callOutPhonesInFourWeeks");
            return (Criteria) this;
        }

        public Criteria andCallOutPhonesInFourWeeksLessThanOrEqualTo(Integer value) {
            addCriterion("call_out_phones_in_four_weeks <=", value, "callOutPhonesInFourWeeks");
            return (Criteria) this;
        }

        public Criteria andCallOutPhonesInFourWeeksIn(List<Integer> values) {
            addCriterion("call_out_phones_in_four_weeks in", values, "callOutPhonesInFourWeeks");
            return (Criteria) this;
        }

        public Criteria andCallOutPhonesInFourWeeksNotIn(List<Integer> values) {
            addCriterion("call_out_phones_in_four_weeks not in", values, "callOutPhonesInFourWeeks");
            return (Criteria) this;
        }

        public Criteria andCallOutPhonesInFourWeeksBetween(Integer value1, Integer value2) {
            addCriterion("call_out_phones_in_four_weeks between", value1, value2, "callOutPhonesInFourWeeks");
            return (Criteria) this;
        }

        public Criteria andCallOutPhonesInFourWeeksNotBetween(Integer value1, Integer value2) {
            addCriterion("call_out_phones_in_four_weeks not between", value1, value2, "callOutPhonesInFourWeeks");
            return (Criteria) this;
        }

        public Criteria andMinIntervalWithFriendsIsNull() {
            addCriterion("min_interval_with_friends is null");
            return (Criteria) this;
        }

        public Criteria andMinIntervalWithFriendsIsNotNull() {
            addCriterion("min_interval_with_friends is not null");
            return (Criteria) this;
        }

        public Criteria andMinIntervalWithFriendsEqualTo(Integer value) {
            addCriterion("min_interval_with_friends =", value, "minIntervalWithFriends");
            return (Criteria) this;
        }

        public Criteria andMinIntervalWithFriendsNotEqualTo(Integer value) {
            addCriterion("min_interval_with_friends <>", value, "minIntervalWithFriends");
            return (Criteria) this;
        }

        public Criteria andMinIntervalWithFriendsGreaterThan(Integer value) {
            addCriterion("min_interval_with_friends >", value, "minIntervalWithFriends");
            return (Criteria) this;
        }

        public Criteria andMinIntervalWithFriendsGreaterThanOrEqualTo(Integer value) {
            addCriterion("min_interval_with_friends >=", value, "minIntervalWithFriends");
            return (Criteria) this;
        }

        public Criteria andMinIntervalWithFriendsLessThan(Integer value) {
            addCriterion("min_interval_with_friends <", value, "minIntervalWithFriends");
            return (Criteria) this;
        }

        public Criteria andMinIntervalWithFriendsLessThanOrEqualTo(Integer value) {
            addCriterion("min_interval_with_friends <=", value, "minIntervalWithFriends");
            return (Criteria) this;
        }

        public Criteria andMinIntervalWithFriendsIn(List<Integer> values) {
            addCriterion("min_interval_with_friends in", values, "minIntervalWithFriends");
            return (Criteria) this;
        }

        public Criteria andMinIntervalWithFriendsNotIn(List<Integer> values) {
            addCriterion("min_interval_with_friends not in", values, "minIntervalWithFriends");
            return (Criteria) this;
        }

        public Criteria andMinIntervalWithFriendsBetween(Integer value1, Integer value2) {
            addCriterion("min_interval_with_friends between", value1, value2, "minIntervalWithFriends");
            return (Criteria) this;
        }

        public Criteria andMinIntervalWithFriendsNotBetween(Integer value1, Integer value2) {
            addCriterion("min_interval_with_friends not between", value1, value2, "minIntervalWithFriends");
            return (Criteria) this;
        }

        public Criteria andSelfCallInNinetyDaysIsNull() {
            addCriterion("self_call_in_ninety_days is null");
            return (Criteria) this;
        }

        public Criteria andSelfCallInNinetyDaysIsNotNull() {
            addCriterion("self_call_in_ninety_days is not null");
            return (Criteria) this;
        }

        public Criteria andSelfCallInNinetyDaysEqualTo(Integer value) {
            addCriterion("self_call_in_ninety_days =", value, "selfCallInNinetyDays");
            return (Criteria) this;
        }

        public Criteria andSelfCallInNinetyDaysNotEqualTo(Integer value) {
            addCriterion("self_call_in_ninety_days <>", value, "selfCallInNinetyDays");
            return (Criteria) this;
        }

        public Criteria andSelfCallInNinetyDaysGreaterThan(Integer value) {
            addCriterion("self_call_in_ninety_days >", value, "selfCallInNinetyDays");
            return (Criteria) this;
        }

        public Criteria andSelfCallInNinetyDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("self_call_in_ninety_days >=", value, "selfCallInNinetyDays");
            return (Criteria) this;
        }

        public Criteria andSelfCallInNinetyDaysLessThan(Integer value) {
            addCriterion("self_call_in_ninety_days <", value, "selfCallInNinetyDays");
            return (Criteria) this;
        }

        public Criteria andSelfCallInNinetyDaysLessThanOrEqualTo(Integer value) {
            addCriterion("self_call_in_ninety_days <=", value, "selfCallInNinetyDays");
            return (Criteria) this;
        }

        public Criteria andSelfCallInNinetyDaysIn(List<Integer> values) {
            addCriterion("self_call_in_ninety_days in", values, "selfCallInNinetyDays");
            return (Criteria) this;
        }

        public Criteria andSelfCallInNinetyDaysNotIn(List<Integer> values) {
            addCriterion("self_call_in_ninety_days not in", values, "selfCallInNinetyDays");
            return (Criteria) this;
        }

        public Criteria andSelfCallInNinetyDaysBetween(Integer value1, Integer value2) {
            addCriterion("self_call_in_ninety_days between", value1, value2, "selfCallInNinetyDays");
            return (Criteria) this;
        }

        public Criteria andSelfCallInNinetyDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("self_call_in_ninety_days not between", value1, value2, "selfCallInNinetyDays");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNull() {
            addCriterion("updated_at is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNotNull() {
            addCriterion("updated_at is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtEqualTo(Date value) {
            addCriterion("updated_at =", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotEqualTo(Date value) {
            addCriterion("updated_at <>", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThan(Date value) {
            addCriterion("updated_at >", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("updated_at >=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThan(Date value) {
            addCriterion("updated_at <", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThanOrEqualTo(Date value) {
            addCriterion("updated_at <=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIn(List<Date> values) {
            addCriterion("updated_at in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotIn(List<Date> values) {
            addCriterion("updated_at not in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtBetween(Date value1, Date value2) {
            addCriterion("updated_at between", value1, value2, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotBetween(Date value1, Date value2) {
            addCriterion("updated_at not between", value1, value2, "updatedAt");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}