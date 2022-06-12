package leetcode.array;

/**
 * @Author: Cherie
 * @Date: 2022-06-12
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 */
public class SearchInRotatedSortedArrayII {

    public boolean search(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) return false;
        if (length == 1) return nums[0] == target;
        int left = 0, right = length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                return true;
            }
            if (nums[left] == nums[middle] && nums[middle] == nums[right]) {
                ++left;
                --right;
            } else if (nums[left] <= nums[middle]) {
                if (nums[left] <= target && target < nums[middle]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else {
                if (nums[middle] < target && target <= nums[length - 1]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }
        return false;
    }

}
