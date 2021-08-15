package leetcode.dp;

/**
 * @description:
 * @author: suyue
 * @time: 2021/8/10 23:39
 */
public class lc377_combinationSum4 {

    public int combinationSum4(int[] nums, int target) {

        /**
         * 思路：物品nums[i], 背包容量target，找出和为给定⽬标正整数的组合的个数。完全背包，计数型，考虑排列
         *
         * 动态规划（完全背包，计数型，考虑排列）：
         *
         * dp[j]的含义：从0到i的数组中，选择若干个数使得和为j的排列数为dp[j]
         * 状态方程：dp[j]=dp[j]+dp[j-nums[i]]
         * 初始条件：dp[0]=1
         * 计算顺序：外层背包从小到大，内层物品从大到小
         *
         * 时间复杂度：O(m*n)
         * 空间复杂度：O(n)
         *
         */

        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int j = 1; j <= target; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (j >= nums[i]) {
                    dp[j] = dp[j] + dp[j - nums[i]];
                }
            }
        }

        return dp[target];

    }

}
