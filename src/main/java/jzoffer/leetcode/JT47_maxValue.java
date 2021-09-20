package jzoffer.leetcode;

/**
 * @description:
 * @author: suyue
 * @time: 2021/9/11 16:05
 */
public class JT47_maxValue {

    public int maxValue(int[][] grid) {
        //动态规划（最值型）：
        //dp[i][j]的含义
        //状态方程：dp[i][j]=max{dp[i-1][j], dp[i][j-1]} + grid[i][j]
        //初始条件：dp[0][0]=grid[0][0]
        //计算顺序：从小到大
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = grid[0][0];

        for (int i=1; i<cols; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for (int i=1; i<rows; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for (int i=1; i<rows; i++) {
            for (int j=1; j<cols; j++) {
                dp[i][j]=grid[i][j]+Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[rows-1][cols-1];

    }

}
