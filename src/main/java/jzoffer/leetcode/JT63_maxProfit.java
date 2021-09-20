package jzoffer.leetcode;

/**
 * @description:
 * @author: suyue
 * @time: 2021/9/11 14:58
 */
public class JT63_maxProfit {

    public int maxProfit(int[] prices) {

        //方法一、暴力法
        //时间复杂度：O(n^2)
        //空间复杂度：O(1)
        /*if (prices==null || prices.length<=1) return 0;
        int max = 0;
        for (int i=0; i<prices.length; i++) {
            for (int j=i+1; j<prices.length; j++) {
                max = Math.max(max, prices[j]-prices[i]);
            }
        }
        return max;*/

        //方法二、贪心法
        //时间复杂度：O(n)
        //空间复杂度：O(1)
        if (prices==null || prices.length<=1) return 0;

        int min = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i=0; i<prices.length; i++) {
            min = Math.min(min, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i]-min);
        }

        return maxProfit;

        //方法三、动态规划（不太好理解，后面再看）

    }

}
