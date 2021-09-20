package jzoffer.leetcode;

/**
 * @description:
 * @author: suyue
 * @time: 2021/9/20 17:11
 */
public class JT58_reverseWords {

    public String reverseWords(String s) {
        //方法一：空格分割，从后往前拼接字符串即可。使用了 split() 方法，面试时不建议
        /*if (s==null || s.equals("")) return s;

        StringBuilder sb = new StringBuilder();
        String str = s.trim();
        String[] split = str.split(" ");

        for (int i=split.length-1; i>=0; i--) {
            if (!split[i].equals("")) {
                sb.append(split[i]);
                if (i>0) {
                    sb.append(" ");
                }
            }
        }

        return sb.toString();*/

        //方法二、双指针
        if (s==null || s.equals("")) return s;

        int left = s.length()-1;
        int right = s.length()-1;
        StringBuilder sb = new StringBuilder();

        while (left>=0) {
            while (left>=0 && s.charAt(left)!=' ') left--;
            sb.append(s.substring(left+1, right+1)+" ");
            while (left>=0 && s.charAt(left)==' ') left--;
            right = left;
        }

        return sb.toString().trim();

    }

}
