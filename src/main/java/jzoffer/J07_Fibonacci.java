package jzoffer;

import java.util.Arrays;

/**
 * @description: 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。n≤39
 * @author: suyue
 * @time: 2021/1/13 19:45
 */
public class J07_Fibonacci {

    public static int Fib(int n, int[] array) {
        if (n == 0 || n == 1) return n;
        if (array[n] != -1) return array[n];
        return Fib(n - 1, array) + Fib(n - 2, array);
    }
    
    public static int Fibonacci(int n) {
        //方法一：递归
        /*if (n<=1) return n;
        return Fibonacci(n-1)+Fibonacci(n-2);*/

        //方法二：优化递归
        //注意到n<=39，可以用数组存储数列结果，用空间换时间，时间复杂度由2的n次方缩减为n
        int[] array = new int[40];
        Arrays.fill(array, -1);
        return Fib(n, array);

        //方法三：动态规划
        //虽然方法二可以解决此题了，但是如果想让空间继续优化，那就用动态规划，优化掉递归栈空间。
        //方法二是从上往下递归的然后再从下往上回溯的，最后回溯的时候来合并子树从而求得答案。
        //那么动态规划不同的是，不用递归的过程，直接从子树求得答案。过程是从下往上。
        /*int[] ans = new int[40];
        ans[0] = 0;
        ans[1] = 1;
        for (int i = 2; i <= 39; i++) {
            ans[i] = ans[i - 1] + ans[i - 2];
        }
        return ans[n];*/

        //方法四：递推
        //还可以将时间复杂度保持为n的同时，将空间复杂度优化为1
        /*if (n == 0 || n == 1) return n;
        int fn = 0;
        int fn_1 = 1;
        int fn_2 = 0;
        for (int i = 2; i <= n; i++) {
            fn = fn_1 + fn_2;
            fn_2 = fn_1;
            fn_1 = fn;
        }
        return fn;*/
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(Fibonacci(n));
    }

}
