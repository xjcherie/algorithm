package leetcode;

/**
 * Created by Cherie on 2021/03/29
 * https://leetcode.com/problems/house-robber/
 **/
public class HouseRobber {

    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        if (length == 1) return nums[0];
        if (length == 2) return Math.max(nums[0], nums[1]);
        if (length == 3) return Math.max(nums[0] + nums[2], nums[1]);

        nums[2] = nums[0] + nums[2];
        for (int i = 3; i < length; i++) {
            nums[i] = Math.max(nums[i - 3], nums[i - 2]) + nums[i];
        }
        return Math.max(nums[length - 1], nums[length - 2]);
    }

}
