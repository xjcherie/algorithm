package leetcode.stack;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2020/05/13
 * https://leetcode.com/problems/remove-k-digits/
 **/
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        int length = num.length();
        StringBuilder sb = new StringBuilder(num);
        for (int i = 0; i < length; i++) {
            if (k == 0) {
                break;
            }
            if (i == length - 1 || sb.charAt(i) > sb.charAt(i + 1)) {
                k--;
                sb.deleteCharAt(i);
                i = (i > 0) ? i - 2 : i - 1;
                length--;
            }
        }
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    @Test
    public void test() {
        assertThat(removeKdigits("1234567890", 9), equalTo("0"));
    }
}
