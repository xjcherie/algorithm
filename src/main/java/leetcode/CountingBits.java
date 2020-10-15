package leetcode;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2020/05/28
 * https://leetcode.com/problems/counting-bits/
 * 2n，2n+1
 **/
public class CountingBits {

    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        calculateAllNum(ans, 1, 1);
        return ans;
    }

    private void calculateAllNum(int[] ans, int count, int num) {
        if (num >= ans.length) {
            return;
        }
        ans[num] = count;

        calculateAllNum(ans, count, 2 * num);
        calculateAllNum(ans, count + 1, 2 * num + 1);
    }

    public int[] countBits1(int num) {
        int[] ans = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int count = 0;
            int digit = i;
            while (digit > 1) {
                count += digit % 2;
                digit = digit / 2;
            }
            count += digit;
            ans[i] = count;
        }
        return ans;
    }

    @Test
    public void test() {
        assertThat(countBits(8), equalTo(new int[]{0, 1, 1, 2, 1, 2, 2, 3, 1}));
    }

}
