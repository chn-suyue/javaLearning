package leetcode.dp;

/**
 * @description:
 * @author: suyue
 * @time: 2021/8/5 1:03
 */
public class lc96_numTrees {

    public int numTrees(int n) {
        /**
         * 动态规划（计数型）
         *
         * dp[i]的含义：1到i的正整数之间，能组成的二叉搜索树有dp[i]种
         * 状态方程：dp[i]=sum{dp[j-1]*dp[i-j]}, 1<=j<=i
         * 初始条件：dp[0]=1, dp[1]=1
         * 计算顺序：从小到大
         *
         * 时间复杂度：O(n^2)
         * 空间复杂度：O(n)
         */
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = dp[i] + dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }

}
