package leetcode.array;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2020/04/04
 * https://leetcode.com/problems/move-zeroes/
 **/
public class MoveZeroes {
    public int[] moveZeroes(int[] nums) {
        int zeroNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroNum++;
            } else {
                nums[i - zeroNum] = nums[i];
            }
        }
        for (int i = nums.length - zeroNum; i < nums.length; i++) {
            nums[i] = 0;
        }
        return nums;
    }

    @Test
    public void test() {
        assertThat(moveZeroes(new int[]{0, 1, 0, 3, 12}), equalTo(new int[]{1, 3, 12, 0, 0}));
        assertThat(moveZeroes(new int[]{0}), equalTo(new int[]{0}));
        assertThat(moveZeroes(new int[]{12}), equalTo(new int[]{12}));
    }
}
