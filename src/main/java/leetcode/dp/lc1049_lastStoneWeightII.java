package leetcode.dp;

/**
 * @description:
 * @author: suyue
 * @time: 2021/8/6 1:36
 */
public class lc1049_lastStoneWeightII {

    public int lastStoneWeightII(int[] stones) {

        /**
         * 思路：物品stones[i], 背包容量sum/2, 挑选若干物品使得背包中的数和最大。01背包，最值型
         *
         * 动态规划（01背包，最值型）
         *
         * dp[j]的含义：物品stones[i], 背包容量j, 挑选若干物品使得背包中的数和最大为dp[j]
         * 状态方程：dp[j]=max{dp[j], dp[j-stones[i]]+stones[i]}
         * 初始条件：dp[0]=0
         * 计算顺序：外层物品从小到大，内层背包从大到小
         *
         */

        int sum = 0;
        for (int i = 0; i < stones.length; i++) {
            sum = sum + stones[i];
        }

        int target = sum / 2;

        int[] dp = new int[target + 1];
        dp[0] = 0;
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }

        return sum - 2 * dp[target];
    }

}
