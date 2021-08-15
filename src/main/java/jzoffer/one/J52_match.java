package jzoffer.one;

/**
 * @description:
 * @author: suyue
 * @time: 2021/3/21 20:17
 */
public class J52_match {

    public boolean match(String str, String pattern) {
        //思路：分类讨论+递归
        if (pattern.length() == 0) return str.length() == 0;
        boolean match = str.length() > 0 && (str.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.');

        if (pattern.length() > 1 && pattern.charAt(1) == '*') {//pattern第二位为*，0个字符或者多个字符
            return match(str, pattern.substring(2)) || (match && match(str.substring(1), pattern));
        } else {//pattern第二位非*
            return match && match(str.substring(1), pattern.substring(1));
        }
    }

}
