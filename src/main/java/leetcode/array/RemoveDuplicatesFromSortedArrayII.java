package leetcode.array;

import java.util.HashMap;

/**
 * @Author: Cherie
 * @Date: 2022-06-12
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 */
public class RemoveDuplicatesFromSortedArrayII {

    public int removeDuplicates(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int digit = nums[i];
            int count = map.getOrDefault(digit, 0);
            if (count == 2) {
                continue;
            }
            map.put(digit, count + 1);
            nums[index++] = nums[i];
        }
        return index;
    }
}
