package jzoffer;

import java.util.ArrayList;

/**
 * @description:
 * @author: suyue
 * @time: 2021/2/28 18:26
 */
public class J27_Permutation {


    private static ArrayList<String> result = new ArrayList<>();
    private static StringBuilder path = new StringBuilder();

    public static ArrayList<String> Permutation(String str) {
        //思路：排列组合问题使用回溯算法。回溯算法三部曲
        //递归函数入参和返回值，建议使用全局变量，减少递归函数入参数量
        //递归函数终止条件：path.length()==chars.length
        //单层for循环操作(回溯就在for循环里面)，是否需要剪枝
        if (str == null || str == "") return null;
        char[] chars = str.toCharArray();
        backtracking(chars);
        return result;
    }

    private static void backtracking(char[] chars) {
        if (path.length() == chars.length) {
            result.add(path.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            path.append(chars[i]);
            backtracking(chars);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        String s = "abc";
        ArrayList<String> list = Permutation(s);
        for (String str : list) {
            System.out.println(str);
        }
        System.out.println(list.size());
    }

}
