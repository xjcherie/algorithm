package leetcode.amber2021;

/**
 * Created by Cherie on 2021/02/19
 * https://leetcode.com/problems/move-zeroes/
 **/
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int length = nums.length, index = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        while (index < length) {
            nums[index] = 0;
            index++;
        }
    }

}