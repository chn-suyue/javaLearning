package jzoffer.leetcode;

/**
 * @description:
 * @author: suyue
 * @time: 2021/12/30 20:23
 */
public class JT65_add {

    public int add(int a, int b) {
        //思路：
        while (b != 0) {
            //进位
            int c = (a & b) << 1;
            //本位
            a = a ^ b;
            b = c;
        }



        return a;
    }

}
