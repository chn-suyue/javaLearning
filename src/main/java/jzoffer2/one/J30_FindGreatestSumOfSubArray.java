package jzoffer2.one;

/**
 * @description:
 * @author: suyue
 * @time: 2021/7/21 0:49
 */
public class J30_FindGreatestSumOfSubArray {


    public int FindGreatestSumOfSubArray(int[] array) {
        //最值问题：动态规划
        //转移方程：f(n)=max{array[n]+f(n-1), f(n-1)}
        //初始条件：f(1)=array[1]
        //计算顺序：从1到n
        if (array == null || array.length == 0)
            return 0;

        int[] dp = new int[array.length];
        dp[0] = array[0];
        int max = dp[0];
        for (int i = 1; i < array.length; i++) {
            dp[i] = Math.max(array[i] + dp[i - 1], array[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
