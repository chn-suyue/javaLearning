package jzoffer.leetcode;

/**
 * @description:
 * @author: suyue
 * @time: 2021/9/25 18:02
 */
public class JT13_movingCount {

    private int count = 0;

    public int movingCount(int m, int n, int k) {
        //思路：类似于上一题，使用深度优先遍历搜索
        //注意：1、已经访问过的位置不能重复访问，所以需要一个二维数组保存访问记录；2、递归终止条件有好几个，别漏了

        int row = 0;
        int col = 0;
        boolean[][] visited = new boolean[m][n];
        helpMovingCount(row, col, m, n, k, visited);

        return count;

    }

    public void helpMovingCount(int row, int col, int m, int n, int k, boolean[][] visited) {
        //递归终止条件
        //1、row col不能越界
        if (row<0 || row>=m || col<0 || col>=n) {
            return;
        }

        //2、已经访问过的节点不能重复访问
        if (visited[row][col]) {
            return;
        }

        visited[row][col] = true;

        //单层递归逻辑
        if (check(row)+check(col)<=k) {
            count++;
            helpMovingCount(row-1, col, m, n, k, visited);
            helpMovingCount(row+1, col, m, n, k, visited);
            helpMovingCount(row, col-1, m, n, k, visited);
            helpMovingCount(row, col+1, m, n, k, visited);
        }

    }

    public int check (int num) {
        if (num==0) {
            return 0;
        }

        int x = num%10;
        int y = (num-x)/10;

        return x+y;

    }

}
