package com.cbdic.mapper;

import com.cbdic.entity.CallLog;
import com.cbdic.entity.CallLogExample;
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

public interface CallLogMapper {
    @SelectProvider(type=CallLogSqlProvider.class, method="countByExample")
    int countByExample(CallLogExample example);

    @DeleteProvider(type=CallLogSqlProvider.class, method="deleteByExample")
    int deleteByExample(CallLogExample example);

    @Delete({
        "delete from call_log",
        "where call_log_id = #{callLogId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer callLogId);

    @Insert({
        "insert into call_log (call_log_id, uuid, ",
        "device_id, call_type, ",
        "call_time, duration, ",
        "phone, created_at)",
        "values (#{callLogId,jdbcType=INTEGER}, #{uuid,jdbcType=BIGINT}, ",
        "#{deviceId,jdbcType=VARCHAR}, #{callType,jdbcType=TINYINT}, ",
        "#{callTime,jdbcType=TIMESTAMP}, #{duration,jdbcType=INTEGER}, ",
        "#{phone,jdbcType=VARCHAR}, #{createdAt,jdbcType=TIMESTAMP})"
    })
    int insert(CallLog record);

    @InsertProvider(type=CallLogSqlProvider.class, method="insertSelective")
    int insertSelective(CallLog record);

    @SelectProvider(type=CallLogSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="call_log_id", property="callLogId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="uuid", property="uuid", jdbcType=JdbcType.BIGINT),
        @Result(column="device_id", property="deviceId", jdbcType=JdbcType.VARCHAR),
        @Result(column="call_type", property="callType", jdbcType=JdbcType.TINYINT),
        @Result(column="call_time", property="callTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="duration", property="duration", jdbcType=JdbcType.INTEGER),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP)
    })
    List<CallLog> selectByExample(CallLogExample example);

    @Select({
        "select",
        "call_log_id, uuid, device_id, call_type, call_time, duration, phone, created_at",
        "from call_log",
        "where call_log_id = #{callLogId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="call_log_id", property="callLogId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="uuid", property="uuid", jdbcType=JdbcType.BIGINT),
        @Result(column="device_id", property="deviceId", jdbcType=JdbcType.VARCHAR),
        @Result(column="call_type", property="callType", jdbcType=JdbcType.TINYINT),
        @Result(column="call_time", property="callTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="duration", property="duration", jdbcType=JdbcType.INTEGER),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP)
    })
    CallLog selectByPrimaryKey(Integer callLogId);

    @UpdateProvider(type=CallLogSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CallLog record, @Param("example") CallLogExample example);

    @UpdateProvider(type=CallLogSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CallLog record, @Param("example") CallLogExample example);

    @UpdateProvider(type=CallLogSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CallLog record);

    @Update({
        "update call_log",
        "set uuid = #{uuid,jdbcType=BIGINT},",
          "device_id = #{deviceId,jdbcType=VARCHAR},",
          "call_type = #{callType,jdbcType=TINYINT},",
          "call_time = #{callTime,jdbcType=TIMESTAMP},",
          "duration = #{duration,jdbcType=INTEGER},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "created_at = #{createdAt,jdbcType=TIMESTAMP}",
        "where call_log_id = #{callLogId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CallLog record);
}