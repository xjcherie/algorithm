package leetcode.integer;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2022/02/28
 * https://leetcode.com/problems/divide-two-integers/
 **/
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        boolean negativeFlag = (long) dividend * divisor < 0;
        long newDividend = dividend < 0 ? (long) -1 * dividend : dividend;
        long newDivisor = divisor < 0 ? (long) -1 * divisor : divisor;

        long count = 0;
        if (divisor == 1 || divisor == -1) {
            count = newDividend;
        } else {
            while (newDividend >= newDivisor) {
                newDividend -= newDivisor;
                count++;
            }
        }

        if (negativeFlag) count *= -1;
        if (count >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (count <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) count;
    }

    @Test
    public void test() {
        assertThat(divide(-2147483648, 1), equalTo(-2147483648));
    }
}
