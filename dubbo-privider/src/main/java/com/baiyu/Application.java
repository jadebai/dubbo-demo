package com.baiyu;

import javassist.ClassPath;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * @author baiyu
 * @description: Application
 * @date: 2018/5/15
 */
@SpringBootApplication
@ImportResource(locations = {"classpath*:spring/applicationContext-base.xml","classpath*:spring/applicationContext-dubbo.xml"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
