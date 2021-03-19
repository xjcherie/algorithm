package leetcode.amber2021.march;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2021/03/04
 * https://leetcode.com/problems/arranging-coins/
 **/
public class ArrangingCoins {
    public int arrangeCoins(int n) {
        if (n <= 1) return n;

        long left = (long) Math.sqrt(2 * (long) n) - 2;
        long right = (long) Math.sqrt(2 * (long) n);

        for (long k = left; k <= right; k++) {
            if ((k + 1) * k / 2 <= n && (k + 2) * (k + 1) / 2 > n) {
                return (int) k;
            }
        }

        return 0;
    }

    @Test
    public void test() {
        assertThat(arrangeCoins(5), equalTo(2));
        assertThat(arrangeCoins(8), equalTo(3));
        assertThat(arrangeCoins(1804289383), equalTo(60070));
    }
}
