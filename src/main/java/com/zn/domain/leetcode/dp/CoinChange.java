package com.zn.domain.leetcode.dp;

import java.util.Arrays;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/12/23
 */
public class CoinChange {


    public static void main(String[] args) {

        int []arr = new int[]{1,2,5};

        int i = coinChange(arr, 11);

        System.out.println(i);
    }

    public static int coinChange(int[] coins, int amount) {

        Arrays.sort(coins);
        int count=0;

        for (int i = coins.length - 1; i >= 0; i--) {

            while (amount >= coins[i]) {
                amount -= coins[i];
                count++;
            }
        }

        if(amount>0){
            return -1;
        }
        return count;
    }
}
