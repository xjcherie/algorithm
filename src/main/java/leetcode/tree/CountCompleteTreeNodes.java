package leetcode.tree;

import leetcode.common.TreeNode;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * <a href="https://leetcode.com/problems/count-complete-tree-nodes/">222. Count Complete Tree Nodes</a>
 */
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return this.searchLastNode(root, 0, 1);
    }

    private int searchLastNode(TreeNode node, int height, int width) {
        if (node == null) {
            return (int) Math.pow(2, height - 1) - 1 + width;
        }
        if (node.left == null) {
            return (int) Math.pow(2, height) - 1 + width;
        }
        int leftVal = this.searchLastNode(node.left, height + 1, width * 2 - 1);
        int rightVal = this.searchLastNode(node.right, height + 1, width * 2);
        return Math.max(leftVal, rightVal);
    }

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        assertThat(countNodes(node1), equalTo(6));
    }
}
