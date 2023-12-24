package leetcode.tree;

import leetcode.common.TreeNode;

/**
 * Created by Cherie on 2023/12/24
 * <a href="https://leetcode.com/problems/invert-binary-tree/">226. Invert Binary Tree</a>
 **/
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        this.invertTree(root.left);
        this.invertTree(root.right);
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        return root;
    }
}
