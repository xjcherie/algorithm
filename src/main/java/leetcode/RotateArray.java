package leetcode;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2021/01/22
 * https://leetcode.com/problems/rotate-array/
 **/
public class RotateArray {

    public int[] rotate(int[] nums, int k) {
        k = k % nums.length;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
        }
        String ansStr = sb.substring(nums.length - k, nums.length) + sb.substring(0, nums.length - k);
//        int[] ans = ansStr.toCharArray();


//        for (int i = 0; i < nums.length - k; i++) {
//            System.out.println(i);
//            int temp = nums[i];
//            nums[i + k] = temp;
//            if (nums.length - k + i == nums.length) {
//                break;
//            }
//            nums[i] = nums[nums.length - k + i];
//            nums[nums.length - k + i] = nums[i + k];
//
//            System.out.println(Arrays.toString(nums));
//        }
        return null;
    }

    @Test
    public void test() {
        assertThat(rotate(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 3), equalTo(new int[]{6, 7, 8, 1, 2, 3, 4, 5}));
    }

}
