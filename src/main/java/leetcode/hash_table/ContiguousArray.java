package leetcode.hash_table;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by Cherie on 2020/04/13
 * https://leetcode.com/problems/contiguous-array/
 * todo
 **/
public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int max = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count)) {
                max = Math.max(max, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return max;
    }

    @Test
    public void test() {
        assertThat(findMaxLength(new int[]{0, 1}), equalTo(2));
        assertThat(findMaxLength(new int[]{0, 1, 0}), equalTo(2));
        assertThat(findMaxLength(new int[]{0, 1, 0, 1, 0, 1}), equalTo(6));
    }
}
