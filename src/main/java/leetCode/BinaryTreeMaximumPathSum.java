package leetCode;

import leetCode.common.TreeNode;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by Cherie on 2020/04/29
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 **/
public class BinaryTreeMaximumPathSum {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        this.subMax(root);
        return max;
    }

    private int subMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = subMax(root.left);
        int right = subMax(root.right);
        int subMax = Math.max(root.val, Math.max(root.val + left, root.val + right));
        max = Math.max(max, Math.max(subMax, root.val + left + right));
        return Math.max(0, subMax);
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(13);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(1);
        root.left = node1;
        node1.left = node3;
        node3.left = node6;
        node3.right = node7;

        root.right = node2;
        node2.left = node4;
        node4.right = node8;
        node2.right = node5;

        assertThat(maxPathSum(root), equalTo(49));
    }

}
