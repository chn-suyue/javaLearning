package leetcode.dp;

/**
 * @description:
 * @author: suyue
 * @time: 2021/8/7 15:25
 */
public class lc494_findTargetSumWays {

    public int findTargetSumWays(int[] nums, int target) {
        /**
         * 思路：转换下思维，假设正号数之和为x，负号数之和为y，那么 x-y=target, x+y=sum, 则：x=(sum+target)/2
         *      所以，此题可以转化为：物品 nums[i]，背包容量(sum+target)/2，挑选若干物品使得背包装满有多少种方法。
         *      01背包，计数型问题
         *
         * 动态规划（01背包，计数型）
         *
         * dp[j]的含义：物品 nums[i]，背包容量为j，挑选若干物品使得背包装满有dp[j]种方法
         * 状态方程：dp[j]=dp[j]+dp[j-nums[i]]
         * 初始条件：dp[0] = 1, 理解：当背包容量为0时，装满背包只有一种方法，就是什么都不装；dp[0]不能为0，否则所有结果都是0了。
         * 计算顺序：外层物品从小到大，内层背包从大到小
         *
         * 时间复杂度：O(n^2)
         * 空间复杂度：O(n)
         *
         */

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }

        if ((sum + target) % 2 == 1) return 0;

        int goal = (sum + target) / 2;
        int[] dp = new int[goal + 1];

        dp[0] = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = goal; j >= nums[i]; j--) {
                dp[j] = dp[j] + dp[j - nums[i]];
            }
        }

        return dp[goal];

    }

}
