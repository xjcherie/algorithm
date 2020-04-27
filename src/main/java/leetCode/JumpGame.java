package leetCode;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2020/04/25
 * https://leetcode.com/problems/jump-game/
 **/
public class JumpGame {

    public boolean canJump(int[] nums) {
        int zeroCount = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] == 0) {
                zeroCount++;
                continue;
            }
            if (zeroCount == 0) {
                continue;
            }
            if (nums[i] <= zeroCount) {
                zeroCount++;
            } else {
                zeroCount = 0;
            }
        }
        return zeroCount == 0;
    }

    @Test
    public void test() {
        assertThat(canJump(new int[]{2, 3, 1, 1, 4}), equalTo(true));
        assertThat(canJump(new int[]{3, 2, 1, 0, 4}), equalTo(false));
        assertThat(canJump(new int[]{0}), equalTo(true));
        assertThat(canJump(new int[]{1}), equalTo(true));
        assertThat(canJump(new int[]{2, 0}), equalTo(true));
        assertThat(canJump(new int[]{1, 1, 2, 2, 0, 1, 1}), equalTo(true));
    }
}
