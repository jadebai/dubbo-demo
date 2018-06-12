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
@ApiModel(value = "DemoReq参数",description = "DemoReq参数对象")
public class DemoReq implements Serializable {
    private static final long serialVersionUID = 7412098028222261372L;

    @ApiModelProperty(value = "姓名", name = "name",required = true)
    private String name;
    @ApiModelProperty(value = "年龄",name = "age",required = true)
    private int age;
}
