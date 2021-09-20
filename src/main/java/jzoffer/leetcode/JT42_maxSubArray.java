package jzoffer.leetcode;

/**
 * @description:
 * @author: suyue
 * @time: 2021/9/11 15:41
 */
public class JT42_maxSubArray {

    public int maxSubArray(int[] nums) {
        //动态规划（最值型）：
        //dp[i]的含义：0-i数组中，包含nums[i]的连续多个数相加的和
        //状态方程：dp[i]=dp[i-1]>0 ? dp[i-1]+nums[i] : nums[i]
        //初始条件：dp[0]=nums[0]
        //计算顺序：从小到大

        if (nums==null || nums.length==0) return 0;

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];

        for (int i=1; i<nums.length; i++) {
            dp[i] = dp[i-1]>0 ? dp[i-1]+nums[i] : nums[i];
            max = Math.max(max, dp[i]);
        }

        return max;

    }

    public static void main(String[] args) {
        String s = "aaa";
        s.contains("a");

        int[] dp = new int[s.length()];
        dp[0]=1;
        int startIndex = 0;
        int max = 0;

        for (int i=1; i<s.length(); i++) {
            if (s.substring(startIndex,i).contains(String.valueOf(s.charAt(i)))) {
                dp[i]=1;
                startIndex=i;
            } else {
                dp[i]=dp[i-1]+1;
            }
            max=Math.max(max, dp[i]);
        }

    }

}
