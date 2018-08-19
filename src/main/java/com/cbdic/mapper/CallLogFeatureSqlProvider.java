package com.cbdic.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.cbdic.entity.CallLogFeature;
import com.cbdic.entity.CallLogFeatureExample.Criteria;
import com.cbdic.entity.CallLogFeatureExample.Criterion;
import com.cbdic.entity.CallLogFeatureExample;
import java.util.List;
import java.util.Map;

public class CallLogFeatureSqlProvider {

    public String countByExample(CallLogFeatureExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("call_log_feature");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(CallLogFeatureExample example) {
        BEGIN();
        DELETE_FROM("call_log_feature");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(CallLogFeature record) {
        BEGIN();
        INSERT_INTO("call_log_feature");
        
        if (record.getUuid() != null) {
            VALUES("uuid", "#{uuid,jdbcType=BIGINT}");
        }
        
        if (record.getCallsInNinetyDays() != null) {
            VALUES("calls_in_ninety_days", "#{callsInNinetyDays,jdbcType=INTEGER}");
        }
        
        if (record.getPhonesInNinetyDays() != null) {
            VALUES("phones_in_ninety_days", "#{phonesInNinetyDays,jdbcType=INTEGER}");
        }
        
        if (record.getCallInInFourWeeks() != null) {
            VALUES("call_in_in_four_weeks", "#{callInInFourWeeks,jdbcType=INTEGER}");
        }
        
        if (record.getCallOutInFourWeeks() != null) {
            VALUES("call_out_in_four_weeks", "#{callOutInFourWeeks,jdbcType=INTEGER}");
        }
        
        if (record.getCallInPhonesInFourWeeks() != null) {
            VALUES("call_in_phones_in_four_weeks", "#{callInPhonesInFourWeeks,jdbcType=INTEGER}");
        }
        
        if (record.getCallOutPhonesInFourWeeks() != null) {
            VALUES("call_out_phones_in_four_weeks", "#{callOutPhonesInFourWeeks,jdbcType=INTEGER}");
        }
        
        if (record.getMinIntervalWithFriends() != null) {
            VALUES("min_interval_with_friends", "#{minIntervalWithFriends,jdbcType=INTEGER}");
        }
        
        if (record.getSelfCallInNinetyDays() != null) {
            VALUES("self_call_in_ninety_days", "#{selfCallInNinetyDays,jdbcType=INTEGER}");
        }
        
        if (record.getUpdatedAt() != null) {
            VALUES("updated_at", "#{updatedAt,jdbcType=TIMESTAMP}");
        }
        
        return SQL();
    }

    public String selectByExample(CallLogFeatureExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("uuid");
        } else {
            SELECT("uuid");
        }
        SELECT("calls_in_ninety_days");
        SELECT("phones_in_ninety_days");
        SELECT("call_in_in_four_weeks");
        SELECT("call_out_in_four_weeks");
        SELECT("call_in_phones_in_four_weeks");
        SELECT("call_out_phones_in_four_weeks");
        SELECT("min_interval_with_friends");
        SELECT("self_call_in_ninety_days");
        SELECT("updated_at");
        FROM("call_log_feature");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        CallLogFeature record = (CallLogFeature) parameter.get("record");
        CallLogFeatureExample example = (CallLogFeatureExample) parameter.get("example");
        
        BEGIN();
        UPDATE("call_log_feature");
        
        if (record.getUuid() != null) {
            SET("uuid = #{record.uuid,jdbcType=BIGINT}");
        }
        
        if (record.getCallsInNinetyDays() != null) {
            SET("calls_in_ninety_days = #{record.callsInNinetyDays,jdbcType=INTEGER}");
        }
        
        if (record.getPhonesInNinetyDays() != null) {
            SET("phones_in_ninety_days = #{record.phonesInNinetyDays,jdbcType=INTEGER}");
        }
        
        if (record.getCallInInFourWeeks() != null) {
            SET("call_in_in_four_weeks = #{record.callInInFourWeeks,jdbcType=INTEGER}");
        }
        
        if (record.getCallOutInFourWeeks() != null) {
            SET("call_out_in_four_weeks = #{record.callOutInFourWeeks,jdbcType=INTEGER}");
        }
        
        if (record.getCallInPhonesInFourWeeks() != null) {
            SET("call_in_phones_in_four_weeks = #{record.callInPhonesInFourWeeks,jdbcType=INTEGER}");
        }
        
        if (record.getCallOutPhonesInFourWeeks() != null) {
            SET("call_out_phones_in_four_weeks = #{record.callOutPhonesInFourWeeks,jdbcType=INTEGER}");
        }
        
        if (record.getMinIntervalWithFriends() != null) {
            SET("min_interval_with_friends = #{record.minIntervalWithFriends,jdbcType=INTEGER}");
        }
        
        if (record.getSelfCallInNinetyDays() != null) {
            SET("self_call_in_ninety_days = #{record.selfCallInNinetyDays,jdbcType=INTEGER}");
        }
        
        if (record.getUpdatedAt() != null) {
            SET("updated_at = #{record.updatedAt,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("call_log_feature");
        
        SET("uuid = #{record.uuid,jdbcType=BIGINT}");
        SET("calls_in_ninety_days = #{record.callsInNinetyDays,jdbcType=INTEGER}");
        SET("phones_in_ninety_days = #{record.phonesInNinetyDays,jdbcType=INTEGER}");
        SET("call_in_in_four_weeks = #{record.callInInFourWeeks,jdbcType=INTEGER}");
        SET("call_out_in_four_weeks = #{record.callOutInFourWeeks,jdbcType=INTEGER}");
        SET("call_in_phones_in_four_weeks = #{record.callInPhonesInFourWeeks,jdbcType=INTEGER}");
        SET("call_out_phones_in_four_weeks = #{record.callOutPhonesInFourWeeks,jdbcType=INTEGER}");
        SET("min_interval_with_friends = #{record.minIntervalWithFriends,jdbcType=INTEGER}");
        SET("self_call_in_ninety_days = #{record.selfCallInNinetyDays,jdbcType=INTEGER}");
        SET("updated_at = #{record.updatedAt,jdbcType=TIMESTAMP}");
        
        CallLogFeatureExample example = (CallLogFeatureExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(CallLogFeature record) {
        BEGIN();
        UPDATE("call_log_feature");
        
        if (record.getCallsInNinetyDays() != null) {
            SET("calls_in_ninety_days = #{callsInNinetyDays,jdbcType=INTEGER}");
        }
        
        if (record.getPhonesInNinetyDays() != null) {
            SET("phones_in_ninety_days = #{phonesInNinetyDays,jdbcType=INTEGER}");
        }
        
        if (record.getCallInInFourWeeks() != null) {
            SET("call_in_in_four_weeks = #{callInInFourWeeks,jdbcType=INTEGER}");
        }
        
        if (record.getCallOutInFourWeeks() != null) {
            SET("call_out_in_four_weeks = #{callOutInFourWeeks,jdbcType=INTEGER}");
        }
        
        if (record.getCallInPhonesInFourWeeks() != null) {
            SET("call_in_phones_in_four_weeks = #{callInPhonesInFourWeeks,jdbcType=INTEGER}");
        }
        
        if (record.getCallOutPhonesInFourWeeks() != null) {
            SET("call_out_phones_in_four_weeks = #{callOutPhonesInFourWeeks,jdbcType=INTEGER}");
        }
        
        if (record.getMinIntervalWithFriends() != null) {
            SET("min_interval_with_friends = #{minIntervalWithFriends,jdbcType=INTEGER}");
        }
        
        if (record.getSelfCallInNinetyDays() != null) {
            SET("self_call_in_ninety_days = #{selfCallInNinetyDays,jdbcType=INTEGER}");
        }
        
        if (record.getUpdatedAt() != null) {
            SET("updated_at = #{updatedAt,jdbcType=TIMESTAMP}");
        }
        
        WHERE("uuid = #{uuid,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(CallLogFeatureExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}