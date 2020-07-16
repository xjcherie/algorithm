package leetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2020/05/23
 * https://leetcode.com/problems/interval-list-intersections/
 **/
public class IntervalListIntersections {

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0, j = 0;
        List<int[]> list = new ArrayList<>();

        while (i < A.length && j < B.length) {

            int iStart = A[i][0], iEnd = A[i][1];
            int jStart = B[j][0], jEnd = B[j][1];

            if (iStart > jEnd) {
                j++;
            } else if (iEnd < jStart) {
                i++;
            } else {
                list.add(new int[]{Math.max(iStart, jStart), Math.min(iEnd, jEnd)});
                if (iEnd > jEnd) {
                    j++;
                } else if (iEnd < jEnd) {
                    i++;
                } else {
                    i++;
                    j++;
                }
            }
        }

        return list.toArray(new int[list.size()][2]);
    }

    @Test
    public void test() {
        assertThat(intervalIntersection(
                new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}},
                new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}}),
                equalTo(new int[][]{{1, 2}, {5, 5}, {8, 10}, {15, 23}, {24, 24}, {25, 25}}));
    }
}
