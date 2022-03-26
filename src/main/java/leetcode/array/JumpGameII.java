package leetcode.array;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2022/March/26
 * https://leetcode.com/problems/jump-game-ii/
 **/
public class JumpGameII {
    public int jump(int[] nums) {
        int count = 0;
        int i = 0;
        while (i < nums.length - 1) {
            int maxDistance = nums[i];
            int nextStep = i + 1;
            for (int j = nextStep; j <= (i + maxDistance) && j < nums.length; j++) {
                if (j == nums.length - 1) {
                    return count + 1;
                }
                if (nums[j] >= nums[nextStep] - (j - nextStep)) {
                    nextStep = j;
                }
            }
            i = nextStep;
            count++;
        }
        return count;
    }

    @Test
    public void test() {
        assertThat(jump(new int[]{3, 3, 2, 5, 4, 3, 9, 5, 5, 7, 9, 4, 9, 1, 0, 3, 6, 8, 2}), equalTo(4));
    }
}
