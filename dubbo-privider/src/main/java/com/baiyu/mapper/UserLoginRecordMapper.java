package com.baiyu.mapper;

import com.baiyu.bean.entity.UserLoginRecord;
import com.baiyu.bean.entity.UserLoginRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface UserLoginRecordMapper {
    long countByExample(UserLoginRecordExample example);

    int deleteByExample(UserLoginRecordExample example);

    @Delete({
        "delete from user_login_record",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into user_login_record (uid, ip_address, ",
        "source_type, create_time)",
        "values (#{uid,jdbcType=BIGINT}, #{ipAddress,jdbcType=VARCHAR}, ",
        "#{sourceType,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(UserLoginRecord record);

    int insertSelective(UserLoginRecord record);

    List<UserLoginRecord> selectByExample(UserLoginRecordExample example);

    @Select({
        "select",
        "id, uid, ip_address, source_type, create_time",
        "from user_login_record",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.baiyu.mapper.UserLoginRecordMapper.BaseResultMap")
    UserLoginRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserLoginRecord record, @Param("example") UserLoginRecordExample example);

    int updateByExample(@Param("record") UserLoginRecord record, @Param("example") UserLoginRecordExample example);

    int updateByPrimaryKeySelective(UserLoginRecord record);

    @Update({
        "update user_login_record",
        "set uid = #{uid,jdbcType=BIGINT},",
          "ip_address = #{ipAddress,jdbcType=VARCHAR},",
          "source_type = #{sourceType,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UserLoginRecord record);
}