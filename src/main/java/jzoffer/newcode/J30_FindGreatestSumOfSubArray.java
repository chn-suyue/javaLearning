package jzoffer.newcode;

/**
 * @description:
 * @author: suyue
 * @time: 2021/3/6 15:24
 */
public class J30_FindGreatestSumOfSubArray {

    public static int FindGreatestSumOfSubArray(int[] array) {
        //递归：
        //当n>=1时，f(n)=max(f(n-1)+array[n],array[n])
        //当n=0时，f(n)=array[0]
        //时间复杂度：O(n^2)
        //空间复杂度：O(1)
        /*if (array==null || array.length==0) return 0;
        int max = array[0];
        for (int i=0; i<array.length; i++) {
            max = Math.max(max,rec_subset(array, i));
        }
        return max;*/

        //非递归（动态规划）。一定要明白dp[i]的含义：以array[i]为末尾元素的子数组的和的最大值！
        //时间复杂度：O(n)
        //空间复杂度：O(n)
        if (array == null || array.length == 0) return 0;
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int max = dp[0];
        for (int i = 1; i < array.length; i++) {
            dp[i] = dp[i - 1] > 0 ? array[i] + dp[i - 1] : array[i];
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    private static int rec_subset(int[] array, int n) {
        if (n == 0) return array[0];
        return Math.max(array[n], array[n] + rec_subset(array, n - 1));
    }

    public static void main(String[] args) {
        int[] array = {1, -2, 3, 10, -4, 7, 2, -5};
        int result = FindGreatestSumOfSubArray(array);
        System.out.println(result);

    }


}
