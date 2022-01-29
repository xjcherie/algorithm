package leetcode;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2021/03/23
 * https://leetcode.com/problems/number-of-islands/
 **/
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;

        int iLength = grid.length, jLength = grid[0].length;
        boolean[][] flagGrid = new boolean[iLength][jLength];
        int num = 0;
        for (int i = 0; i < iLength; i++) {
            for (int j = 0; j < jLength; j++) {
                if (flagGrid[i][j] || grid[i][j] == '0') {
                    continue;
                }
                num++;
                this.traverseFlagGrid(grid, flagGrid, i, j, iLength, jLength);
            }
        }
        return num;
    }

    private void traverseFlagGrid(char[][] grid, boolean[][] flagGrid, int i, int j, int iLength, int jLength) {
        if (i < 0 || i >= iLength || j < 0 || j >= jLength || flagGrid[i][j] || grid[i][j] == '0') return;
        flagGrid[i][j] = true;
        this.traverseFlagGrid(grid, flagGrid, i, j + 1, iLength, jLength);
        this.traverseFlagGrid(grid, flagGrid, i, j - 1, iLength, jLength);
        this.traverseFlagGrid(grid, flagGrid, i + 1, j, iLength, jLength);
        this.traverseFlagGrid(grid, flagGrid, i - 1, j, iLength, jLength);
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
