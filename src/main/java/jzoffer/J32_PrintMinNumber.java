package jzoffer;

import java.util.ArrayList;

/**
 * @description:
 * @author: suyue
 * @time: 2021/3/6 17:55
 */
public class J32_PrintMinNumber {

    private static ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
    private static ArrayList<Integer> path = new ArrayList<>();

    public static String PrintMinNumber(int[] numbers) {
        //方法1：全排列，回溯算法。拿到全排列后，遍历取出最大值时的排列
        //递归参数：path, paths, void backtracking(int[] array, boolean[] used)
        //递归终止条件：path.size() == array.length
        //单层搜索逻辑：和普通的全排列一样，记得used[i]=false,path.remove(path.size()-1)
        //时间复杂度：O(n!)
        //空间复杂度：O(n^2)
        /*if (numbers == null || numbers.length == 0) return "";
        boolean[] used = new boolean[numbers.length];
        backtracking(numbers, used);
        long min = 0L;
        for (int i = 0; i < paths.size(); i++) {
            StringBuilder tempStr = new StringBuilder();
            for (int j = 0; j < paths.get(0).size(); j++) {
                tempStr.append(paths.get(i).get(j));
            }
            min = min == 0 ? Long.parseLong(tempStr.toString()) : Math.min(min, Long.parseLong(tempStr.toString()));
        }
        return String.valueOf(min);*/

        //方法2：类似冒泡排序。观察到两个字符串s1和s2，如果拼接的数值s1+s2>s2+s1,则s2要放在s1前面
        //时间复杂度：O(n^2)
        //空间复杂度：
        if (numbers == null || numbers.length == 0) return "";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int s1 = Integer.parseInt(String.valueOf(numbers[i]) + numbers[j]);
                int s2 = Integer.parseInt(String.valueOf(numbers[j]) + numbers[i]);
                if (s1 > s2) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
            result.append(numbers[i]);
        }
        return result.toString();
    }

    private static void backtracking(int[] array, boolean[] used) {
        if (path.size() == array.length) {
            paths.add(new ArrayList<>(path));
        }
        for (int i = 0; i < array.length; i++) {
            if (!used[i]) {
                used[i] = true;
                path.add(array[i]);
                backtracking(array, used);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {3334, 3, 3333332};
        String str = PrintMinNumber(array);
        System.out.println(str);
    }

}
