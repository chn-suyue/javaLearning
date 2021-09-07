package leetcode.back;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: suyue
 * @time: 2021/8/29 19:39
 */
public class lc216_combinationSum3 {

    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> result = new ArrayList<>();

    //排列组合问题，而且要把该排列组合列出来，回溯算法
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 1, 0);
        return result;
    }

    //优化：加上剪枝操作进行优化
    //剪枝逻辑：当前path元素和超过n，则没必要遍历了
    private void backtracking(int k, int n, int startIndex, int sum) {
        //剪枝
        if (sum > n) return;
        //递归终止条件
        if (path.size() == k) {
            if (sum == n) result.add(new ArrayList<>(path));
            return;
        }

        //递归单层逻辑：横向遍历for循环，纵向遍历递归
        for (int i = startIndex; i <= 9; i++) {
            sum = sum + i;
            path.add(i);
            backtracking(k, n, i + 1, sum);
            sum = sum - i;
            path.remove(path.size() - 1);//回溯
        }

    }

    //原始：
    /*private void backtracking(int k, int n, int startIndex) {
        //递归终止条件
        if (path.size() == k) {
            int sum = 0;
            for (int i = 0; i < path.size(); i++) {
                sum = sum + path.get(i);
            }
            if (sum == n) {
                result.add(new ArrayList<>(path));
            }
                return;
        }

        //递归单层逻辑：横向遍历for循环，纵向遍历递归
        for (int i = startIndex; i <= 9; i++) {
            path.add(i);
            backtracking(k, n, i + 1);
            path.remove(path.size() - 1);//回溯
        }

    }*/

}
