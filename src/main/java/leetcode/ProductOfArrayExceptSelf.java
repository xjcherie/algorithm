package leetcode;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2020/04/15
 * https://leetcode.com/problems/product-of-array-except-self/
 **/
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] outputArray = new int[nums.length];

        outputArray[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            outputArray[i] = outputArray[i - 1] * nums[i - 1];
        }
        int total = 1;
        for (int length = nums.length - 1; length >= 0; length--) {
            outputArray[length] = outputArray[length] * total;
            total *= nums[length];
        }
        return outputArray;
    }

    public int[] productExceptSelf1(int[] nums) {
        int[] outputArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int output = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                output *= nums[j];
            }
            outputArray[i] = output;
        }
        return outputArray;
    }

    @Test
    public void test() {
        assertThat(productExceptSelf(new int[]{1, 2, 3, 4}), equalTo(new int[]{24, 12, 8, 6}));
    }
}
