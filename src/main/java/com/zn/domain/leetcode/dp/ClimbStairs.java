package com.zn.domain.leetcode.dp;

/**
 * 爬楼梯
 *
 * f(x) = f(x-2) + f(x-1)
 *
 * @author ning
 * @date 2020/12/18
 */
public class ClimbStairs {


    public int climbStairs(int n) {

        int[] r = new int[n];

        if (n == 1 || n == 2) {
            return n;
        }

        r[0] = 1;
        r[1] = 2;
        for (int i = 2; i < n; i++) {
            r[i] = r[i - 1] + r[i - 2];
        }

        return r[n - 1];
    }


}
