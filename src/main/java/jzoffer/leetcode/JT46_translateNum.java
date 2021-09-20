package jzoffer.leetcode;

/**
 * @description:
 * @author: suyue
 * @time: 2021/9/11 16:58
 */
public class JT46_translateNum {

    public int translateNum(int num) {
        //动态规划（计数型）
        //dp[i]的含义
        //状态方程：当 Integer.valueOf(str.substring(i-1,i+1)) >25 时，dp[i]=dp[i-1]
        //         当 Integer.valueOf(str.substring(i-1,i+1)) <=25 时，dp[i]=dp[i-1]+dp[i-2]
        //初始条件：dp[0]=1, dp[1]=1或者2，需要根据这两个数是否大于25来判断
        //计算顺序：从小到大

        String str = String.valueOf(num);
        if (str.length()==1) return 1;

        int[] dp = new int[str.length()];
        dp[0]=1;
        if (Integer.valueOf(str.substring(0,2)) > 25) {
            dp[1]=1;
        } else {
            dp[1]=2;
        }
        if (str.length()==2) return dp[1];

        for (int i=2; i<str.length(); i++) {
            if (Integer.valueOf(str.substring(i-1,i+1)) > 25 || Integer.valueOf(str.substring(i-1,i))==0) {
                dp[i]=dp[i-1];
            } else {
                dp[i]=dp[i-1]+dp[i-2];
            }
        }

        return dp[str.length()-1];

    }

}
