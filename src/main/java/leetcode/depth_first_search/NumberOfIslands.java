package leetcode.depth_first_search;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2020/04/17
 * https://leetcode.com/problems/number-of-islands/
 **/
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                num++;
                this.repairGrid(grid, i, j);
            }
        }
        return num;
    }

    private void repairGrid(char[][] grid, int i, int j) {
        if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0 || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        repairGrid(grid, i - 1, j);
        repairGrid(grid, i + 1, j);
        repairGrid(grid, i, j - 1);
        repairGrid(grid, i, j + 1);
    }

    @Test
    public void test() {
        assertThat(numIslands(
                new char[][]{
                        {'1', '1', '1', '1', '0'},
                        {'1', '1', '0', '1', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '0', '0', '0'}
                }), equalTo(1)
        );
        assertThat(numIslands(
                new char[][]{
                        {'1', '1', '0', '0', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '1', '0', '0'},
                        {'0', '0', '0', '1', '1'}
                }), equalTo(3)
        );
        assertThat(numIslands(
                new char[][]{
                        {'1', '0', '1', '1', '1'},
                        {'1', '0', '1', '0', '1'},
                        {'1', '1', '1', '0', '1'}
                }), equalTo(1)
        );
    }
}
