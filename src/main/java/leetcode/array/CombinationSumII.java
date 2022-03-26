package leetcode.array;

import java.util.*;

/**
 * Created by Cherie on 2022/03/14
 * https://leetcode.com/problems/combination-sum-ii/
 * todo
 **/
public class CombinationSumII {

    private Set<List<Integer>> ans;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new HashSet<>();
        Arrays.sort(candidates);

        for (int i = 0; i < candidates.length; i++) {
            this.search(candidates, new ArrayList<>(), i, 0, target);
        }
        return new ArrayList<>(ans);
    }

    private void search(int[] candidates, List<Integer> list, int index, int sum, int target) {
        if (index >= candidates.length || sum > target) {
            return;
        }
        sum += candidates[index];
        list.add(candidates[index]);
        if (sum == target) {
            ans.add(list);
            return;
        }
        for (int i = index + 1; i < candidates.length; i++) {
            if (sum > target) {
                break;
            }
            this.search(candidates, new ArrayList<>(list), i, sum, target);
        }
    }

}
