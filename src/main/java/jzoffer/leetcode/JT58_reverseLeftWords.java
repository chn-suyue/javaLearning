package jzoffer.leetcode;

/**
 * @description:
 * @author: suyue
 * @time: 2021/8/31 20:19
 */
public class JT58_reverseLeftWords {

    public String reverseLeftWords(String s, int n) {
        if (n == s.length()) return s;
        String post = s.substring(0, n);
        String pre = s.substring(n, s.length());
        return pre + post;
    }

}
