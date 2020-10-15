package leetcode.string;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2020/05/31
 * https://leetcode.com/problems/edit-distance/
 * todo
 **/
public class EditDistance {

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (word1.charAt(i) == word2.charAt(j))
                    dp[i + 1][j + 1] = dp[i][j];
                else
                    dp[i + 1][j + 1] = Math.min(dp[i + 1][j], Math.min(dp[i][j + 1], dp[i][j])) + 1;
            }
        return dp[m][n];
    }

    public int minDistance1(String word1, String word2) {
        return editDistance(word1, word2, 0, 0);
    }

    private int editDistance(String word1, String word2, int i, int j) {
        if (i == word1.length() || j == word2.length()) {
            return Math.max(word2.length() - j, word1.length() - i);
        }
        if (word1.charAt(i) == word2.charAt(j)) {
            return editDistance(word1, word2, i + 1, j + 1);
        }
        return 1 +
                Math.min(
                        editDistance(word1, word2, i + 1, j + 1),
                        Math.min(
                                editDistance(word1, word2, i + 1, j),
                                editDistance(word1, word2, i, j + 1)
                        )
                );
    }

    @Test
    public void test() {
        assertThat(minDistance("horse", "ros"), equalTo(3));
    }
}
