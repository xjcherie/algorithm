package leetcode.tree;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Cherie
 * @Date: 2022-06-05
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 */
public class BinaryTreePostorderTraversal {
    private final List<Integer> ans = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return ans;
        this.postorderTraversal(root.left);
        this.postorderTraversal(root.right);
        ans.add(root.val);
        return ans;
    }
}
