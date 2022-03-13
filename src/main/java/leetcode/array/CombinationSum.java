package leetcode.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cherie on 2022/March/13
 * https://leetcode.com/problems/combination-sum/
 * Todo: Same case, the Testcase passed, but the submission failed.
 **/
public class CombinationSum {

    private static List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        for (int i = 0; i < candidates.length; i++) {
            this.check(candidates, new ArrayList<>(), i, 0, target);
        }
        return ans;
    }

    private void check(int[] candidates, List<Integer> list, int index, int sum, int target) {
        sum += candidates[index];
        if (sum > target) {
            return;
        }
        List<Integer> subList = new ArrayList<>(list);
        subList.add(candidates[index]);
        if (sum == target) {
            ans.add(subList);
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            this.check(candidates, subList, i, sum, target);
        }
    }

    @Test
    public void test() {
        combinationSum(new int[]{2, 3, 5}, 8);
    }
}
