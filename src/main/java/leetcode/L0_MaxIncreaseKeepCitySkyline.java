package leetcode;

/**
 * Created by Cherie on 2019/4/14.
 * 保持天际线的最大增量
 * https://leetcode.com/problems/max-increase-to-keep-city-skyline/
 */
public class L0_MaxIncreaseKeepCitySkyline {

    private static int maxIncreaseKeepingSkyline(int[][] grid) {

        int[] horizontalArray = new int[grid.length];
        // 获取最大的行数组元素数量
        // int[] verticalArray = new int[grid[0].length]; // 常规情况
        int verticalNum = 0;
        for (int[] aGrid : grid) {
            verticalNum = verticalNum > aGrid.length ? verticalNum : aGrid.length;
        }
        int[] verticalArray = new int[verticalNum];

        // 获取每行、每列最大值
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > horizontalArray[i]) {
                    horizontalArray[i] = grid[i][j];
                }
                if (grid[i][j] > verticalArray[j]) {
                    verticalArray[j] = grid[i][j];
                }
            }
        }

        int result = 0;

        // 累计每个元素与min（max横、max竖）的差距
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int temp = horizontalArray[i] > verticalArray[j] ? verticalArray[j] : horizontalArray[i];
                result += temp - grid[i][j];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] grid = {{3, 0}, {}, {2, 4, 5},{}};
        int result = maxIncreaseKeepingSkyline(grid);
        System.out.println(result);
    }

}
