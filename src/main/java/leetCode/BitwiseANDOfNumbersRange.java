package leetCode;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2020/04/23
 * https://leetcode.com/problems/bitwise-and-of-numbers-range/
 * todo
 **/
public class BitwiseANDOfNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0) {
            return 0;
        }
        while (n > m) {
            n = n & (n - 1);
        }
        return n;
    }

    @Test
    public void test() {
        assertThat(rangeBitwiseAnd(5, 7), equalTo(4));
    }

}
