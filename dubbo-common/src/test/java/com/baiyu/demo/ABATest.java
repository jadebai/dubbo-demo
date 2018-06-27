package com.baiyu.demo;

import java.awt.geom.FlatteningPathIterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author baiyu
 * @description: ABATest   CAS机制的ABA问题
 * @date: 2018/6/27
 */
public class ABATest {
    private static AtomicInteger num = new AtomicInteger(10);
    private static AtomicStampedReference num2 = new AtomicStampedReference(10,0);
    public static void main(String[] args) {
        casAtomicInteger();
        casAtomicStampedReference();
    }

    public static void casAtomicInteger(){
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                num.compareAndSet(10,11);
                num.compareAndSet(11,10);
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                }catch (Exception e){

                }
                boolean flag = num.compareAndSet(10,11);
                System.out.println(flag);
            }
        });
        thread1.start();
        thread2.start();
    }


    public static void casAtomicStampedReference(){
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10);
                }catch (Exception e){

                }
                num2.compareAndSet(10,11,num2.getStamp(),num2.getStamp()+1);
                num2.compareAndSet(11,10,num2.getStamp(),num2.getStamp()+1);
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int stamp = num2.getStamp();
                System.out.println("before stamp=="+stamp);
                try {
                    Thread.sleep(100);
                }catch (Exception e){

                }
                System.out.println("after stamp=="+num2.getStamp());
                boolean flag2 = num2.compareAndSet(10,11,stamp,stamp+1);
                System.out.println(flag2);
            }
        });
        thread1.start();
        thread2.start();
    }
}

