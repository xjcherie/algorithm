package leetcode.array;

import org.junit.Test;

/**
 * Created by Cherie on 2022/04/10
 * https://leetcode.com/problems/rotate-image/
 **/
public class RotateImage {
    public void rotate(int[][] matrix) {
        int length = matrix.length - 1;
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int n = i; n < length - i; n++) {
                int temp = matrix[i][n];
                matrix[i][n] = matrix[length - n][i];
                matrix[length - n][i] = matrix[length - i][length - n];
                matrix[length - i][length - n] = matrix[n][length - i];
                matrix[n][length - i] = temp;
            }
        }
    }

    @Test
    public void test() {
        rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }

}
