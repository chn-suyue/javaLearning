package leetcode.back;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: suyue
 * @time: 2021/8/29 15:02
 */
public class lc77_combine {

    private static List<List<Integer>> result = new ArrayList<>();
    private static List<Integer> path = new ArrayList<>();

    public static List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return result;
    }

    public static void backtracking(int n, int k, int startIndex) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        /*for (int i = startIndex; i <= n; i++) {
            path.add(i);
            backtracking(n, k, i + 1);
            path.remove(path.size() - 1);
        }*/
        //剪枝优化下
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backtracking(n, k, i + 1);
            path.remove(path.size() - 1);
        }

    }

    public static void main(String[] args) {
        combine(4, 2);
        System.out.println(result);
    }

}
