package leetcode.string;


import com.sun.xml.internal.ws.util.StringUtils;
import org.junit.Test;
import org.mockito.internal.util.StringUtil;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2022/03/20
 * https://leetcode.com/problems/add-binary/
 **/
public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int aLength = a.length() - 1, bLength = b.length() - 1;
        int index = Math.min(aLength, bLength);
        int flag = 0;
        for (int i = 0; i <= index; i++) {
            if (a.charAt(aLength - i) == '1') flag++;
            if (b.charAt(bLength - i) == '1') flag++;

            if (flag == 3) {
                sb.append('1');
                flag = 1;
            } else if (flag == 2) {
                sb.append('0');
                flag = 1;
            } else if (flag == 1) {
                sb.append('1');
                flag = 0;
            } else {
                sb.append('0');
            }
        }
        for (int length = aLength - index - 1; length >= 0; length--) {
            if (a.charAt(length) == '1') flag++;
            if (flag == 2) {
                sb.append('0');
                flag = 1;
            } else if (flag == 1) {
                sb.append('1');
                flag = 0;
            } else {
                sb.append('0');
            }
        }
        for (int length = bLength - index - 1; length >= 0; length--) {
            if (b.charAt(length) == '1') flag++;
            if (flag == 2) {
                sb.append('0');
                flag = 1;
            } else if (flag == 1) {
                sb.append('1');
                flag = 0;
            } else {
                sb.append('0');
            }
        }
        if (flag == 1) sb.append('1');

        StringBuilder ans = new StringBuilder();
        for (int length = sb.length(); length > 0; length--) {
            ans.append(sb.charAt(length - 1));
        }
        return ans.toString();
    }

    @Test
    public void test() {
        assertThat(addBinary("11", "1"), equalTo("100"));
    }
}
