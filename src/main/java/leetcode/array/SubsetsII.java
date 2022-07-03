package leetcode.array;

import org.junit.Test;

import java.util.*;

/**
 * @Author: Cherie
 * @Date: 2022-06-26
 * <a href="https://leetcode.com/problems/subsets-ii/">90. Subsets II</a>
 */
public class SubsetsII {

    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); ++mask) {
            temp.clear();
            boolean flag = true;
            for (int i = 0; i < n; ++i) {
                if ((mask & (1 << i)) != 0) {
                    if (i > 0 && (mask >> (i - 1) & 1) == 0 && nums[i] == nums[i - 1]) {
                        flag = false;
                        break;
                    }
                    temp.add(nums[i]);
                }
            }
            if (flag) {
                ans.add(new ArrayList<>(temp));
            }
        }
        return ans;
    }

    @Test
    public void test() {
        subsetsWithDup(new int[]{1, 2, 2});
    }

}
