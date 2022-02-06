package leetcode.integer;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2022/02/02
 * https://leetcode.com/problems/reverse-integer/
 **/
public class ReverseInteger {

    public int reverse(int x) {
        String s = String.valueOf(x);
        StringBuilder answerStr = new StringBuilder();
        for (int i = s.length() - 1; i > 0; i--) {
            answerStr.append(s.charAt(i));
        }
        long answer;
        if (s.charAt(0) == '-') {
            answer = -1L * Long.parseLong(answerStr.toString());
        } else {
            answer = Long.parseLong(answerStr.append(s.charAt(0)).toString());
        }
        if (answer < Math.pow(-2, 31) || answer > Math.pow(2, 31) - 1) {
            return 0;
        }
        return (int) answer;
    }

    @Test
    public void test() {
        assertThat(reverse(123), equalTo(321));
    }

}
