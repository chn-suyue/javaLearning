package jzoffer.one;

/**
 * @description:
 * @author: suyue
 * @time: 2021/4/4 14:06
 */
public class J65_hasPath {

    public static boolean hasPath(char[][] matrix, String word) {
        //方法：路径问题，dfs，递归。考虑到word在matrix中路径是否存在，可分解为word第一个字符matrix存在，且word剩下字符在第一个字符的四个方向路径存在，所以采用递归。
        //递归函数的入参和返回值，功能：从起始位置matrix[row][ol]开始，是否存在word字串路径
        //递归终止条件：loc == word.length()，说明路径存在；row和col不能超出数组边界；已经访问过的字符不能再次访问。
        //递归单层逻辑：当前下标字符相等，则标记matrix该位置已访问，并且当前位置上下左右有一个方向的字符等于word中下一个字符。
        if (matrix == null || matrix.length == 0 || word == null) return false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(matrix, i, j, visited, word, 0)) return true;
            }
        }
        return false;
    }

    private static boolean dfs(char[][] matrix, int row, int col, boolean[][] visited, String word, int index) {
        if (index == word.length()) return true;
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (row < 0 || row >= rows || col < 0 || col >= cols) return false;
        if (visited[row][col]) return false;
        if (matrix[row][col] == word.charAt(index)) {
            visited[row][col] = true;
            if (dfs(matrix, row - 1, col, visited, word, index + 1)
                    || dfs(matrix, row + 1, col, visited, word, index + 1)
                    || dfs(matrix, row, col - 1, visited, word, index + 1)
                    || dfs(matrix, row, col + 1, visited, word, index + 1)) {//四个方向有一个方向路径存在
                return true;
            }
            visited[row][col] = false;
        }
        return false;
    }


    public static void main(String[] args) {
        char[][] matrix = {{'a', 'b', 'c', 'e'}, {'s', 'f', 'c', 's'}, {'a', 'd', 'e', 'e'}};
        String word = "abcced";
        boolean result = hasPath(matrix, word);
        if (result) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

}
