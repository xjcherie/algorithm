package leetcode.stack;

import org.junit.Test;

import java.util.Stack;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2020/03/24
 * https://leetcode.com/problems/valid-parentheses/
 **/
public class ValidParentheses {

    public boolean isValid(String s) {
        if (s == null || s.equals("")) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && getReverseBracket(stack.peek()) == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid1(String s) {
        if (s == null || s.equals("")) {
            return true;
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (ans.length() > 0 && getReverseBracket(ans.charAt(ans.length() - 1)) == s.charAt(i)) {
                ans.deleteCharAt(ans.length() - 1);
            } else {
                ans.append(s.charAt(i));
            }
        }
        return ans.length() == 0;
    }

    private char getReverseBracket(char c) {
        switch (c) {
            case '(':
                return ')';
            case '[':
                return ']';
            default:
                return '}';
        }
    }

    @Test
    public void test() {
        assertThat(isValid("()"), equalTo(true));
        assertThat(isValid("()[]{}"), equalTo(true));
        assertThat(isValid("(]"), equalTo(false));
        assertThat(isValid("([)]"), equalTo(false));
        assertThat(isValid("{[]}"), equalTo(true));
    }

}
