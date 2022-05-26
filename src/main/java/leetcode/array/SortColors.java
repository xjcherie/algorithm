package leetcode.array;

import org.junit.Test;

/**
 * @Author: Cherie
 * @Date: 2022/May/26
 * https://leetcode.com/problems/sort-colors/
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int[] colorCount = new int[3];
        for (int num : nums) {
            colorCount[num]++;
        }
        int lastIndex = 0;
        for (int i = 0; i < colorCount.length; i++) {
            for (int j = 0; j < colorCount[i]; j++) {
                nums[j + lastIndex] = i;
            }
            lastIndex += colorCount[i];
        }
    }

    @Test
    public void test() {
        sortColors(new int[]{2, 0, 2, 1, 1, 0});
    }

}
