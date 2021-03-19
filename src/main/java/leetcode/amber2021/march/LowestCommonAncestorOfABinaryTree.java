package leetcode.amber2021.march;

import leetcode.common.TreeNode;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2021/03/17
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 **/
public class LowestCommonAncestorOfABinaryTree {

    private TreeNode ancestorNode = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.searchDescendant(root, p, q);
        return ancestorNode;
    }

    private TreeNode searchDescendant(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null || ancestorNode != null) return null;

        TreeNode descendant = null;
        if (node.val == p.val || node.val == q.val) {
            descendant = node;
        }

        TreeNode leftDescendant = this.searchDescendant(node.left, p, q);
        if (descendant != null && leftDescendant != null) {
            ancestorNode = descendant;
            return null;
        }

        TreeNode rightDescendant = this.searchDescendant(node.right, p, q);
        if ((descendant != null || leftDescendant != null) && rightDescendant != null) {
            ancestorNode = node;
            return null;
        }

        return leftDescendant != null ? leftDescendant : (rightDescendant != null ? rightDescendant : descendant);
    }

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(0);
        TreeNode node7 = new TreeNode(8);
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;

        assertThat(lowestCommonAncestor(node1, new TreeNode(5), new TreeNode(1)), equalTo(node1));
    }

}
