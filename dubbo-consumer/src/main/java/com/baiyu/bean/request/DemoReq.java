package com.baiyu.bean.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author baiyu
 * @description: DemoReq  前端请求服务端封装的参数对象
 * @date: 2018/6/11
 */
@Data
public class DemoReq implements Serializable {
    private static final long serialVersionUID = 7412098028222261372L;

    @ApiModelProperty(value = "姓名",example = "姓名")
    private String name;
    @ApiModelProperty(value = "年龄",example = "10")
    private int age;
}
