package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Cherie on 2021/02/02
 * https://leetcode.com/problems/contains-duplicate/
 **/
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return nums.length != set.size();
    }

}
