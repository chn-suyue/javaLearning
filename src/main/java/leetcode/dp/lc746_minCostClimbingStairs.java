package leetcode.dp;

/**
 * @description: 746. 使用最小花费爬楼梯
 * @author: suyue
 * @time: 2021/7/26 0:06
 */
public class lc746_minCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        //达到楼层顶部的最低花费，最值型问题，考虑用动态规划
        //dp[i]含义：到达顶层第i层，最低花费为dp[i]
        //状态方程：dp[i]=min{dp[i-1]+cost[i-1], dp[i-2]+cost[i-2]}
        //初始条件：dp[0]=0,dp[1]=0
        //递归顺序：从0到n
        if (cost == null || cost.length <= 1) return 0;
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }

}
