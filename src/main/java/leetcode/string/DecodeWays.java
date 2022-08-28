package leetcode.string;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @Author: Cherie
 * @Date: 2022-08-28
 * <a href="https://leetcode.com/problems/decode-ways/">91. Decode Ways</a>
 */
public class DecodeWays {
    public int numDecodings(String s) {
        int length = s.length();
        int[] array = new int[length + 1];
        array[0] = 1;
        for (int i = 1; i <= length; i++) {
            if (s.charAt(i - 1) != '0') {
                array[i] += array[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                array[i] += array[i - 2];
            }
        }
        return array[length];
    }

    @Test
    public void test() {
        assertThat(numDecodings("12"), equalTo(2));
    }
}
