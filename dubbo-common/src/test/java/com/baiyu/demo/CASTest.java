package com.baiyu.demo;

import javax.sound.midi.Soundbank;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author baiyu
 * @description: CASTest  CAS测试
 * @date: 2018/6/27
 */
public class CASTest {

    public static AtomicInteger num = new AtomicInteger(0);
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    }catch (Exception e){

                    }
                    for (int j = 0; j < 50; j++) {
                        num.incrementAndGet();
                    }
                }
            }).start();
        }
        try {
            Thread.sleep(1000);
        }catch (Exception e){

        }
        System.out.println(num);
    }
}
