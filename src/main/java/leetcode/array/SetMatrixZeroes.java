package leetcode.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cherie on 2022/05/15
 * https://leetcode.com/problems/set-matrix-zeroes/
 **/
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    firstList.add(i);
                    secondList.add(j);
                }
            }
        }
        for (int index = 0; index < firstList.size(); index++) {
            int i = firstList.get(index);
            int j = secondList.get(index);
            for (int zeroIndex = 0; zeroIndex < n; zeroIndex++) {
                matrix[i][zeroIndex] = 0;
            }
            for (int zeroIndex = 0; zeroIndex < m; zeroIndex++) {
                matrix[zeroIndex][j] = 0;
            }
        }
    }

    @Test
    public void test() {
        setZeroes(new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}});
    }

}
