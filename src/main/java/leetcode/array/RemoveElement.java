package leetcode.array;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2022/02/22
 * https://leetcode.com/problems/remove-element/
 **/
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int index = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != val) {
                continue;
            }
            nums[i] = nums[index];
            nums[index] = 0;
            index--;
        }
        return index + 1;
    }

    @Test
    public void test() {
        assertThat(removeElement(new int[]{3, 2, 2, 3}, 3), equalTo(new int[]{2, 2, 0, 0}));
    }
}
