package leetcode.amber2021.march;

import leetcode.common.TreeNode;

/**
 * Created by Cherie on 2021/03/19
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 **/
public class MinimumDepthOfBinaryTree {

    private int minDepth = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        this.traverseTree(root, 1);
        return minDepth;
    }

    private void traverseTree(TreeNode node, int depth) {
        if (depth >= minDepth || node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            minDepth = Math.min(minDepth, depth);
            return;
        }

        depth++;
        this.traverseTree(node.left, depth);
        this.traverseTree(node.right, depth);
    }

}
