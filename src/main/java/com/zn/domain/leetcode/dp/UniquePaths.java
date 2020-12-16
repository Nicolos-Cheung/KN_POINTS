package com.zn.domain.leetcode.dp;

/**
 *
 * 不同路径
 * https://leetcode-cn.com/problems/unique-paths/
 *
 * 状态转移方程：
 * d[i][j]  =   dp[i-1][j] + dp[i][j-1]  (i!=0 & j!=0)
 *
 *
 * tag 动态规划
 * @author ning
 * @date 2020/04/15
 */
public class UniquePaths {

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 2));
    }

    public static int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];

        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0 && j==0){
                    continue;
                }
                dp[i][j] = (dp[i][j - 1 >= 0 ? j - 1 : 0]) + dp[i - 1 >= 0 ? i - 1 : 0][j];
            }
        }

        return dp[m - 1][n - 1];
    }
}
