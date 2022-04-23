package leetcode.array;

import org.junit.Test;

/**
 * Created by Cherie on 2022/04/23
 * https://leetcode.com/problems/spiral-matrix-ii/
 **/
public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int digit = 1, total = n * n;
        int lHighIndex = 0, rHighIndex = n - 1, lWidthIndex = 0, rWidthIndex = n - 1;
        while (digit <= total && (lHighIndex <= rHighIndex || lWidthIndex <= rWidthIndex)) {
            for (int i = lWidthIndex; i < rWidthIndex && digit <= total; i++) {
                matrix[lHighIndex][i] = digit;
                digit++;
            }
            for (int i = lHighIndex; i < rHighIndex && digit <= total; i++) {
                matrix[i][rWidthIndex] = digit;
                digit++;
            }
            for (int i = rWidthIndex; i > lWidthIndex && digit <= total; i--) {
                matrix[rHighIndex][i] = digit;
                digit++;
            }
            for (int i = rHighIndex; i > lHighIndex && digit <= total; i--) {
                matrix[i][lWidthIndex] = digit;
                digit++;
            }
            lWidthIndex++;
            rWidthIndex--;
            lHighIndex++;
            rHighIndex--;
        }
        if (total % 2 > 0) {
            matrix[n / 2][n / 2] = digit;
        }
        return matrix;
    }

    @Test
    public void test() {
        generateMatrix(3);
    }

}
