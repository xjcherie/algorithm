package leetcode;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2020/04/26
 * https://leetcode.com/problems/longest-common-subsequence/
 * todo
 **/
public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n][m];
    }

    @Test
    public void test() {
        assertThat(longestCommonSubsequence("abcde", "ace"), equalTo(3));
        assertThat(longestCommonSubsequence("abc", "abc"), equalTo(3));
        assertThat(longestCommonSubsequence("abc", "def"), equalTo(0));
    }
}
