package com.baiyu.common.utils;

import com.alibaba.dubbo.common.utils.StringUtils;

/**
 * @author baiyu
 * @description: StringUtil  字符串工具类
 * @date: 2018/6/5
 */
public class StringUtil {

    public static boolean isEmpty(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        return false;
    }

    public static boolean isNotEmpty(String str) {
        if (null != str && str.length() > 0) {
            return true;
        }
        return false;
    }
}
