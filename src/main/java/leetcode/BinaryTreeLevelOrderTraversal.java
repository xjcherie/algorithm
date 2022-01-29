package leetcode;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cherie on 2021/03/29
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 **/
public class BinaryTreeLevelOrderTraversal {

    private List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return list;

        List<TreeNode> rootList = new ArrayList<>();
        rootList.add(root);

        this.getNodes(rootList);
        return list;
    }

    private void getNodes(List<TreeNode> nodes) {
        if (nodes.size() == 0) return;

        List<Integer> subList = new ArrayList<>();
        List<TreeNode> nextNodes = new ArrayList<>();

        for (TreeNode node : nodes) {
            subList.add(node.val);
            if (node.left != null) nextNodes.add(node.left);
            if (node.right != null) nextNodes.add(node.right);
        }
        list.add(subList);
        this.getNodes(nextNodes);
    }
}
