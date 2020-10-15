package leetcode.stack;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2020/04/09
 * https://leetcode.com/problems/backspace-string-compare/
 **/
public class BackspaceStringCompare {

    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    private String build(String S) {
        StringBuilder s = new StringBuilder();
        int sCount = 0;
        for (int length = S.length() - 1; length >= 0; length--) {
            char c = S.charAt(length);
            if ('#' == c) {
                sCount++;
            } else if (sCount > 0) {
                sCount--;
            } else {
                s.append(c);
            }
        }
        return s.toString();
    }

    public boolean backspaceCompare1(String S, String T) {
        StringBuilder s = new StringBuilder(this.build(S));
        int tCount = 0;
        for (int length = T.length() - 1; length >= 0; length--) {
            char c = T.charAt(length);
            if ('#' == c) {
                tCount++;
            } else if (tCount > 0) {
                tCount--;
            } else if (s.length() >= 0 && s.charAt(0) == c) {
                s.deleteCharAt(0);
            } else {
                break;
            }
        }
        return s.length() == 0;
    }

    @Test
    public void test() {
        assertThat(backspaceCompare("ab#c", "ad#c"), equalTo(true));
        assertThat(backspaceCompare("ab##", "c#d#"), equalTo(true));
    }

}
