package com.baiyu.demo;




import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author baiyu
 * @description: CheckNotNullTest
 * @date: 2018/6/27
 */
public class CheckNotNullTest {

    public static void main(String[] args) {
        String a = null;
//        checkNotNull(a, "%s不能为空", "a");
//        checkArgument(a != null, "%s不能为null", "a");
//        System.out.println(Objects.equal(a,""));
        System.out.println(MoreObjects.toStringHelper(CheckNotNullTest.class));
    }
}
