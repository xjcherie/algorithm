package leetcode.array;

/**
 * Created by Cherie on 2022/03/04
 * https://leetcode.com/problems/search-insert-position/
 **/
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int index = 0;
        while (index < nums.length) {
            if (nums[index] < target) {
                index++;
            } else if (nums[index] == target) {
                return index;
            } else {
                break;
            }
        }
        return index;
    }
}
