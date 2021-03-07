package jzoffer;

/**
 * @description:
 * @author: suyue
 * @time: 2021/3/7 14:00
 */
public class J33_GetUglyNumber_Solution {

    public static int GetUglyNumber_Solution(int index) {
        //思路：归纳可知，丑数=2^x+3^y+5^z，每个丑数都是由原来的丑数乘以2或3或5得来，第一个丑数为1。可以用一个数组存储丑数，关键是怎么排序且去重。
        if (index <= 0) return 0;
        int p2 = 0, p3 = 0, p5 = 0;
        int[] array = new int[index];
        array[0] = 1;
        for (int i = 1; i < index; i++) {
            array[i] = Math.min(array[p2] * 2, Math.min(array[p3] * 3, array[p5] * 5));
            if (array[i] == array[p2] * 2) p2++;
            if (array[i] == array[p3] * 3) p3++;
            if (array[i] == array[p5] * 5) p5++;
        }
        return array[index - 1];
    }

    public static void main(String[] args) {
        int result = GetUglyNumber_Solution(7);
        System.out.println(result);
    }

}
