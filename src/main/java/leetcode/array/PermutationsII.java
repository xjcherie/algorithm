package leetcode.array;

import java.util.*;

/**
 * Created by Cherie on 2022/04/10
 * https://leetcode.com/problems/permutations-ii/
 **/
public class PermutationsII {

    Set<List<Integer>> result;

    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new HashSet<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        this.traverse(nums, new HashMap<>(countMap), new ArrayList<>(), nums.length);
        return new ArrayList<>(result);
    }

    private void traverse(int[] nums, Map<Integer, Integer> countMap, List<Integer> list, int length) {
        if (length == list.size()) {
            result.add(list);
            return;
        }
        for (int num : nums) {
            if (countMap.get(num) == 0) {
                continue;
            }
            HashMap<Integer, Integer> newCountMap = new HashMap<>(countMap);
            newCountMap.put(num, newCountMap.get(num) - 1);

            List<Integer> newList = new ArrayList<>(list);
            newList.add(num);

            this.traverse(nums, newCountMap, newList, length);
        }
    }

}
