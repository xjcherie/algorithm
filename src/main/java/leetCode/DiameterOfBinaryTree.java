package leetCode;

import leetCode.common.TreeNode;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2020/04/11
 * https://leetcode.com/problems/diameter-of-binary-tree/
 **/
public class DiameterOfBinaryTree {
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        deep(root);
        return diameter;
    }

    private int deep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDeep = deep(root.left);
        int rightDeep = deep(root.right);
        diameter = Math.max(diameter, leftDeep + rightDeep);
        return Math.max(leftDeep, rightDeep) + 1;
    }

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        assertThat(diameterOfBinaryTree(node1), equalTo(3));
    }
}
