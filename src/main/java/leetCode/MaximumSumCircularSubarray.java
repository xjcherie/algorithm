package leetCode;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by Cherie on 2020/05/15
 * https://leetcode.com/problems/maximum-sum-circular-subarray/
 **/
public class MaximumSumCircularSubarray {
    public int maxSubarraySumCircular(int[] A) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            int j = -1;
            int sum = A[i];
            max = Math.max(max, sum);
            while (j == -1 || j != i) {
                if (j != -1) {
                    sum += A[j];
                    max = Math.max(max, sum);
                }
                if (j == A.length - 1 || (j == -1 && i == A.length - 1)) {
                    j = 0;
                } else if (j == -1) {
                    j = i + 1;
                } else {
                    j++;
                }
            }
        }
        return max;
    }

    @Test
    public void test() {
        assertThat(maxSubarraySumCircular(new int[]{1, -2, 3, -2}), equalTo(3));
    }
}
