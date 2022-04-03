package leetcode.tree;

import leetcode.common.TreeNode;

/**
 * Created by Cherie on 2022/04/03
 * https://leetcode.com/problems/same-tree/
 **/
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;
        if (!this.isSameTree(p.left, q.left)) {
            return false;
        }
        return this.isSameTree(p.right, q.right);
    }
}
