package leetcode.array;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2022/05/15
 * https://leetcode.com/problems/search-a-2d-matrix/
 **/
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        return this.searchMIndex(matrix, 0, matrix.length - 1, target);
    }

    private boolean searchMIndex(int[][] matrix, int small, int large, int target) {
        if (small < 0 || large >= matrix.length) {
            return false;
        }
        int mHalf = (small + large) / 2;
        if (matrix[mHalf][0] == target) {
            return true;
        } else if (matrix[mHalf][0] > target) {
            if (small >= mHalf - 1) {
                return this.searchNIndex(matrix, small, 0, matrix[0].length - 1, target);
            } else {
                return this.searchMIndex(matrix, small, mHalf - 1, target);
            }
        } else {
            if (large == mHalf + 1 || large == mHalf) {
                return this.searchNIndex(matrix, mHalf, 0, matrix[0].length - 1, target);
            } else {
                return this.searchMIndex(matrix, mHalf, large, target);
            }
        }
    }

    private boolean searchNIndex(int[][] matrix, int m, int small, int large, int target) {
        if (small < 0 || large >= matrix[0].length) {
            return false;
        }
        int nHalf = (small + large) / 2;
        if (matrix[m][nHalf] == target) {
            return true;
        } else if (matrix[m][nHalf] > target) {
            if (small > nHalf - 1) {
                return false;
            }
            return this.searchNIndex(matrix, m, small, nHalf - 1, target);
        } else {
            if (large < nHalf + 1) {
                return false;
            }
            return this.searchNIndex(matrix, m, nHalf + 1, large, target);
        }
    }

    @Test
    public void test() {
        assertThat(searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13), equalTo(false));
        assertThat(searchMatrix(new int[][]{{1}}, 13), equalTo(false));
        assertThat(searchMatrix(new int[][]{{1, 3}}, 3), equalTo(true));
        assertThat(searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 11), equalTo(true));
        assertThat(searchMatrix(new int[][]{{1}, {3}}, 3), equalTo(true));

    }
}
