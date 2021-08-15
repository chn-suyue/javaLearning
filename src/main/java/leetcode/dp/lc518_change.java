package leetcode.dp;

/**
 * @description:
 * @author: suyue
 * @time: 2021/8/10 23:23
 */
public class lc518_change {

    public int change(int amount, int[] coins) {

        /**
         * 思路：物品（硬币）coins[i]，背包容量（总金额）为amount，每种硬币可以选无限个，典型的完全背包问题
         *
         * 动态规划（完全背包，计数型）：
         *
         * dp[j]的含义：从0到i种硬币挑选若干枚，使得总金额为j的方法数为dp[j]种
         * 状态方程：dp[j]=dp[j]+dp[j-coins[i]]
         * 初始条件：dp[0]=1
         * 计算顺序：外层物品从小到大，内层背包从小到大
         *
         * 时间复杂度：O(m*n)
         * 空间复杂度：O(n)
         */

        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }

        return dp[amount];

    }

}
