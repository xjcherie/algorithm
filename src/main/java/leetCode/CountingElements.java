package leetCode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2020/04/07
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3289/
 * <p>
 * <p>
 * Given an integer array arr, count element x such that x + 1 is also in arr.
 * If there're duplicates in arr, count them seperately.
 * <p>
 * Example :
 * Input: arr = [1,2,3]
 * Output: 2
 * Explanation: 1 and 2 are counted cause 2 and 3 are in arr.
 **/
public class CountingElements {
    public int countElements(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        int ans = 0;
        for (int i : arr) {
            if (set.contains(i + 1)) {
                ans++;
            }
        }
        return ans;
    }

    @Test
    public void test() {
        assertThat(countElements(new int[]{1, 2, 3}), equalTo(2));
        assertThat(countElements(new int[]{1, 3, 2, 3, 5, 0}), equalTo(3));
        assertThat(countElements(new int[]{1, 1, 2}), equalTo(2));
    }
}
