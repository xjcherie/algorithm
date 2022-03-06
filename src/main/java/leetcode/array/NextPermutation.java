package leetcode.array;

import org.junit.Test;

/**
 * Created by Cherie on 2022/01/28
 * todo 寻找需要交换的最左侧索引的思路有问题
 * 1. 对于需要排序的右侧数组，使用的选择排序(忘记快排怎么回事了)
 * 2. 当值为最大值时，交换了数组的顺序
 * https://leetcode.com/problems/next-permutation/
 **/
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) return;

        int length = nums.length;
        int rightIndex = length - 1;
        while (rightIndex >= 0) {
            int digit = nums[rightIndex];
            for (int i = rightIndex - 1; i >= 0; i--) {
                if (nums[i] < digit) {
                    int tmp = nums[i];
                    nums[i] = nums[rightIndex];
                    nums[rightIndex] = tmp;
                    this.resetArray(nums, i + 1, length - 1);
                    return;
                }
            }
            rightIndex--;
        }

        int tmp;
        for (int i = 0; i < (length / 2); i++) {
            tmp = nums[i];
            nums[i] = nums[length - 1 - i];
            nums[length - 1 - i] = tmp;
        }
    }

    private void resetArray(int[] nums, int leftIndex, int rightIndex) {
        int index = 0, tmpIndex, tmp;
        while (index <= rightIndex - leftIndex) {
            tmpIndex = leftIndex;
            tmp = nums[leftIndex];
            for (int i = leftIndex + 1; i <= rightIndex - index; i++) {
                if (nums[i] > tmp) {
                    tmpIndex = i;
                    tmp = nums[i];
                }
            }
            nums[tmpIndex] = nums[rightIndex - index];
            nums[rightIndex - index] = tmp;
            index++;
        }
    }

    @Test
    public void test() {
        nextPermutation(new int[]{3, 2, 1});
    }
}
