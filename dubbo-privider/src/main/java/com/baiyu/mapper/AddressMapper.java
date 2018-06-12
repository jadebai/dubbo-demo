package com.baiyu.mapper;

import com.baiyu.bean.entity.Address;
import com.baiyu.bean.entity.AddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface AddressMapper {
    long countByExample(AddressExample example);

    int deleteByExample(AddressExample example);

    @Delete({
        "delete from address",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into address (parent_id, name, ",
        "sort, create_time, ",
        "update_time, deleted)",
        "values (#{parentId,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{sort,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{deleted,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Address record);

    int insertSelective(Address record);

    List<Address> selectByExample(AddressExample example);

    @Select({
        "select",
        "id, parent_id, name, sort, create_time, update_time, deleted",
        "from address",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.baiyu.mapper.AddressMapper.BaseResultMap")
    Address selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Address record, @Param("example") AddressExample example);

    int updateByExample(@Param("record") Address record, @Param("example") AddressExample example);

    int updateByPrimaryKeySelective(Address record);

    @Update({
        "update address",
        "set parent_id = #{parentId,jdbcType=INTEGER},",
          "name = #{name,jdbcType=VARCHAR},",
          "sort = #{sort,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "deleted = #{deleted,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Address record);
}