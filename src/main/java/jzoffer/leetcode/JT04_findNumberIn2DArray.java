package jzoffer.leetcode;

/**
 * @description:
 * @author: suyue
 * @time: 2021/9/3 20:01
 */
public class JT04_findNumberIn2DArray {

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {

        //思路：二维有序数组的查询问题
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int rows = matrix.length - 1;
        int cols = matrix[0].length - 1;

        int row = 0;
        int col = cols;

        while (row <= rows && col >= 0) {
            if (matrix[row][col] > target) {
                col--;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                return true;
            }
        }

        return false;

    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}};
        int target = 5;
        boolean result = findNumberIn2DArray(matrix, target);
        System.out.println(result);
    }

}
