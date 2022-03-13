package leetcode.string;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2022/03/13
 * https://leetcode.com/problems/count-and-say/
 **/
public class CountAndSay {
    public String countAndSay(int n) {
        String str = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            char digit = str.charAt(0);
            for (int j = 1; j < str.length(); j++) {
                if (str.charAt(j) != digit) {
                    sb.append(count).append(digit);
                    count = 0;
                    digit = str.charAt(j);
                }
                count++;
            }
            sb.append(count).append(digit);
            str = sb.toString();
        }
        return str;
    }

    @Test
    public void test() {
        assertThat(countAndSay(4), equalTo("1211"));
    }
}
