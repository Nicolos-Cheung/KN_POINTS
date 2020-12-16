package zn.leave.domain.leetcode.dp;

/**
 * 最小路径
 * https://leetcode-cn.com/problems/minimum-path-sum/
 * @author ning
 * @date 2020/04/16
 */
public class MinPathSum {


    /**
     * d[i][j]表示走到(i,j)点的最小路径和
     *
     * 状态转移方程：
     *
     * d[i][j] = dp[i][j−1]+grid[i][j]   i=0,j!=0
     *         = dp[i-1][j]+grid[i][j]   i!=0,j=0
     *         = grid[i][j]              i=0,j=0
     *         = min(dp[i-1][j] , dp[i][j-1]) + grid[i][j] i!=0,j!=0
     *
     * tag 动态规划
     * @param grid
     * @return
     */
    public static  int minPathSum(int[][] grid) {

        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) {
                    dp[i][j] = grid[0][0];
                } else if (i == 0 && j != 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if (i != 0 && j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else if (i != 0 && j != 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }

        return dp[m-1][n-1];
    }


    public static void main(String[] args) {
        int[][] arr = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(arr));
    }
}
