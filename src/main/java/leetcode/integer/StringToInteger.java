package leetcode.integer;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2022/02/06
 * https://leetcode.com/problems/string-to-integer-atoi/
 **/
public class StringToInteger {

    public int myAtoi(String s) {
        String content = s.trim();
        if (content.length() == 0) return 0;

        StringBuilder sb = new StringBuilder();
        boolean symbolFlag = true, zeroFlag = false;
        char firstChar = content.charAt(0);
        if (firstChar == '-') {
            symbolFlag = false;
            zeroFlag = true;
        } else if (firstChar == '+') {
            zeroFlag = true;
        } else if (firstChar == '0') {
            zeroFlag = true;
        } else if (!Character.isDigit(firstChar)) {
            return 0;
        } else {
            sb.append(firstChar);
        }

        for (int i = 1; i < content.length(); i++) {
            char c = content.charAt(i);
            if (zeroFlag && c == '0') {
                continue;
            }
            if (!Character.isDigit(c)) {
                break;
            }
            zeroFlag = false;
            sb.append(c);
        }

        String answerStr;
        if (sb.length() == 0) {
            return 0;
        } else if (sb.length() > 10) {
            if (symbolFlag) return Integer.MAX_VALUE;
            return Integer.MIN_VALUE;
        } else {
            answerStr = sb.toString();
        }
        long answer = (symbolFlag ? 1 : -1) * Long.parseLong(answerStr);
        if (answer < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        if (answer > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return (int) answer;
    }

    @Test
    public void test() {
        assertThat(myAtoi("   42"), equalTo(42));
        assertThat(myAtoi("   -42"), equalTo(-42));
        assertThat(myAtoi("4193 with words"), equalTo(4193));
        assertThat(myAtoi("-91283472332"), equalTo(-2147483648));
        assertThat(myAtoi("+-12"), equalTo(0));
        assertThat(myAtoi("010"), equalTo(10));
        assertThat(myAtoi("20000000000000000000"), equalTo(2147483647));
        assertThat(myAtoi("-000000000000001"), equalTo(-1));
    }

}
