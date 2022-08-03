package leetcode.string;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @Author: Cherie
 * @Date: 2022-07-19
 * <a href="https://leetcode.com/problems/interleaving-string/">97. Interleaving String</a>
 */
public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        return this.recursion(s1, s2, s3, 0, 0, 0);
    }

    private boolean recursion(String s1, String s2, String s3, int s1Index, int s2Index, int s3Index) {
        if (s3Index >= s3.length()) {
            return true;
        }
        char c = s3.charAt(s3Index++);
        boolean ans = false;
        if (s1Index < s1.length() && c == s1.charAt(s1Index)) {
            ans = this.recursion(s1, s2, s3, s1Index + 1, s2Index, s3Index);
        }
        if (!ans && s2Index < s2.length() && c == s2.charAt(s2Index)) {
            ans = this.recursion(s1, s2, s3, s1Index, s2Index + 1, s3Index);
        }
        return ans;
    }

    @Test
    public void test() {
        assertThat(isInterleave("aabcc", "dbbca", "aadbbcbcac"), equalTo(true));
    }
}
