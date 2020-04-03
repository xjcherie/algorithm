package leetCode;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2019/9/01.
 * 二维数组距离的计算
 * https://leetcode.com/problems/escape-the-ghosts/
 */
public class EscapeTheGhosts {
    private boolean escapeGhosts(int[][] ghosts, int[] target) {
        int length = Math.abs(target[0]) + Math.abs(target[1]);
        for (int[] ghost : ghosts) {
            if ((Math.abs(target[0] - ghost[0]) + Math.abs(target[1] - ghost[1])) < length) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        assertThat(escapeGhosts(new int[][]{{1, 0}, {0, 3}}, new int[]{0, 1}), equalTo(true));
        assertThat(escapeGhosts(new int[][]{{1, 0}}, new int[]{2, 0}), equalTo(false));
        assertThat(escapeGhosts(new int[][]{{1, 9}, {2, -5}, {3, 8}, {9, 8}, {-1, 3}}, new int[]{8, -10}), equalTo(false));
        assertThat(escapeGhosts(new int[][]{{5, 0}, {-10, -2}, {0, -5}, {-2, -2}, {-7, 1}}, new int[]{7, 7}), equalTo(false));
    }
}