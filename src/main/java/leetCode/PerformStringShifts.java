package leetCode;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2020/04/15
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3299/
 **/
public class PerformStringShifts {
    public String stringShift(String s, int[][] shift) {
        if (shift.length == 0) {
            return s;
        }
        int direction = 0, amount = 0;
        for (int[] ints : shift) {
            if (direction == ints[0]) {
                amount += ints[1];
            } else {
                amount -= ints[1];
            }
        }

        if (amount < 0) {
            direction = 1;
            amount = -amount;
        }
        amount = amount % s.length();
        if (amount != 0) {
            StringBuilder sb = new StringBuilder(s);
            if (direction == 0) {
                String subStr = sb.substring(0, amount);
                sb.delete(0, amount);
                sb.append(subStr);
            } else {
                String subStr = sb.substring(sb.length() - amount, sb.length());
                sb.delete(sb.length() - amount, sb.length());
                sb = new StringBuilder(subStr).append(sb);
            }
            s = sb.toString();
        }
        return s;
    }

    @Test
    public void test() {
        assertThat(stringShift("abc", new int[][]{{0, 1}, {1, 2}}), equalTo("cab"));
        assertThat(stringShift("abcdefg", new int[][]{{1, 1}, {1, 1}, {0, 2}, {1, 3}}), equalTo("efgabcd"));
    }
}
