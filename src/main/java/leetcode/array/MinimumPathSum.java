package leetcode.array;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2020/04/18
 * https://leetcode.com/problems/minimum-path-sum/
 **/
public class MinimumPathSum {
    private int minPath = 0;

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        for (int i = 1; i < grid.length; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int j = 1; j < grid[0].length; j++) {
            grid[0][j] += grid[0][j - 1];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    public int minPathSum1(int[][] grid) {
        this.search(grid, 0, 0, grid.length - 1, grid[0].length - 1, 0);
        return minPath;
    }

    private void search(int[][] grid, int i, int j, int height, int width, int digit) {
        if (i > height || j > width) {
            return;
        }
        digit += grid[i][j];
        if ((i == height && j == width)) {
            if (minPath == 0 || minPath > digit) {
                minPath = digit;
            }
            return;
        }
        if (minPath != 0 && minPath < digit) {
            return;
        }
        if (i < height) {
            search(grid, i + 1, j, height, width, digit);
        }
        if (j < width) {
            search(grid, i, j + 1, height, width, digit);
        }
    }

    @Test
    public void test() {
        assertThat(minPathSum(
                new int[][]{
                        {1, 3, 1},
                        {1, 5, 1},
                        {4, 2, 1}
                }), equalTo(7)
        );
    }

}




