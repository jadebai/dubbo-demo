package com.baiyu.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baiyu.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author baiyu
 * @description: DemoController
 * @date: 2018/5/16
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService demoServiceImpl;

    @RequestMapping("/sayHello")
    public Object sayHello() {
        return demoServiceImpl.sayHello("baiyu");
    }
}
