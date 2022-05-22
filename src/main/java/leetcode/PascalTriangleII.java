package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Cherie on 2022/05/15
 * https://leetcode.com/problems/set-matrix-zeroes/
 **/
public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        int[] ans = new int[rowIndex + 1];
        ans[0] = 1;
        ans[rowIndex] = 1;
        for (int i = 1; i < rowIndex + 1; i++) {
            int tmp = 1;
            for (int j = 1; j < i; j++) {
                int pre = ans[j - 1];
                ans[j - 1] = tmp;
                tmp = pre + ans[j];
            }
            ans[i - 1] = tmp;
            ans[i] = 1;
        }
        return Arrays.stream(ans)
                .boxed()
                .collect(Collectors.toList());
    }
}
