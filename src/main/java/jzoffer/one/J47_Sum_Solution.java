package jzoffer.one;

/**
 * @description:
 * @author: suyue
 * @time: 2021/3/14 17:37
 */
public class J47_Sum_Solution {

    public int Sum_Solution(int n) {
        //思路：递归，逻辑运算符，短路原理
        boolean flag = n > 0 && (n += Sum_Solution(n - 1)) > 0;
        return n;
    }

}
