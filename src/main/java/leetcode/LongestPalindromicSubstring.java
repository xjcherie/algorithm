package leetcode;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2020/08/19
 * https://leetcode.com/problems/longest-palindromic-substring/
 **/
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        int length = s.length();

        int[][] dp = new int[length + 1][length + 1];
        String ans = "";

        for (int l = 0; l < dp.length; l++) {
            for (int i = 0; i + l < dp.length; i++) {
                int j = i + l;
                if (i == 0) {
                    dp[i][j] = 1;
                } else if (s.charAt(i) == s.charAt(j)) {
                    if (l == 1) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] > 0 && l + 1 > length) {
                    ans = s.substring(i, i + l + 1);
                }
            }
        }

        return ans;
    }

    public String longestPalindrome1(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        char[] chars = s.toCharArray();

        int max = 0;
        String longestPalindrome = "";

        StringBuilder rightStr;
        StringBuilder leftStr;

        int length = chars.length;

        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j >= i; j--) {

                leftStr = new StringBuilder();
                rightStr = new StringBuilder();
                boolean flag = true;
                int count = (int) Math.ceil(((double) j - i + 1) / 2);

                for (int m = 0; m < count; m++) {
                    if (chars[i + m] != chars[j - m]) {
                        flag = false;
                        break;
                    }
                    leftStr.append(chars[i + m]);
                    if (i + m < j - m) {
                        rightStr.insert(0, chars[j - m]);
                    }
                }

                if (!flag) {
                    continue;
                }
                StringBuilder palindrome = leftStr.append(rightStr);
                if (palindrome.length() > max) {
                    longestPalindrome = palindrome.toString();
                    max = longestPalindrome.length();
                }
            }
        }

        return longestPalindrome.equals("") ? String.valueOf(s.charAt(0)) : longestPalindrome;
    }

    @Test
    public void test() {
        assertThat(longestPalindrome("babad"), equalTo("bab"));
        assertThat(longestPalindrome("ba"), equalTo("b"));
        assertThat(longestPalindrome("ccc"), equalTo("ccc"));
        assertThat(longestPalindrome("aaaa"), equalTo("aaaa"));
    }
}
