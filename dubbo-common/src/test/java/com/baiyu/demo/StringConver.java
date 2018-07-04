package com.baiyu.demo;

import com.baiyu.common.utils.StringUtil;

/**
 * @author baiyu
 * @description: StringConver  字符串反转
 * @date: 2018/7/4
 */
public class StringConver {

    public static void main(String[] args) {
        String str = "结束时间是";
        long beginTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis();
        beginTime = System.currentTimeMillis();
        System.out.println(convert1(str));
        endTime = System.currentTimeMillis();
        System.out.println("convert1====="+(endTime-beginTime));
        beginTime = System.currentTimeMillis();
        System.out.println(convert2(str));
        endTime = System.currentTimeMillis();
        System.out.println("convert2====="+(endTime-beginTime));
        beginTime = System.currentTimeMillis();
        System.out.println(convert3(str));
        endTime = System.currentTimeMillis();
        System.out.println("convert3====="+(endTime-beginTime));
    }


    public static String convert1(String str){
        char[] chars = str.toCharArray();
        String result = "";
        for (int i=chars.length-1;i>=0;i--){
            result += chars[i];
        }
        return result;
    }

    public static String convert2(String str){
        StringBuffer stringBuffer = new StringBuffer(str);
        String result = stringBuffer.reverse().toString();
        return result;
    }

    public static String convert3(String str){
        String result = "";
        for (int i=0;i<str.length();i++){
            result = str.charAt(i)+result;
        }
        return result;
    }
}
