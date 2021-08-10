package leetcode.dp;

/**
 * @description:
 * @author: suyue
 * @time: 2021/8/9 1:16
 */
public class lc474_findMaxForm {

    public int findMaxForm(String[] strs, int m, int n) {
        /**
         * 思路：物品 strs[i], 背包有两个，一个容量为m，另一个容量为n。挑选若干个物品，使得0的个数最多为m，1的个数最多为n。
         *      求满足条件的最大子集的大小为多少。 01背包，最值型，难点在于有两个背包，怎么处理？用二维数组
         *
         * 动态规划（01背包，最值型）
         *
         * dp[p][q]的含义：物品 strs[i], 背包有两个，一个容量为p，另一个容量为q。挑选若干个物品，使得0的个数最多为p，1的个数最多为q。
         *      求满足条件的最大子集的大小为dp[p][q]。
         * 状态方程：dp[p][q]=max{dp[p][q], dp[p-zeroNums[i]][q-oneNums[i]]+1}
         * 初始条件：dp[0][0]=0
         * 计算顺序：外层物品从小到大，内层背包从大到小
         *
         * 时间复杂度：O(i*m*n)
         * 空间复杂度：O(m+n)
         */

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < strs.length; i++) {
            int zeroNum = 0;
            int oneNum = 0;
            char[] chars = strs[i].toCharArray();
            for (int k = 0; k < chars.length; k++) {
                if (chars[k] == '0') zeroNum++;
                if (chars[k] == '1') oneNum++;
            }
            for (int p = m; p >= 0; p--) {
                for (int q = n; q >= 0; q--) {
                    if (p >= zeroNum && q >= oneNum) {
                        dp[p][q] = Math.max(dp[p][q], dp[p - zeroNum][q - oneNum] + 1);
                    }
                }
            }
        }

        return dp[m][n];

    }

}
