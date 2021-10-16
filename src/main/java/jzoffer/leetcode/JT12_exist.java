package jzoffer.leetcode;

/**
 * @description:
 * @author: suyue
 * @time: 2021/9/23 11:32
 */
public class JT12_exist {

    public boolean exist(char[][] board, String word) {
        //思路：从当前位置移动到下一位置，每个节点都有上下左右四个方向前进，所有题目可抽象为遍历一棵树，寻找满足要求的路径，可采用深度优先算法遍历。
        //      首先遍历二维数组，找到与目标字符串首字母相匹配的字符。找到后，则以该字符为起始位置，从上下左右四个方向深度遍历，寻找路径是否存在。
        //注意：已经访问过的位置不能重复访问，所以需要一个数组记录哪些节点已经访问过
        if (board == null || board.length == 0) {
            return false;
        }

        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0) && helpExist(board, word, i, j, 0, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean helpExist(char[][] board, String word, int row, int col, int index, boolean[][] visited) {

        int rows = board.length;
        int cols = board[0].length;

        //递归终止条件
        //如果index等于字符长度，则路径已找到，返回true
        if (index==word.length()) {
            return true;
        }

        //row, col, index 不能超过范围
        if (row<0 || row>=rows || col<0 || col>=cols) {
            return false;
        }

        //已经访问的节点不能重复访问
        if (visited[row][col]) {
            return false;
        }

        //单层递归逻辑
        if (board[row][col] == word.charAt(index)) {
            visited[row][col] = true;
            if (helpExist(board, word, row+1, col, index+1, visited)
                    || helpExist(board, word, row-1, col, index+1, visited)
                    || helpExist(board, word, row, col+1, index+1, visited)
                    || helpExist(board, word, row, col-1, index+1, visited)) {
                return true;
            }
            visited[row][col] = false;
        }

        return false;
    }

}
