package leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Cherie on 2020/05/06
 * https://leetcode.com/problems/majority-element/
 **/
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int half = nums.length / 2, count;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            count = map.getOrDefault(num, 0) + 1;
            if (count > half) {
                return num;
            }
            map.put(num, count);
        }
        return 0;
    }
}
