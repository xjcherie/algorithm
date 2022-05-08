package leetcode.tree;

import leetcode.common.TreeNode;

/**
 * Created by Cherie on 2022/05/08
 * https://leetcode.com/problems/path-sum/
 **/
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return this.recursion(root, targetSum, 0);
    }

    private boolean recursion(TreeNode node, int targetSum, int sum) {
        sum += node.val;
        if (node.left == null && node.right == null) {
            return targetSum == sum;
        }
        if (node.left != null && this.recursion(node.left, targetSum, sum)) {
            return true;
        }
        return node.right != null && this.recursion(node.right, targetSum, sum);
    }
}
