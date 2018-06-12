package com.baiyu.mapper;

import com.baiyu.bean.entity.ReceiveAddress;
import com.baiyu.bean.entity.ReceiveAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface ReceiveAddressMapper {
    long countByExample(ReceiveAddressExample example);

    int deleteByExample(ReceiveAddressExample example);

    @Delete({
        "delete from receive_address",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into receive_address (uid, receiver_name, ",
        "receiver_phone, province, ",
        "city, county, village, ",
        "address_detail, is_default, ",
        "create_time, update_time, ",
        "deleted)",
        "values (#{uid,jdbcType=BIGINT}, #{receiverName,jdbcType=VARCHAR}, ",
        "#{receiverPhone,jdbcType=VARCHAR}, #{province,jdbcType=INTEGER}, ",
        "#{city,jdbcType=INTEGER}, #{county,jdbcType=INTEGER}, #{village,jdbcType=INTEGER}, ",
        "#{addressDetail,jdbcType=VARCHAR}, #{isDefault,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{deleted,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ReceiveAddress record);

    int insertSelective(ReceiveAddress record);

    List<ReceiveAddress> selectByExample(ReceiveAddressExample example);

    @Select({
        "select",
        "id, uid, receiver_name, receiver_phone, province, city, county, village, address_detail, ",
        "is_default, create_time, update_time, deleted",
        "from receive_address",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.baiyu.mapper.ReceiveAddressMapper.BaseResultMap")
    ReceiveAddress selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReceiveAddress record, @Param("example") ReceiveAddressExample example);

    int updateByExample(@Param("record") ReceiveAddress record, @Param("example") ReceiveAddressExample example);

    int updateByPrimaryKeySelective(ReceiveAddress record);

    @Update({
        "update receive_address",
        "set uid = #{uid,jdbcType=BIGINT},",
          "receiver_name = #{receiverName,jdbcType=VARCHAR},",
          "receiver_phone = #{receiverPhone,jdbcType=VARCHAR},",
          "province = #{province,jdbcType=INTEGER},",
          "city = #{city,jdbcType=INTEGER},",
          "county = #{county,jdbcType=INTEGER},",
          "village = #{village,jdbcType=INTEGER},",
          "address_detail = #{addressDetail,jdbcType=VARCHAR},",
          "is_default = #{isDefault,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "deleted = #{deleted,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ReceiveAddress record);
}