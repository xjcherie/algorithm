package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cherie on 2019/4/16.
 * 树节点中序遍历
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class L1_BinaryTreeInorder {

    private static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> recursiveList = getRecursiveResult(root, new ArrayList<>());
        List<Integer> iterativeList = getIterativeResult(root, new ArrayList<>());
        if (recursiveList != iterativeList) {
            throw new RuntimeException("error: Inconsistent results.");
        }
        return recursiveList;
    }

    // 法一：通过递归获取值
    private static ArrayList<Integer> getRecursiveResult(TreeNode node, ArrayList<Integer> intList) {
        if (node == null) {
            return intList;
        }
        if (node.left != null) {
            getRecursiveResult(node.left, intList);
        }
        intList.add(node.val);
        if (node.right != null) {
            getRecursiveResult(node.right, intList);
        }
        return intList;
    }

    // TODO: 2019/4/16  法二：通过循环获取值
    private static ArrayList<Integer> getIterativeResult(TreeNode node, ArrayList<Integer> intList) {

        return intList;
    }

    public static void main(String[] args) {
        List<Integer> intList = inorderTraversal(createTreeNode());
        System.out.println(intList);
    }

    /**
     * 获取测试树节点
     */
    private static TreeNode createTreeNode() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node4.right = node5;
        node3.left = node6;
        return node1;
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
