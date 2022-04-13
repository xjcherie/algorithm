package leetcode.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Cherie on 2022/04/13
 * https://leetcode.com/problems/merge-intervals/
 **/
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        int[][] result = new int[intervals.length][2];
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int index = 0;
        int[] temp = new int[]{intervals[0][0], intervals[0][1]};
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= temp[1]) {
                temp[0] = Math.min(temp[0], intervals[i][0]);
                temp[1] = Math.max(temp[1], intervals[i][1]);
                continue;
            }
            result[index++] = temp;
            temp = new int[]{intervals[i][0], intervals[i][1]};
        }
        result[index] = temp;
        return Arrays.copyOf(result, index + 1);
    }
}
