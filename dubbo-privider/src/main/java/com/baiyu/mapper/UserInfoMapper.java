package com.baiyu.mapper;

import com.baiyu.bean.entity.UserInfo;
import com.baiyu.bean.entity.UserInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface UserInfoMapper {
    long countByExample(UserInfoExample example);

    int deleteByExample(UserInfoExample example);

    @Delete({
        "delete from user_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into user_info (uid, nick_name, ",
        "head_img, head_img_url, ",
        "real_name, phone, ",
        "email, qq, wechat, ",
        "province, city, ",
        "county, village, ",
        "address_detail, create_time, ",
        "update_time, deleted)",
        "values (#{uid,jdbcType=BIGINT}, #{nickName,jdbcType=VARCHAR}, ",
        "#{headImg,jdbcType=BIGINT}, #{headImgUrl,jdbcType=VARCHAR}, ",
        "#{realName,jdbcType=VARCHAR}, #{phone,jdbcType=VARCHAR}, ",
        "#{email,jdbcType=VARCHAR}, #{qq,jdbcType=VARCHAR}, #{wechat,jdbcType=VARCHAR}, ",
        "#{province,jdbcType=INTEGER}, #{city,jdbcType=INTEGER}, ",
        "#{county,jdbcType=INTEGER}, #{village,jdbcType=INTEGER}, ",
        "#{addressDetail,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{deleted,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    List<UserInfo> selectByExample(UserInfoExample example);

    @Select({
        "select",
        "id, uid, nick_name, head_img, head_img_url, real_name, phone, email, qq, wechat, ",
        "province, city, county, village, address_detail, create_time, update_time, deleted",
        "from user_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.baiyu.mapper.UserInfoMapper.BaseResultMap")
    UserInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    int updateByExample(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    int updateByPrimaryKeySelective(UserInfo record);

    @Update({
        "update user_info",
        "set uid = #{uid,jdbcType=BIGINT},",
          "nick_name = #{nickName,jdbcType=VARCHAR},",
          "head_img = #{headImg,jdbcType=BIGINT},",
          "head_img_url = #{headImgUrl,jdbcType=VARCHAR},",
          "real_name = #{realName,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "qq = #{qq,jdbcType=VARCHAR},",
          "wechat = #{wechat,jdbcType=VARCHAR},",
          "province = #{province,jdbcType=INTEGER},",
          "city = #{city,jdbcType=INTEGER},",
          "county = #{county,jdbcType=INTEGER},",
          "village = #{village,jdbcType=INTEGER},",
          "address_detail = #{addressDetail,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "deleted = #{deleted,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UserInfo record);
}