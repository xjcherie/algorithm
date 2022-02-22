package leetcode.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cherie on 2022/02/22
 * https://leetcode.com/problems/generate-parentheses/
 **/
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        gen(n, n, "", list);
        return list;
    }

    private void gen(int left, int right, String answer, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(answer);
            return;
        }
        if (left > 0) {
            answer += '(';
            this.gen(left - 1, right, answer, result);
            answer = answer.substring(0, answer.length() - 1);
        }
        if (left < right) {
            answer += ')';
            this.gen(left, right - 1, answer, result);
        }
    }

    @Test
    public void test() {
        generateParenthesis(2);
    }

}
