package com.baiyu.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baiyu.bean.request.DemoReq;
import com.baiyu.bean.vo.DemoVo;
import com.baiyu.service.DemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Object sayHello(String name) {
        return demoServiceImpl.sayHello(name);
    }

    @PostMapping("/demo")
    @ApiOperation(value = "/demo",notes = "demo测试")
    public Object demo(@RequestBody @ApiParam(name = "demoReq",value = "传入参数",required = true) DemoReq demoReq) {
        DemoVo demoVo = new DemoVo();
        demoVo.setName(demoReq.getName());
        demoVo.setAge(demoReq.getAge());
        return demoVo;
    }
}
