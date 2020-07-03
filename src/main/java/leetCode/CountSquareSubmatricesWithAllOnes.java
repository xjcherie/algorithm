package leetCode;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2020/05/21
 * https://leetcode.com/problems/count-square-submatrices-with-all-ones/
 **/
public class CountSquareSubmatricesWithAllOnes {

    public int countSquares(int[][] matrix) {
        int total = 0, iLength = matrix.length, jLength = matrix[0].length;
        int max = Math.min(iLength, jLength);

        for (int i = 0; i < iLength; i++) {
            for (int j = 0; j < jLength; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                }
                total += 1;
                for (int length = 1; length < max; length++) {
                    if (!this.check(i, j, length, matrix, iLength, jLength)) {
                        break;
                    }
                    total += 1;
                }

            }
        }
        return total;
    }

    private boolean check(int originI, int originJ, int length, int[][] matrix, int iLength, int jLength) {
        if (originI + length >= iLength || originJ + length >= jLength) {
            return false;
        }
        for (int i = 0; i <= length; i++) {
            for (int j = 0; j <= length; j++) {
                if (matrix[originI + i][originJ + j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }


    @Test
    public void test() {
        assertThat(countSquares(new int[][]{
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        }), equalTo(15));

        assertThat(countSquares(new int[][]{
                {0, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1},
                {1, 0, 1, 0}
        }), equalTo(13));
    }

}
