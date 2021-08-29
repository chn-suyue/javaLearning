package jzoffer.newcode;

/**
 * @description:
 * @author: suyue
 * @time: 2021/4/5 15:24
 */
public class J67_cutRope {

    public static int cutRope(int target) {
        //方法1：递归。时间复杂度太大了，不行的。
        //递归函数功能：绳子长度为n，分别m段，最大乘积
        //递归终止条件：n等于0，m等于0
        //递归单层逻辑：假设最后一段长度为k，那么最大乘积为：k*helpCutRope(n-k,m-1)
        /*int max = 0;
        for (int m = 2; m <= target; m++) {
            max = Math.max(max, helpCutRope(target, m));
        }
        return max;*/

        //方法2：递归。时间复杂度较方法1小一点。m就是个烟雾弹呀！但是时间复杂度依然太大而超时了！
        //递归函数功能：绳子长度为n的最大乘积
        //递归终止条件：n<=4时，最大乘积为n。
        //递归单层逻辑：假设最后一段长为k，那么最大乘积为：k*helpCutRope(n-k)，k的取值范围[1,n-1]
        /*if (target == 2) return 1;
        if (target == 3) return 2;
        return helpCutRope(target);*/

        //方法3：动态规划。发现递归过程有很多重复计算的过程，那就用数据存下来。
        if (target == 2) return 1;
        if (target == 3) return 2;
        return helpCutRope(target);

    }

    private static int helpCutRope(int n) {
        int[] dp = new int[n+1];
        for (int i = 1; i <= 4; i++) {
            dp[i] = i ;
        }
        for (int i = 5; i < n+1; i++) {
            int tempMax = 0;
            for (int j = 1; j < i; j++) {
                tempMax = Math.max(tempMax, j * dp[i - j]);
            }
            dp[i] = tempMax;
        }
        return dp[n];
    }

    /*private int helpCutRope(int n) {
        if (n <= 4) return n;
        int max = 0;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, i * helpCutRope(n - i));
        }
        return max;
    }*/

    /*private int helpCutRope(int n, int m) {
        if (m == 1) return n;
        int tempMax = 0;
        for (int i = 1; i <= n - m + 1; i++) {
            tempMax = Math.max(tempMax, i * helpCutRope(n - i, m - 1));
        }
        return tempMax;
    }*/

    public static void main(String[] args) {
        int n = 8;
        int result = cutRope(n);
        System.out.println(result);
    }

}
