package leetcode;

import leetcode.common.TreeNode;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2021/03/29
 * https://leetcode.com/problems/binary-tree-tilt/
 **/
public class BinaryTreeTilt {

    private int sum = 0;

    public int findTilt(TreeNode root) {
        this.sumTilt(root);
        return sum;
    }

    private int sumTilt(TreeNode node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) {
            return node.val;
        }
        int leftSum = 0, rightSum = 0;
        if (node.left != null) {
            leftSum = this.sumTilt(node.left);
        }
        if (node.right != null) {
            rightSum = this.sumTilt(node.right);
        }
        sum += Math.abs(leftSum - rightSum);
        return leftSum + rightSum + node.val;
    }

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(9);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        assertThat(findTilt(node1), equalTo(15));
    }
}
