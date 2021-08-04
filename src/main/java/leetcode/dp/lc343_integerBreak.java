package leetcode.dp;

/**
 * @description:
 * @author: suyue
 * @time: 2021/8/5 0:30
 */
public class lc343_integerBreak {

    public int integerBreak(int n) {
        /**
         * 动态规划（最值型）
         *
         * dp[i]的含义：对于整数i，其拆分的整数乘积最大为dp[i]
         * 状态方程：dp[i]=max{k*dp[n-k]}, 1<=k<=n-1
         * 初始条件：dp[n]=n, n<=4
         * 计算顺序：从小到大
         *
         * 时间复杂度：O(n^2)
         * 空间复杂度：O(n)
         */
        if (n <= 1) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;
        return helpIntegerBreak(n);
    }

    private int helpIntegerBreak(int n) {

        int[] dp = new int[n + 1];
        for (int i = 1; i <= 4; i++) {
            dp[i] = i;
        }
        for (int i = 5; i <= n; i++) {
            for (int k = 1; k <= i - 1; k++) {
                dp[i] = Math.max(dp[i], k * dp[i - k]);
            }
        }

        return dp[n];
    }


}
