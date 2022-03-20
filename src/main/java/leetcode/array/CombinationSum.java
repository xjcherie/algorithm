package leetcode.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2022/March/13
 * https://leetcode.com/problems/combination-sum/
 **/
public class CombinationSum {

    private static List<List<Integer>> ans;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
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
        List<List<Integer>> list1 = new ArrayList<>();
        {
            {
                List<Integer> subList = new ArrayList<>();
                subList.add(2);
                subList.add(2);
                subList.add(3);
                list1.add(subList);
            }
            {
                List<Integer> subList = new ArrayList<>();
                subList.add(7);
                list1.add(subList);
            }
        }
        List<List<Integer>> list2 = new ArrayList<>();
        {
            {
                List<Integer> subList = new ArrayList<>();
                subList.add(2);
                subList.add(2);
                subList.add(2);
                subList.add(2);
                list2.add(subList);
            }
            {
                List<Integer> subList = new ArrayList<>();
                subList.add(2);
                subList.add(3);
                subList.add(3);
                list2.add(subList);
            }
            {
                List<Integer> subList = new ArrayList<>();
                subList.add(3);
                subList.add(5);
                list2.add(subList);
            }
        }

        assertThat(combinationSum(new int[]{2, 3, 6, 7}, 7), equalTo(list1));
        assertThat(combinationSum(new int[]{2, 3, 5}, 8), equalTo(list2));
    }
}
