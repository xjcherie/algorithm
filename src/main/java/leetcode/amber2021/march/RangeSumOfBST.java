package leetcode.amber2021.march;

import leetcode.common.TreeNode;

/**
 * Created by Cherie on 2021/03/19
 * https://leetcode.com/problems/range-sum-of-bst/
 **/
public class RangeSumOfBST {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;

        int sum = 0;
        if (root.val < low) {
            sum += this.rangeSumBST(root.right, low, high);
        }
        if (root.val > high) {
            sum += this.rangeSumBST(root.left, low, high);
        }
        if (root.val >= low && root.val <= high) {
            sum += root.val;
            sum += this.rangeSumBST(root.right, low, high);
            sum += this.rangeSumBST(root.left, low, high);
        }
        return sum;
    }

}
