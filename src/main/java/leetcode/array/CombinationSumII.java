package leetcode.array;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Created by Cherie on 2022/03/14
 * https://leetcode.com/problems/combination-sum-ii/
 **/
public class CombinationSumII {

    private List<Set<Integer>> ans;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        return null;
    }

    private void search(int[] candidates, int index, int target) {
        int sum = 0;
        while (sum <= target && index < candidates.length) {
            sum += candidates[index];
            index++;
        }
    }

}
