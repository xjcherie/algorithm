package leetcode.integer;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2022/02/11
 * https://leetcode.com/problems/3sum-closest/
 **/
public class Sum3Closest {
    public int threeSumClosest(int[] nums, int target) {
        long count = Long.MAX_VALUE - 1, distance = Math.abs(count - target);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int second = nums[j];
                for (int h = j + 1; h < nums.length; h++) {
                    int newCount = first + second + nums[h];
                    if (newCount == target) {
                        return newCount;
                    }
                    int newDistance = Math.abs(newCount - target);
                    if (newDistance < distance) {
                        count = newCount;
                        distance = newDistance;
                    }
                    if (newCount > target) {
                        break;
                    }
                }
            }
        }
        return (int) count;
    }

    @Test
    public void test() {
        assertThat(threeSumClosest(new int[]{1, 1, 1, 0}, -100), equalTo(2));
    }
}
