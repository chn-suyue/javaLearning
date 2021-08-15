package leetcode.dp;

/**
 * @description:
 * @author: suyue
 * @time: 2021/8/14 16:42
 */
public class lc279_numSquares {

    public static void main(String[] args) {
        int result = numSquares(12);
        System.out.println(result);
    }

    public static int numSquares(int n) {
        /**
         *
         * 思路：物品nums[i], 背包容量n, 从物品中挑选若干个数使得和为n的方案中，挑选的数的个数最少。 完全背包，最值型
         *
         * dp[j]的含义：从1到i的数中，挑选若干个数使得和为n的方案中，挑选的数的个数最少为dp[j]
         * 状态方程：dp[j]=min{dp[j], dp[j-i^2]+1}
         * 初始条件：dp[0]=0, 其余均为最大整数
         * 计算顺序：外层物品从小到大，内层背包从大到小
         *
         * 时间复杂度：O()
         * 空间复杂度：O()
         *
         */

        int[] dp = new int[n + 1];
        for (int j = 1; j <= n; j++) {
            dp[j] = Integer.MAX_VALUE;
        }

        for (int i = 1; (i * i) <= n; i++) {
            for (int j = i * i; j <= n; j++) {
                if (dp[j - i * i] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                }
            }
        }

        return dp[n];

    }

}
