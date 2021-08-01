package jzoffer3;

/**
 * @description:
 * @author: suyue
 * @time: 2021/7/21 0:05
 */
public class J67_cutRope {

    public static int cutRope(int target) {
        //最值问题：动态规划
        //转移方程：f(n)=max{k*f(n-k)}, 1<=k<=n-1
        //初始条件：f(1)=1, f(2)=2, f(3)=3, f(4)=4
        //计算顺序：从1到n
        //注意：因为绳子至少要剪成两段，所以当n<=3时，实际值和转移方程的初始值不一样：f(1)=0, f(2)=1, f(3)=2
        if (target <= 1) return 0;
        if (target == 2) return 1;
        if (target == 3) return 2;
        return helpCutRope(target);
    }

    private static int helpCutRope(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= 4; i++) {
            dp[i] = i;
        }
        for (int i=5; i<=n; i++) {
            int tempMax = 0;
            //f(i)=max{k*f(i-k)}, 1<=k<=i-1
            for (int k=1; k<=i-1; k++) {
                tempMax = Math.max(tempMax, k*dp[i-k]);
            }
            dp[i] = tempMax;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int target = 8;
        int result = cutRope(target);
        System.out.println(result);
    }

}
