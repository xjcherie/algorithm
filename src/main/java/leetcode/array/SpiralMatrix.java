package leetcode.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cherie on 2022/04/13
 * https://leetcode.com/problems/spiral-matrix/
 **/
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int length = m * n;
        List<Integer> ans = new ArrayList<>(length);
        int index = 0, lHighIndex = 0, rHighIndex = m - 1, lWidthIndex = 0, rWidthIndex = n - 1;
        while ((lHighIndex <= rHighIndex || lWidthIndex <= rWidthIndex) && index < length) {
            for (int i = lWidthIndex; i < rWidthIndex && ans.size() < length; i++) {
                ans.add(matrix[lHighIndex][i]);
            }
            for (int i = lHighIndex; i < rHighIndex && ans.size() < length; i++) {
                ans.add(matrix[i][rWidthIndex]);
            }
            for (int i = rWidthIndex; i > lWidthIndex && ans.size() < length; i--) {
                ans.add(matrix[rHighIndex][i]);
            }
            for (int i = rHighIndex; i > lHighIndex && ans.size() < length; i--) {
                ans.add(matrix[i][lWidthIndex]);
            }
            lWidthIndex++;
            rWidthIndex--;
            lHighIndex++;
            rHighIndex--;
        }
        if (length % 2 > 0 && ans.size() < length) {
            if (length == 1) {
                ans.add(matrix[0][0]);
            }
            if (m != 1 && n != 1) {
                ans.add(matrix[m / 2][n / 2]);
            }
        }
        return ans;
    }

    @Test
    public void test() {
        spiralOrder(new int[][]{{1}, {2}, {3}});
    }
}
