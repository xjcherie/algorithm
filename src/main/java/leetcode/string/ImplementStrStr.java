package leetcode.string;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2022/02/23
 * https://leetcode.com/problems/implement-strstr/
 **/
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) return 0;

        int desLength = needle.length() - 1;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) != needle.charAt(0)) {
                continue;
            }
            if (haystack.length() - i < desLength) {
                break;
            }
            int firstIndex = i + 1, secondIndex = 1;
            while (firstIndex < haystack.length() && secondIndex < needle.length()
                    && haystack.charAt(firstIndex) == needle.charAt(secondIndex)) {
                firstIndex++;
                secondIndex++;
            }
            secondIndex--;
            if (secondIndex == desLength) {
                return i;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        assertThat(strStr("hello", "ll"), equalTo(2));
    }
}
