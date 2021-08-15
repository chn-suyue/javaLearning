package jzoffer.one;

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
        //递归函数参数：建议使用全局变量，减少递归函数入参数量
        //递归终止条件：path.length()==chars.length
        //单层搜索逻辑：for循环操作(回溯就在for循环里面)，是否需要剪枝
        if (str == null || str == "") return null;
        char[] chars = str.toCharArray();
        boolean[] used = new boolean[chars.length];
        backtracking(chars, used);
        return result;
    }

    private static void backtracking(char[] chars, boolean[] used) {
        if (path.length() == chars.length) {
            result.add(path.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            //剪枝，去除字符串中重复字符排列
            if (i>0 && chars[i]==chars[i-1] && !used[i-1]) continue;
            if (!used[i]) {
                used[i] = true;
                path.append(chars[i]);
                backtracking(chars, used);
                used[i] = false;
                path.deleteCharAt(path.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String s = "aa";
        ArrayList<String> list = Permutation(s);
        for (String str : list) {
            System.out.println(str);
        }
        System.out.println(list.size());
    }

}
