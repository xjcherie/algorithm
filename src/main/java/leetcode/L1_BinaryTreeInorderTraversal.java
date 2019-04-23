package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cherie on 2019/4/16.
 * 树节点中序遍历
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class L1_BinaryTreeInorderTraversal {

    // 法一：通过递归获取值
    private static ArrayList<Integer> inorderRecursive(TreeNode node, ArrayList<Integer> intList) {
        if (node == null) {
            return intList;
        }
        if (node.left != null) {
            inorderRecursive(node.left, intList);
        }
        intList.add(node.val); // 决定了该遍历是前、中、后序遍历的哪一种
        if (node.right != null) {
            inorderRecursive(node.right, intList);
        }
        return intList;
    }

    // 法二：通过循环获取值
    private static ArrayList<Integer> inorderIterative(TreeNode root, ArrayList<Integer> intList) {
        TreeNode node = root;
        while (node != null) {
            if (node.left == null) {
                intList.add(node.val);
                node = node.right;
            } else {
                TreeNode rightNode = node.left;
                while (rightNode.right != null) {
                    rightNode = rightNode.right;
                }
                TreeNode tempNode = node; // 对节点清理做准备
                rightNode.right = node;
                node = node.left;
                tempNode.left = null;
            }
        }

        return intList;
    }

    public static void main(String[] args) {
        TreeNode root = createTreeNode();
        List<Integer> recursiveResult = inorderRecursive(root, new ArrayList<>());
        List<Integer> iterativeResult = inorderIterative(root, new ArrayList<>());
        System.out.println(recursiveResult);
        System.out.println(iterativeResult);
    }

    /**
     * 获取测试树节点
     */
    private static TreeNode createTreeNode() {
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        root.left = node1;
        root.right = node2;
        node1.right = node3;
        node1.left = node4;
        node2.right = node5;
        node3.left = node6;
        return root;
    }

    /**
     * 树节点类定义
     */
    static class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
