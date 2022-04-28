package leetcode.array;

/**
 * Created by Cherie on 2022/04/28
 * https://leetcode.com/problems/unique-paths-ii/
 **/
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] array = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int digit;
                if (obstacleGrid[i][j] == 1) {
                    digit = 0;
                } else if (i == 0 && j == 0) {
                    digit = 1;
                } else if (i == 0) {
                    digit = array[i][j - 1];
                } else if (j == 0) {
                    digit = array[i - 1][j];
                } else {
                    digit = array[i - 1][j] + array[i][j - 1];
                }
                array[i][j] = digit;
            }
        }
        return array[m - 1][n - 1];
    }

}
