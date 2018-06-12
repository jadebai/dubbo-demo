package com.baiyu.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baiyu.bean.request.DemoReq;
import com.baiyu.bean.vo.DemoVo;
import com.baiyu.service.DemoService;
import io.swagger.annotations.*;
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
    @ApiResponses(value = {@ApiResponse(code = 200, message = "请求成功", response = DemoReq.class) })
    public Object demo(@RequestBody DemoReq demoReq) {
        DemoVo demoVo = new DemoVo();
        demoVo.setName(demoReq.getName());
        demoVo.setAge(demoReq.getAge());
        return demoReq;
    }
}
