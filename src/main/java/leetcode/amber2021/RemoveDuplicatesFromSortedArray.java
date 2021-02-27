package leetcode.amber2021;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2021/01/21
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 **/
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
            nums[index] = nums[i];
            index++;
        }
        return index;
    }

    @Test
    public void test() {
        assertThat(removeDuplicates(new int[]{1, 1, 2}), equalTo(2));
        assertThat(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}), equalTo(5));
    }

}
