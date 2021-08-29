package jzoffer.newcode;

/**
 * @description:
 * @author: suyue
 * @time: 2021/4/5 13:27
 */
public class J66_movingCount {

    int count = 0;

    public int movingCount(int threshold, int rows, int cols) {
        //方法1：分类讨论。三种情况。（这个思路不对啊，大错特错，牛客网测试用例不全才过的）
        /*int count = 0;
        if (rows>1 && cols>1) {//1.如果rows>1 && cols>1，遍历二维数组，计数各位数和不超过threshold的个数即可
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (getSumDig(i) + getSumDig(j) <= threshold) count++;
                }
            }
        } else if (rows==1) {//2.如果只有一行，计数至第一个超过threshold的格子即可
            for (int m=0; m<cols; m++) {
                if (getSumDig(m)<=threshold) {
                    count++;
                    continue;
                }
                break;
            }
        } else if (cols==1) {//3.如果只有一列，和只有一行同理
            for (int n=0; n<rows; n++) {
                if (getSumDig(n)<=threshold) {
                    count++;
                    continue;
                }
                break;
            }
        }
        return count;*/

        //方法2：路径问题，dfs，递归。(0,0)起点开始，坐标数位之和不超过k的格子数，等于 分别从(1,0)和(0,1)起点开始，坐标数位之和不超过k的格子数。这个样子的递归。
        //递归函数的功能，入参，返回值：从二维数组某个起点开始，满足约束条件的格子数。
        //递归终止条件：坐标位数大于k；坐标越界；坐标已访问。
        //递归单层逻辑：当前坐标满足约束条件，计数加1，再加上上下左右四个方向中满足约束条件的格子数
        boolean[][] visited = new boolean[rows][cols];
        dfs(threshold, rows, cols, 0, 0, visited);
        return count;
    }

    private void dfs(int threshold, int rows, int cols, int row, int col, boolean[][] visited) {
        if (check(row) + check(col) > threshold || row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col])
            return;

        count++;
        visited[row][col] = true;
        dfs(threshold, rows, cols, row-1, col, visited);
        dfs(threshold, rows, cols, row+1, col, visited);
        dfs(threshold, rows, cols, row, col-1, visited);
        dfs(threshold, rows, cols, row, col+1, visited);
    }

    private int check(int num) {
        int result = 0;
        while (num != 0) {
            result += num % 10;
            num /= 10;
        }
        return result;
    }


}
