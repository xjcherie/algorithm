package leetcode.string;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2022/05/15
 * https://leetcode.com/problems/set-matrix-zeroes/
 **/
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s.length() <= 1) return true;
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= 48 && c <= 57) || (c >= 97 && c <= 122)) {
                sb.append(c);
            }
        }
        int length = sb.length() / 2;
        String backHalfStr = sb.substring(length + sb.length() % 2, sb.length());
        for (int i = 0; i < length; i++) {
            if (sb.charAt(i) != backHalfStr.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        assertThat(isPalindrome("A man, a plan, a canal: Panama"), equalTo(true));
        assertThat(isPalindrome("race a car"), equalTo(false));
    }
}
