package leetcode.dp;

/**
 * @description:
 * @author: suyue
 * @time: 2021/8/2 0:57
 */
public class lc63_uniquePathsWithObstacles {

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 0}};
        int result = uniquePathsWithObstacles(obstacleGrid);
        System.out.println(result);
    }

    // 增加障碍物与没有障碍物的区别在于，有障碍物的位置在dp数组中值为0

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if(obstacleGrid[0][0]==1) return 0;

        int rows = obstacleGrid.length;
        int columns = obstacleGrid[0].length;
        int[][] dp = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }

        for (int j = 1; j < columns; j++) {
            if (obstacleGrid[0][j] == 1) {
                break;
            }
            dp[0][j] = 1;
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[rows - 1][columns - 1];
    }


}
