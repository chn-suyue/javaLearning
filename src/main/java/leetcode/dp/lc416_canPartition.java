package leetcode.dp;

/**
 * @description:
 * @author: suyue
 * @time: 2021/8/6 1:16
 */
public class lc416_canPartition {

    public boolean canPartition(int[] nums) {
        /**
         * 思路：物品nums[i], 背包容量 0.5*s, 01背包存在型问题
         *
         * 动态规划（01背包，存在型）
         *
         * dp[j]的含义：物品nums[i], 背包容量 0.5*s, 挑选若干物品装入背包，使其和最大为dp[j]
         * 状态方程：dp[j]=max{dp[j], dp[j-nums[i]]+nums[i]}
         * 初始条件：dp[0]=0
         * 计算顺序：外层物品从小到大，内层背包从大到小
         *
         * 时间复杂度：O(n^2)
         * 空间复杂度：O(n)
         */
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        if (sum % 2 == 1) return false;

        int target = sum / 2;
        int[] dp = new int[target + 1];

        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }

        return dp[target] == target;

    }

}
