package com.baiyu.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author baiyu
 * @description: DemoServiceImpl
 * @date: 2018/5/16
 */
@Component
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        return name + "-say:hello!";
    }
}
