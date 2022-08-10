package leetcode.tree;

/**
 * @Author: Cherie
 * @Date: 2022-08-04
 * <a href="https://leetcode.com/problems/unique-binary-search-trees/">96. Unique Binary Search Trees</a>
 */
public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

}
