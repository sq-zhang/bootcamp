package com.cbdic.mapper;

import com.cbdic.entity.CallLogFeature;
import com.cbdic.entity.CallLogFeatureExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface CallLogFeatureMapper {
    @SelectProvider(type=CallLogFeatureSqlProvider.class, method="countByExample")
    int countByExample(CallLogFeatureExample example);

    @DeleteProvider(type=CallLogFeatureSqlProvider.class, method="deleteByExample")
    int deleteByExample(CallLogFeatureExample example);

    @Delete({
        "delete from call_log_feature",
        "where uuid = #{uuid,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long uuid);

    @Insert({
        "insert into call_log_feature (uuid, calls_in_ninety_days, ",
        "phones_in_ninety_days, call_in_in_four_weeks, ",
        "call_out_in_four_weeks, call_in_phones_in_four_weeks, ",
        "call_out_phones_in_four_weeks, min_interval_with_friends, ",
        "self_call_in_ninety_days, updated_at)",
        "values (#{uuid,jdbcType=BIGINT}, #{callsInNinetyDays,jdbcType=INTEGER}, ",
        "#{phonesInNinetyDays,jdbcType=INTEGER}, #{callInInFourWeeks,jdbcType=INTEGER}, ",
        "#{callOutInFourWeeks,jdbcType=INTEGER}, #{callInPhonesInFourWeeks,jdbcType=INTEGER}, ",
        "#{callOutPhonesInFourWeeks,jdbcType=INTEGER}, #{minIntervalWithFriends,jdbcType=INTEGER}, ",
        "#{selfCallInNinetyDays,jdbcType=INTEGER}, #{updatedAt,jdbcType=TIMESTAMP})"
    })
    int insert(CallLogFeature record);

    @InsertProvider(type=CallLogFeatureSqlProvider.class, method="insertSelective")
    int insertSelective(CallLogFeature record);

    @SelectProvider(type=CallLogFeatureSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="uuid", property="uuid", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="calls_in_ninety_days", property="callsInNinetyDays", jdbcType=JdbcType.INTEGER),
        @Result(column="phones_in_ninety_days", property="phonesInNinetyDays", jdbcType=JdbcType.INTEGER),
        @Result(column="call_in_in_four_weeks", property="callInInFourWeeks", jdbcType=JdbcType.INTEGER),
        @Result(column="call_out_in_four_weeks", property="callOutInFourWeeks", jdbcType=JdbcType.INTEGER),
        @Result(column="call_in_phones_in_four_weeks", property="callInPhonesInFourWeeks", jdbcType=JdbcType.INTEGER),
        @Result(column="call_out_phones_in_four_weeks", property="callOutPhonesInFourWeeks", jdbcType=JdbcType.INTEGER),
        @Result(column="min_interval_with_friends", property="minIntervalWithFriends", jdbcType=JdbcType.INTEGER),
        @Result(column="self_call_in_ninety_days", property="selfCallInNinetyDays", jdbcType=JdbcType.INTEGER),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP)
    })
    List<CallLogFeature> selectByExample(CallLogFeatureExample example);

    @Select({
        "select",
        "uuid, calls_in_ninety_days, phones_in_ninety_days, call_in_in_four_weeks, call_out_in_four_weeks, ",
        "call_in_phones_in_four_weeks, call_out_phones_in_four_weeks, min_interval_with_friends, ",
        "self_call_in_ninety_days, updated_at",
        "from call_log_feature",
        "where uuid = #{uuid,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="uuid", property="uuid", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="calls_in_ninety_days", property="callsInNinetyDays", jdbcType=JdbcType.INTEGER),
        @Result(column="phones_in_ninety_days", property="phonesInNinetyDays", jdbcType=JdbcType.INTEGER),
        @Result(column="call_in_in_four_weeks", property="callInInFourWeeks", jdbcType=JdbcType.INTEGER),
        @Result(column="call_out_in_four_weeks", property="callOutInFourWeeks", jdbcType=JdbcType.INTEGER),
        @Result(column="call_in_phones_in_four_weeks", property="callInPhonesInFourWeeks", jdbcType=JdbcType.INTEGER),
        @Result(column="call_out_phones_in_four_weeks", property="callOutPhonesInFourWeeks", jdbcType=JdbcType.INTEGER),
        @Result(column="min_interval_with_friends", property="minIntervalWithFriends", jdbcType=JdbcType.INTEGER),
        @Result(column="self_call_in_ninety_days", property="selfCallInNinetyDays", jdbcType=JdbcType.INTEGER),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP)
    })
    CallLogFeature selectByPrimaryKey(Long uuid);

    @UpdateProvider(type=CallLogFeatureSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CallLogFeature record, @Param("example") CallLogFeatureExample example);

    @UpdateProvider(type=CallLogFeatureSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CallLogFeature record, @Param("example") CallLogFeatureExample example);

    @UpdateProvider(type=CallLogFeatureSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CallLogFeature record);

    @Update({
        "update call_log_feature",
        "set calls_in_ninety_days = #{callsInNinetyDays,jdbcType=INTEGER},",
          "phones_in_ninety_days = #{phonesInNinetyDays,jdbcType=INTEGER},",
          "call_in_in_four_weeks = #{callInInFourWeeks,jdbcType=INTEGER},",
          "call_out_in_four_weeks = #{callOutInFourWeeks,jdbcType=INTEGER},",
          "call_in_phones_in_four_weeks = #{callInPhonesInFourWeeks,jdbcType=INTEGER},",
          "call_out_phones_in_four_weeks = #{callOutPhonesInFourWeeks,jdbcType=INTEGER},",
          "min_interval_with_friends = #{minIntervalWithFriends,jdbcType=INTEGER},",
          "self_call_in_ninety_days = #{selfCallInNinetyDays,jdbcType=INTEGER},",
          "updated_at = #{updatedAt,jdbcType=TIMESTAMP}",
        "where uuid = #{uuid,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CallLogFeature record);
}