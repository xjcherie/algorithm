package leetCode;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2020/05/25
 * https://leetcode.com/problems/uncrossed-lines/
 **/
public class UncrossedLines {

    public int maxUncrossedLines(int[] A, int[] B) {
        int[][] ans = new int[A.length][B.length];

        ans[0][0] = A[0] == B[0] ? 1 : 0;
        for (int i = 1; i < A.length; i++) {
            ans[i][0] = Math.max(ans[i - 1][0], (A[i] == B[0] ? 1 : 0));
        }
        for (int j = 1; j < B.length; j++) {
            ans[0][j] = Math.max(ans[0][j - 1], (A[0] == B[j] ? 1 : 0));
        }

        for (int i = 1; i < A.length; i++) {
            for (int j = 1; j < B.length; j++) {
                ans[i][j] = Math.max(ans[i][j - 1], ans[i - 1][j]);
                if (A[i] == B[j]) {
                    ans[i][j] = Math.max(ans[i][j], ans[i - 1][j - 1] + 1);
                }
            }
        }

        return ans[A.length - 1][B.length - 1];
    }

    /**
     * 法二
     */
    public int maxUncrossedLines1(int[] A, int[] B) {
        return this.count(A, B, 0, 0);
    }

    private int count(int[] A, int[] B, int i, int j) {
        if (i >= A.length || j >= B.length) {
            return 0;
        }

        int aNext = count(A, B, i + 1, j);
        int bNext = count(A, B, i, j + 1);

        if (A[i] != B[j]) {
            return Math.max(aNext, bNext);
        }
        int allNext = 1 + count(A, B, i + 1, j + 1);

        return Math.max(allNext, Math.max(aNext, bNext));
    }

    @Test
    public void test() {
        assertThat(maxUncrossedLines(
                new int[]{3, 1, 4, 1, 1, 3, 5, 1, 2, 2},
                new int[]{4, 1, 5, 2, 1, 1, 1, 5, 3, 1, 1, 1, 2, 3, 1, 4, 3, 5, 5, 3, 1, 2, 3, 2, 4, 1, 1, 1, 5, 3}
        ), equalTo(9));

        assertThat(maxUncrossedLines(
                new int[]{2, 5, 1, 2, 5},
                new int[]{10, 5, 2, 1, 5, 2}
        ), equalTo(3));
    }

}
