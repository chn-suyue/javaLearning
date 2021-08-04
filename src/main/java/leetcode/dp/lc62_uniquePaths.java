package leetcode.dp;

/**
 * @description:
 * @author: suyue
 * @time: 2021/8/2 0:37
 */
public class lc62_uniquePaths {


    public static void main(String[] args) {
        int result = uniquePaths(3, 7);
        System.out.println(result);
    }

    public static int uniquePaths(int m, int n) {

        /**
         * 方法一：动态规划（计数型）
         *
         * dp[i][j]的含义：
         *      从坐标(0,0)到坐标(i,j)，总共有dp[i][j]条不同的路径
         * 状态方程：
         *      dp[i][j]=dp[i-1][j]+dp[i][j-1]
         * 初始条件：
         *      dp[0][0]=0
         *      当i=0，j>=1时，dp[i][j]=1
         *      当j=0,i>=1时，dp[i][j]=1
         * 计算顺序：
         *      i, j 均从小到大
         *
         * 时间复杂度：O(m*n)
         * 空间复杂度：O(m*n)
         */

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m-1][n-1];
    }

    //方法二：DFS


}
