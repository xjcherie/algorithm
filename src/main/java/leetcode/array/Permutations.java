package leetcode.array;

import java.util.*;

/**
 * Created by Cherie on 2022/04/10
 * https://leetcode.com/problems/permutations/
 **/
public class Permutations {

    Set<List<Integer>> result;

    public List<List<Integer>> permute(int[] nums) {
        result = new HashSet<>();
        this.traverse(nums, new LinkedHashSet<>(), nums.length);
        return new ArrayList<>(result);
    }

    private void traverse(int[] nums, LinkedHashSet<Integer> set, int length) {
        if (length == set.size()) {
            result.add(new ArrayList<>(set));
            return;
        }
        for (int num : nums) {
            if (set.contains(num)) {
                continue;
            }
            LinkedHashSet<Integer> newSet = new LinkedHashSet<>(set);
            newSet.add(num);
            this.traverse(nums, newSet, length);
        }
    }
}
