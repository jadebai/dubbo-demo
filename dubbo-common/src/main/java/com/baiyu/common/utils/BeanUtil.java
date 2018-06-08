package com.baiyu.common.utils;

/**
 * @author baiyu
 * @description: BeanUtil  对象的操作工具类
 * @date: 2018/6/5
 */
public class BeanUtil {


    public static boolean isEmpty(Object object){
        if (null == object){
            return true;
        }
        return false;
    }

    public static boolean isNotEmpty(Object object){
        if (null != object){
            return true;
        }
        return false;
    }
}
