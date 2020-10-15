package leetcode.array;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by Cherie on 2020/04/03
 * https://leetcode.com/problems/maximum-subarray/
 * https://leetcode-cn.com/problems/maximum-subarray/solution/zui-da-zi-xu-he-by-leetcode/
 **/
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int max = nums[0], sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum < 0) {
                sum = nums[i];
                max = Math.max(sum, max);
            } else {
                sum += nums[i];
                max = Math.max(sum, max);
            }
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
            maxSum = Math.max(maxSum, nums[i]);
        }
        return maxSum;
    }

    public int maxSubArray1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int sumMax = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int leftSum = 0, leftSumMax = 0;
            for (int left = i - 1; left >= 0; left--) {
                leftSum += nums[left];
                if (leftSum > leftSumMax) {
                    leftSumMax = leftSum;
                }
            }
            int rightSum = 0, rightSumMax = 0;
            for (int right = i + 1; right < nums.length; right++) {
                rightSum += nums[right];
                if (rightSum > rightSumMax) {
                    rightSumMax = rightSum;
                }
            }
            int sum = nums[i];
            if (leftSumMax > 0) {
                sum += leftSumMax;
            }
            if (rightSumMax > 0) {
                sum += rightSumMax;
            }
            if (sum > sumMax) {
                sumMax = sum;
            }
        }
        return sumMax;
    }

    @Test
    public void test() {
        assertThat(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}), equalTo(6));
        assertThat(maxSubArray(new int[]{-1}), equalTo(-1));
        assertThat(maxSubArray(new int[]{3, -2, 4}), equalTo(5));
    }
}
