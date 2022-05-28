package leetcode.array;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @Author: Cherie
 * @Date: 2022-05-27
 * https://leetcode.com/problems/adding-spaces-to-a-string/
 */
public class AddingSpacesToAString {

    public String insertSpace(String s, int[] spaces) {
        if (spaces.length == 0) return s;
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (index < spaces.length && i == spaces[index]) {
                sb.append(" ");
                index++;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    @Test
    public void test() {
        assertThat(insertSpace("icodeinpython", new int[]{1, 5, 7, 9}), equalTo("i code in py thon"));
    }

}
