package leetCode;

import org.junit.Test;

/**
 * Created by Cherie on 2019/4/24.
 * 二叉查找树找最小值
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */
public class BSTKthSmallestElement {
    public int kthSmallest(TreeNode root, int k) {
        int index = 0;
        TreeNode node = root;
        while (node != null) {
            if (node.left != null) {
                node = node.left;
            } else {
                index++;
                if (index == k) {
                    return node.val;
                }
                node = node.right;
            }
        }
        return 0;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(2);
        root.left = node1;
        root.right = node2;
        node1.right = node3;

        kthSmallest(root, 1);
    }
}
