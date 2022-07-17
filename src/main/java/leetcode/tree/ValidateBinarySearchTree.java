package leetcode.tree;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Cherie
 * @Date: 2022-07-17
 * <a href="https://leetcode.com/problems/validate-binary-search-tree/">98. Validate Binary Search Tree</a>
 */
public class ValidateBinarySearchTree {
    private List<Integer> list;

    public boolean isValidBST(TreeNode root) {
        list = new ArrayList<>();
        this.convertToList(root);
        return this.compareElements();
    }

    private void convertToList(TreeNode node) {
        if (node == null) {
            return;
        }
        this.convertToList(node.left);
        list.add(node.val);
        this.convertToList(node.right);
    }

    private boolean compareElements() {
        int preDigit = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            int digit = list.get(i);
            if (preDigit >= digit) {
                return false;
            }
            preDigit = digit;
        }
        return true;
    }
}
