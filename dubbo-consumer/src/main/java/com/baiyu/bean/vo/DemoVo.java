package com.baiyu.bean.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author baiyu
 * @description: DemoVo  服务端返回给前端的数据封装对象
 * @date: 2018/6/11
 */
@Data
//@ApiModel(value = "DemoVo返回",description = "DemoVo返回对象")
public class DemoVo implements Serializable {
    private static final long serialVersionUID = 6110323865963342173L;

    @ApiModelProperty(value = "姓名", name = "name")
    private String name;
    @ApiModelProperty(value = "年龄",name = "age")
    private int age;
}
