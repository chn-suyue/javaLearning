package jzoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: suyue
 * @time: 2021/3/7 15:27
 */
public class J34_FirstNotRepeatingChar {

    public static int FirstNotRepeatingChar(String str) {
        //方法1：遍历一遍字符串，可以得到哪些字符只出现一次，哪些字符出现不止一次，用两个ArrayList分别存储
        //时间复杂度：O(n)
        //空间复杂度：
        if (str == null || str == "") return -1;
        List<String> overList = new ArrayList<>();
        List<String> onlyList = new ArrayList<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!overList.contains(String.valueOf(chars[i])) && !onlyList.contains(String.valueOf(chars[i]))) {
                onlyList.add(String.valueOf(chars[i]));
            } else if (!overList.contains(String.valueOf(chars[i])) && onlyList.contains(String.valueOf(chars[i]))) {
                onlyList.remove(String.valueOf(chars[i]));
                overList.add(String.valueOf(chars[i]));
            }
        }
        if (onlyList.isEmpty()) {
            return -1;
        }
        return str.indexOf(onlyList.get(0));

        //方法2：哈希，先遍历一次字符串，统计每个字符出现的次数并用map存储；再遍历一遍字符串，找出第一个出现次数为1的字符的下标

    }

    public static void main(String[] args) {
        String str = "googgle";
        int result = FirstNotRepeatingChar(str);
        System.out.println(result);
    }

}
