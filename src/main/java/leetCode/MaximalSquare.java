package leetCode;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2020/04/27
 * https://leetcode.com/problems/maximal-square/
 **/
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int max = 0, xLength = matrix.length, yLength = matrix[0].length;
        int[][] array = new int[xLength][yLength];

        for (int i = 0; i < xLength; i++) {
            for (int j = 0; j < yLength; j++) {
                if (matrix[i][j] == '0') {
                    array[i][j] = 0;
                    continue;
                }
                if (i == 0 || j == 0) {
                    array[i][j] = matrix[i][j] == '0' ? 0 : 1;
                    max = Math.max(max, array[i][j]);
                    continue;
                }
                array[i][j] = Math.min(array[i - 1][j - 1], Math.min(array[i][j - 1], array[i - 1][j])) + 1;
                max = Math.max(max, array[i][j]);
            }
        }
        return max * max;
    }

    @Test
    public void test() {
        assertThat(maximalSquare(
                new char[][]{
                        {'1', '0', '1', '0', '0'},
                        {'1', '0', '1', '1', '1'},
                        {'1', '1', '1', '1', '1'},
                        {'1', '0', '0', '1', '0'}
                }), equalTo(4)
        );
        assertThat(maximalSquare(
                new char[][]{
                        {'1', '1', '1'},
                        {'1', '1', '1'},
                        {'1', '1', '1'},
                }), equalTo(9)
        );
        assertThat(maximalSquare(
                new char[][]{
                        {'0', '0', '0', '0', '0'},
                        {'0', '0', '0', '0', '0'},
                        {'0', '0', '0', '0', '1'},
                        {'0', '0', '0', '0', '0'}
                }), equalTo(1)
        );

    }

}
