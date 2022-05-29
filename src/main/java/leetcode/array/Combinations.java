package leetcode.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Cherie
 * @Date: 2022-05-28
 * https://leetcode.com/problems/combinations/
 */
public class Combinations {

    private final List<Integer> temp = new ArrayList<>();
    private final List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        this.dfs(1, n, k);
        return ans;
    }

    public void dfs(int cur, int n, int k) {
        if (temp.size() + (n - cur + 1) < k) {
            return;
        }
        if (temp.size() == k) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(cur);
        this.dfs(cur + 1, n, k);
        temp.remove(temp.size() - 1);
        this.dfs(cur + 1, n, k);
    }

    @Test
    public void test() {
        System.out.println(combine(4, 2));
    }

}
