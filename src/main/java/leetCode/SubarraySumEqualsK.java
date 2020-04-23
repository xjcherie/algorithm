package leetCode;

import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2020/04/22
 * https://leetcode.com/problems/subarray-sum-equals-k/
 * todo
 **/
public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public int subarraySum1(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int ans = 0;
        int num;
        for (int i = 0; i < nums.length; i++) {
            num = nums[i];
            if (num == k) {
                ans++;
            }
            for (int j = i + 1; j < nums.length; j++) {
                num += nums[j];
                if (num == k) {
                    ans++;
                }
            }
        }
        return ans;
    }

    @Test
    public void test() {
        assertThat(subarraySum(new int[]{1, 1, 1}, 2), equalTo(2));
        assertThat(subarraySum(new int[]{1, 2, 3}, 3), equalTo(2));
    }

}
