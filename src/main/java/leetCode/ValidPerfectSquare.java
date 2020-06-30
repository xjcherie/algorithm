package leetCode;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2020/05/09
 * https://leetcode.com/problems/valid-perfect-square/
 **/
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        int result = 0;
        int digit = 2;
        while (num >= digit * 2) {
            if (num % digit == 0) {
                result ^= digit;
                num /= digit;
                digit = 2;
            } else {
                digit++;
            }
        }
        if (num != 1) {
            result ^= num;
        }
        return result == 0;
    }

    @Test
    public void test() {
        assertThat(isPerfectSquare(2147483647), equalTo(false));
    }
}
