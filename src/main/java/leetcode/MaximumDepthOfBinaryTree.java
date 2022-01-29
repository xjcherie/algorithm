package leetcode;

import leetcode.common.TreeNode;

/**
 * Created by Cherie on 2021/03/16
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 **/
public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(this.maxDepth(root.left), this.maxDepth(root.right));
    }

}
