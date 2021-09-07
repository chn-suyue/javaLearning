package jzoffer.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: suyue
 * @time: 2021/9/4 16:54
 */
public class JT50_firstUniqChar {

    public char firstUniqChar(String s) {
        if (s == null || s.equals("")) {
            return ' ';
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) == null) {
                map.put(c, 1);
            } else {
                Integer count = map.get(c);
                map.put(c, count+1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) == 1) {
                return c;
            }
        }

        return ' ';
    }

}
