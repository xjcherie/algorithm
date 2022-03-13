package leetcode.array;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2022/03/08
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 **/
public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        if (nums.length == 0 || nums[0] > target || nums[nums.length - 1] < target) {
            return ans;
        }
        int leftIndex = 0, rightIndex = nums.length - 1;
        while (leftIndex <= rightIndex) {
            int middle = (leftIndex + rightIndex) / 2;
            if (nums[middle] < target) {
                leftIndex = middle + 1;
            } else if (nums[middle] > target) {
                rightIndex = middle - 1;
            } else {
                leftIndex = middle;
                rightIndex = middle;
                while (leftIndex >= 0 && nums[leftIndex] == target) {
                    leftIndex--;
                }
                while (rightIndex <= nums.length - 1 && nums[rightIndex] == target) {
                    rightIndex++;
                }
                ans[0] = leftIndex + 1;
                ans[1] = rightIndex - 1;
                break;
            }
        }
        return ans;
    }

    @Test
    public void test() {
        assertThat(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6), equalTo(new int[]{1, 1}));
    }
}
