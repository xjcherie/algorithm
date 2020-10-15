package leetcode.tree;

import leetcode.common.TreeNode;

/**
 * Created by Cherie on 2020/04/30
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/532/week-5/3315/
 **/
public class CheckStringIsAValidSequence {

    private int[] compareArray;

    public boolean isValidSequence(TreeNode root, int[] arr) {
        compareArray = arr;
        try {
            this.search(root, 0);
        } catch (Exception e) {
            return true;
        }
        return false;
    }

    private void search(TreeNode root, int i) {
        if (i == compareArray.length || root.val != compareArray[i]) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (i == compareArray.length - 1) {
                throw new RuntimeException();
            }
            return;
        }
        i++;
        if (root.left != null) {
            this.search(root.left, i);
        }
        if (root.right != null) {
            this.search(root.right, i);
        }
    }
}
