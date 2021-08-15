package leetcode.dp;

/**
 * @description:
 * @author: suyue
 * @time: 2021/8/12 23:00
 */
public class lc322_coinChange {


    public int coinChange(int[] coins, int amount) {

        /**
         * 思路：物品（硬币）coins[i], 背包容量（总金额）amount，凑成总⾦额所需的最少的硬币个数。完全背包，最值型
         *
         * 动态规划（完全背包，最值型）
         *
         * dp[j]的含义：从0到i种硬币中，抽取若干硬币，使得总金额为amount的最少硬币个数为dp[j]
         * 状态方程：dp[j]=min{dp[j], dp[j-coins[i]]+1}
         * 初始条件：dp[0]=0，其余非0下标为最大值
         * 计算顺序：外层物品从小到大，内层背包从小到大
         *
         * 时间复杂度：O(m*n)
         * 空间复杂度：O(n)
         */

        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];

    }


}
