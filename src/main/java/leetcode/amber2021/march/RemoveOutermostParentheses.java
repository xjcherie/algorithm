package leetcode.amber2021.march;

import java.util.Stack;

/**
 * Created by Cherie on 2021/03/04
 * https://leetcode.com/problems/remove-outermost-parentheses/
 **/
public class RemoveOutermostParentheses {

    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        int index = 0;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else {
                stack.pop();
            }
            if (stack.isEmpty()) {
                sb.append(S, index + 1, i);
                index = i + 1;
            }
        }
        return sb.toString();
    }

}
