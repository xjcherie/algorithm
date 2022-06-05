package leetcode.tree;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Cherie
 * @Date: 2022-06-05
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 */
public class BinaryTreePreorderTraversal {

    private final List<Integer> ans = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return ans;
        ans.add(root.val);
        this.preorderTraversal(root.left);
        this.preorderTraversal(root.right);
        return ans;
    }

}
