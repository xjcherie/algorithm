package leetcode;

/**
 * Created by Cherie on 2023/12/24
 * https://leetcode.com/problems/contains-duplicate/
 **/
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= i + k && j < length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
