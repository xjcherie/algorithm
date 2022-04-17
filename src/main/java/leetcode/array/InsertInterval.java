package leetcode.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Cherie on 2022/04/13
 * https://leetcode.com/problems/insert-interval/
 **/
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] tempInterval = Arrays.copyOf(intervals, intervals.length + 1);
        tempInterval[tempInterval.length - 1] = newInterval;
        Arrays.sort(tempInterval, Comparator.comparingInt(a -> a[0]));
        int index = 0;
        int[][] result = new int[tempInterval.length][2];
        int[] temp = new int[]{tempInterval[0][0], tempInterval[0][1]};
        for (int i = 1; i < tempInterval.length; i++) {
            if (tempInterval[i][0] <= temp[1]) {
                temp[0] = Math.min(temp[0], tempInterval[i][0]);
                temp[1] = Math.max(temp[1], tempInterval[i][1]);
                continue;
            }
            result[index++] = temp;
            temp = new int[]{tempInterval[i][0], tempInterval[i][1]};
        }
        result[index] = temp;
        return Arrays.copyOf(result, index + 1);
    }

    public int[][] insertDirectly(int[][] intervals, int[] newInterval) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int index = 0;
        int[] temp = newInterval;
        int[][] result = new int[intervals.length + 1][2];
        boolean flag = false;
        for (int[] interval : intervals) {
            if (temp != null && temp[1] < interval[0]) {
                result[index++] = temp;
                temp = null;
            }
//            if (temp != null && (interval[1] >= temp[0] || interval[1] >= temp[1] || interval[0] >= temp[0])) {
//                temp[0] = Math.min(temp[0], interval[0]);
//                temp[1] = Math.max(temp[1], interval[1]);
//                flag = true;
//                continue;
//            }
            if (temp != null &&
                    ((interval[0] <= temp[1] && interval[1] >= temp[0])
                            || (interval[1] >= temp[1] && interval[0] <= temp[1])
                            || (interval[0] >= temp[0] && interval[1] <= temp[1])
                            || (interval[0] <= temp[0] && interval[1] >= temp[1]))) {
                temp[0] = Math.min(temp[0], interval[0]);
                temp[1] = Math.max(temp[1], interval[1]);
                flag = true;
                continue;
            }
            if (flag && temp != null) {
                result[index++] = temp;
                temp = null;
            }
            result[index++] = new int[]{interval[0], interval[1]};
        }
        if (temp != null) {
            result[index++] = temp;
        }
        return Arrays.copyOf(result, index);
    }
}
