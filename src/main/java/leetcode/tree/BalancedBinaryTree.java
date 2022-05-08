package leetcode.tree;

import leetcode.common.TreeNode;

/**
 * Created by Cherie on 2022/05/08
 * https://leetcode.com/problems/balanced-binary-tree/
 **/
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        try {
            this.recursion(root, 0);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private int recursion(TreeNode node, int count) {
        if (node == null) return count;
        count++;
        int leftCount = recursion(node.left, count);
        int rightCount = recursion(node.right, count);
        if (Math.abs(leftCount - rightCount) > 1) {
            throw new RuntimeException();
        }
        return Math.max(leftCount, rightCount);
    }
    
}
