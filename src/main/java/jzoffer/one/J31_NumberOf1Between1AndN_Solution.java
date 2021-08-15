package jzoffer.one;

/**
 * @description:
 * @author: suyue
 * @time: 2021/3/6 17:20
 */
public class J31_NumberOf1Between1AndN_Solution {

    public static int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for (int i = 0; i <= n; i++) {
            count += numberOf1n(i);
        }
        return count;
    }

    private static int numberOf1n(int n) {
        int count = 0;
        String str = String.valueOf(n);
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN_Solution(13));
    }

}
