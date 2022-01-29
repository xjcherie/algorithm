package leetcode;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2021/03/04
 * https://leetcode.com/problems/powx-n/
 **/
public class PowXN {
    public double myPow(double x, int n) {
        if (x == 0 || x == 1 || n == 1) return x;
        if (n == 0) return 1;
        if (n == -1) return 1 / x;
//        return Math.pow(x, n);
        long newN = n;
        if (n < 0) {
            x = 1 / x;
            newN *= -1;
        }
        double ans = x;
        for (int i = 1; i < newN / 2; i++) {
            ans *= x;
        }
        ans *= ans;
        if (newN % 2 != 0) ans *= x;
        return ans;
    }

    @Test
    public void test() {
        assertThat(myPow(2.00000, -2147483648), equalTo(1024));
    }

}


