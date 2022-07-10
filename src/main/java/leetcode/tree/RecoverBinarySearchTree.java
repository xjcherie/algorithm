package leetcode.tree;

import leetcode.common.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Cherie
 * @Date: 2022-07-10
 * <a href="https://leetcode.com/problems/recover-binary-search-tree/">99. Recover Binary Search Tree</a>
 */
public class RecoverBinarySearchTree {

    private static List<Integer> list;

    private int index = 0;

    public void recoverTree(TreeNode root) {
        list = new ArrayList<>();
        this.initSourceData(root);
        Collections.sort(list);
        this.reorganizeTree(root);
    }

    private void initSourceData(TreeNode node) {
        if (node == null) {
            return;
        }
        this.initSourceData(node.left);
        this.initSourceData(node.right);
        list.add(node.val);
    }

    private void reorganizeTree(TreeNode node) {
        if (node == null) {
            return;
        }
        this.reorganizeTree(node.left);
        node.val = list.get(index++);
        this.reorganizeTree(node.right);
    }

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(2);
        node1.left = node2;
        node2.right = node3;
        recoverTree(node1);
    }
}
