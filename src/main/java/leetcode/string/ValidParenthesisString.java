package leetcode.string;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2020/04/16
 * https://leetcode.com/problems/valid-parenthesis-string/
 **/
public class ValidParenthesisString {

    public boolean checkValidString(String s) {
        int lo = 0, hi = 0;
        for (char c : s.toCharArray()) {
            lo += c == '(' ? 1 : -1;
            hi += c != ')' ? 1 : -1;
            if (hi < 0) break; // 保证了 sum("(" + "*") >= sum(")")
            lo = Math.max(lo, 0); // 记录"(")不可被抵销的数量
        }
        return lo == 0;
    }

    public boolean checkValidString1(String s) {
        boolean checkFlag = true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ')') {
                sb.append(s.charAt(i));
                continue;
            }
            boolean flag = false;
            for (int length = sb.length() - 1; length >= 0; length--) {
                if (sb.charAt(length) == '(') {
                    sb.deleteCharAt(length);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                } else {
                    checkFlag = false;
                    break;
                }
            }
        }
        if (sb.length() > 0) {
            for (int length = sb.length() - 1; length >= 0; length--) {
                if (sb.charAt(length) == '(') {
                    if (length == sb.length() - 1) {
                        checkFlag = false;
                        break;
                    } else {
                        sb.deleteCharAt(sb.length() - 1);
                        sb.deleteCharAt(sb.length() - 1);
                    }
                }
            }
        }
        return checkFlag;
    }

    @Test
    public void test() {
        assertThat(checkValidString("()"), equalTo(true));
        assertThat(checkValidString("((*)))"), equalTo(true));
    }
}
