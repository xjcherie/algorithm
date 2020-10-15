package leetcode.hash_table;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2020/04/01
 * https://leetcode.com/problems/single-number/
 **/
public class SingleNumber {

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }

    public int singleNumber1(int[] nums) {
        return Arrays.stream(nums).reduce(0, (acc, x) -> acc ^ x);
    }

    public int singleNumber2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean flag = false;
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (nums[i] == nums[j]) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return nums[i];
            }
        }
        throw new RuntimeException();
    }

    @Test
    public void test() {
        assertThat(singleNumber(new int[]{1, 2, 2}), equalTo(1));
        assertThat(singleNumber(new int[]{4, 1, 2, 1, 2}), equalTo(4));
        assertThat(singleNumber(new int[]{2, 2, 1}), equalTo(1));
    }
}
