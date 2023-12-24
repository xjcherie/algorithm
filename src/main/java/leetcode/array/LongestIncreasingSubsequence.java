package leetcode.array;

import leetcode.common.BinaryMatrix;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2023/06/30
 * https://leetcode.com/problems/longest-increasing-subsequence/
 **/
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max >= nums.length - i) {
                break;
            }
            max = Math.max(max, this.recursion(nums, i) + 1);
        }
        return this.recursion(nums, 0 );
    }

    private int recursion(int[] nums, int index) {
        int nextIndex = index + 1;
        if (nextIndex == nums.length) {
            return 0;
        }
        int max = 0;
        for (int i = nextIndex; i < nums.length; i++) {
            if (max >= nums.length - i) {
                break;
            }
            if (nums[i] > nums[index]) {
                max = Math.max(max, this.recursion(nums, i) + 1);
            }
        }
        return max;
    }

    @Test
    public void test() {
        assertThat(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}), equalTo(4));
        assertThat(lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}), equalTo(4));
        assertThat(lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}), equalTo(1));
    }
}
