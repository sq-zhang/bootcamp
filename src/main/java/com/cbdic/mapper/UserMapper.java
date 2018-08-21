package com.cbdic.mapper;

import com.cbdic.entity.User;
import com.cbdic.entity.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface UserMapper {
    @SelectProvider(type=UserSqlProvider.class, method="countByExample")
    int countByExample(UserExample example);

    @DeleteProvider(type=UserSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserExample example);

    @Insert({
        "insert into user (uuid, name, ",
        "phone, id_no, created_at, ",
        "status, score)",
        "values (#{uuid,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR}, ",
        "#{phone,jdbcType=VARCHAR}, #{idNo,jdbcType=VARCHAR}, #{createdAt,jdbcType=TIMESTAMP}, ",
        "#{status,jdbcType=VARCHAR}, #{score,jdbcType=INTEGER})"
    })
    int insert(User record);

    @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    int insertSelective(User record);

    @SelectProvider(type=UserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="uuid", property="uuid", jdbcType=JdbcType.BIGINT),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_no", property="idNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="score", property="score", jdbcType=JdbcType.INTEGER)
    })
    List<User> selectByExample(UserExample example);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    @Select({
        "select",
        "uuid, name, phone, id_no, created_at, status, score",
        "from user",
        "where name like #{name} and ",
        "phone like #{phone} and ",
        "id_no like #{id_no}",
        "limit #{limit}, #{offset}"
    })
    @Results({
        @Result(column="uuid", property="uuid", jdbcType=JdbcType.BIGINT),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_no", property="idNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="score", property="score", jdbcType=JdbcType.INTEGER)
    })
    List<User> selectByExampleWithCondition(UserExample example,
        @Param("limit") Integer limit,
        @Param("offset") Integer offset,
        @Param("name") String name,
        @Param("phone") String phone,
        @Param("id_no") String id_no);
}