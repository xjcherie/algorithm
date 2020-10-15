package leetcode.array;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2020/04/19
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 **/
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start >= 0 && end >= 0 && start < nums.length && end < nums.length) {
            int index = (start + end) / 2;
            int digit = nums[index];
            if (digit == target) {
                return index;
            } else if ((nums[start] <= target && target < digit) || (nums[start] > digit && (nums[start] <= target || target <= digit))) {
                end = index - 1;
            } else if ((digit < target && target <= nums[end]) || (nums[end] < digit && (target > digit || target <= nums[end]))) {
                start = index + 1;
            } else {
                return -1;
            }
        }
        return -1;
    }

    public int search1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return i;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        assertThat(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3), equalTo(-1));
        assertThat(search(new int[]{5, 1, 3}, 5), equalTo(0));
        assertThat(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3), equalTo(-1));
    }

}
