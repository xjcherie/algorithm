package leetcode.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cherie on 2021/03/29
 * https://leetcode.com/problems/subsets/
 **/
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());

        for (int num : nums) {
            List<List<Integer>> newList = new ArrayList<>();
            for (List<Integer> subList : ans) {
                newList.add(new ArrayList<>(subList));
                subList.add(num);
            }
            newList.addAll(ans);
            ans = newList;
        }
        return ans;
    }

    @Test
    public void test() {
        subsets(new int[]{1, 2, 3});
    }

}
