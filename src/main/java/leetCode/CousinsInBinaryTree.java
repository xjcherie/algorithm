package leetCode;

import leetCode.common.TreeNode;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2020/05/07
 * https://leetcode.com/problems/cousins-in-binary-tree/
 **/
public class CousinsInBinaryTree {
    private int targetDepth = 0;
    private int count = 0;
    private int parentVal = 0;

    public boolean isCousins(TreeNode root, int x, int y) {
        this.check(root, x, y, 0, 0);
        return count == 2;
    }

    private void check(TreeNode node, int x, int y, int parent, int depth) {
        if (node == null) {
            return;
        }
        if (node.val == x || node.val == y) {
            if (targetDepth == 0) {
                count++;
                targetDepth = depth;
                parentVal = parent;
            } else {
                if (targetDepth == depth && parentVal != parent) {
                    count++;
                }
            }
            return;
        }
        depth++;
        if (targetDepth != 0 && depth > targetDepth) {
            return;
        }
        this.check(node.left, x, y, node.val, depth);
        this.check(node.right, x, y, node.val, depth);
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
        node3.right = node5;
        assertThat(isCousins(node1, 3, 4), equalTo(false));
    }

}
