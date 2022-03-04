package leetcode.array;

import org.junit.Test;

/**
 * Created by Cherie on 2022/01/28
 * https://leetcode.com/problems/next-permutation/
 **/
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) return;

        int leftIndex = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                leftIndex = i;
                break;
            }
        }
        if (leftIndex >= 0) {
            int tmp = nums[leftIndex];
            for (int j = leftIndex; j < nums.length - 1; j++) {
                nums[j] = nums[j + 1];
            }
            nums[nums.length - 1] = tmp;
        } else {
            int[] newNum = new int[nums.length];
            int index = 0;
            for (int i = nums.length - 1; i >= 0; i--) {
                newNum[index] = nums[i];
                index++;
            }
            for (int i = 0; i < nums.length; i++) {
                nums[i] = newNum[i];
            }
        }
    }

    @Test
    public void test() {
        nextPermutation(new int[]{3, 2, 1});
    }
}
