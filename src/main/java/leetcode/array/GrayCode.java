package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Cherie
 * @Date: 2022-06-26
 * https://leetcode.com/problems/gray-code/
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        int total = (int) Math.pow(2, n);
        List<Integer> ans = new ArrayList<>(total);
        ans.add(0);
        for (int i = 1; i <= n; i++) {
            int count = ans.size();
            for (int j = count - 1; j >= 0; j--) {
                ans.add(ans.get(j) | (1 << (i - 1)));
            }
        }
        return ans;
    }
}
