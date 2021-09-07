package jzoffer.leetcode;

/**
 * @description:
 * @author: suyue
 * @time: 2021/8/31 20:09
 */
public class JT05_replaceSpace {

    public String replaceSpace(String s) {
        char[] chars = new char[s.length() * 3];
        int size = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                chars[size++] = '%';
                chars[size++] = '2';
                chars[size++] = '0';
            } else {
                chars[size++] = c;
            }
        }

        String result = new String(chars, 0, size);
        return result;
    }

}
