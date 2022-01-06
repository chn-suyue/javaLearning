package jzoffer.leetcode;

/**
 * @description:
 * @author: suyue
 * @time: 2021/12/29 20:45
 */
public class JT15_hammingWeight {

    public int hammingWeight(int n) {
        //方法一：n&(n-1) 每计算一次，少一个1
        /*int count = 0;
        while (n!=0) {
            n = n & (n-1);
            count++;
        }
        return count;*/

        //方法二：n&1 结果可知道最后一位是否为1，然后右移一位，循环计数。注意：Java 无符号右移运算符为：>>>
        int count = 0;
        while (n!=0) {
            int m = n & 1;
            if (m==1) count++;
            n = n >>> 1;
        }
        return count;
    }

}
