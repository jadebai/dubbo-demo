package com.baiyu.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baiyu.bean.request.DemoReq;
import com.baiyu.bean.vo.DemoVo;
import com.baiyu.service.DemoService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author baiyu
 * @description: DemoController
 * @date: 2018/5/16
 */
@RestController
@RequestMapping("/demo")
@Api(value = "/demo", description = "Demo演示Controller")
public class DemoController {

    @Autowired
    private DemoService demoServiceImpl;

    @GetMapping("/sayHello")
    @ApiOperation(value = "/sayHello",notes = "说你好")
    @ApiImplicitParam(name = "name",value = "名称",required = true,dataType = "String")
    public String sayHello(String name) {
        checkNotNull(name,"name is not null");
        return demoServiceImpl.sayHello(name);
    }

    @PostMapping("/demo")
    @ApiOperation(value = "demo测试",notes = "demo测试")
    @ApiImplicitParam(value = "请求实体类", name = "demoReq",dataType = "DemoReq",required = true)
    public DemoVo demo(@RequestBody DemoReq demoReq) {
        DemoVo demoVo = new DemoVo();
        demoVo.setName(demoReq.getName());
        demoVo.setAge(demoReq.getAge());
        return demoVo;
    }
}
