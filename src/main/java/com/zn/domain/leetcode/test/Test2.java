package com.zn.domain.leetcode.test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/12/07
 */
public class Test2 {

    public static void main(String[] args) {


        Integer res = 0;
        AtomicInteger res1 = new AtomicInteger(0);

        incr(res); //无法引用传递
        incr(res1);

        System.out.println();

    }

    private static void incr(Integer res) {
        res = res + 1;
    }

    private static void incr(AtomicInteger res) {
        res.incrementAndGet();
    }


}
