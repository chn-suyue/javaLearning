package jzoffer2.newcode;

/**
 * @description:
 * @author: suyue
 * @time: 2021/4/11 15:22
 */
public class J67_cutRope {

    public static int cutRope(int target) {
        // 不能被m迷惑，将问题简单化：长度为n的绳子，剪成若干段，求每段长度乘积最大为多少。
        // 最值问题，第一反应就是用动态规划。套娃的地方：最大乘积f(n)=k*f(n-k),k为最后一段绳子长度。所以，即可递归，也动态规划。

        //方法1：递归。
        //递归函数的功能：求长度为n的最大乘积
        //递归终止条件：当n<=4时，f(n)=n
        //单层递归逻辑：当n>4时，f(n)=max{k*f(n-k)},其中k表示最后一段绳子长度，k的取值范围[1,n-1]
        //但是时间复杂度太大，超时了。
        /*if (target<=1) return 0;
        if (target==2) return 1;
        if (target==3) return 2;
        return helpCutRope(target);*/

        //方法2：动态规划。
        //转移方程：f(n)=max{k*f(n-k)},其中k表示最后一段绳子长度，k的取值范围[1,n-1]
        //初始条件：当n<=4时，f(n)=n
        //计算顺序：n从小到大
        if (target <= 1) return 0;
        if (target == 2) return 1;
        if (target == 3) return 2;
        return helpCutRope(target);


        //方法3：纯数学，直接求出函数表达式。

    }

    private static int helpCutRope(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= 4; i++) {
            dp[i] = i;
        }
        for (int j = 5; j <= n; j++) {
            int tempMax = 0;
            for (int k = 1; k <= j - 1; k++) {
                tempMax = Math.max(tempMax, k * dp[j - k]);
            }
            dp[j]=tempMax;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int target = 8;
        int result = cutRope(target);
        System.out.println(result);
    }

}
