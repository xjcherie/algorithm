package leetcode.amber2021.february;

/**
 * Created by Cherie on 2021/02/20
 * https://leetcode.com/problems/two-sum/
 **/
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

}
