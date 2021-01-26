package com.zn.domain.leetcode.test;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/12/07
 */
public class Test3 {

    public static void main(String[] args) {


        System.out.println(fib(2));

    }

    public static int fib(int n) {

        if (n < 2) {
            return n;
        }
        int slow = 0;
        int fast = 1;
        int now = 0;
        for (int i = 2; i < n + 1; i++) {
            now = slow + fast;
            slow = fast;
            fast = now;

        }
        return now;
    }


}
