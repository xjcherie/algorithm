package leetcode.amber2021.march;

import leetcode.common.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2021/03/19
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 **/
public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<List<TreeNode>> allNodes = this.initTreeNodes(root);

        List<List<Integer>> ans = new ArrayList<>();
        boolean flag = true;
        for (List<TreeNode> nodes : allNodes) {
            List<Integer> subAns = new ArrayList<>();
            if (flag) {
                nodes.forEach(node -> subAns.add(node.val));
            } else {
                // todo
//                nodes.stream().sorted(Collections.reverseOrder()).forEach(node -> subAns.add(node.val));
                for (int size = nodes.size() - 1; size >= 0; size--) {
                    subAns.add(nodes.get(size).val);
                }
            }
            ans.add(subAns);
            flag = !flag;
        }
        return ans;
    }

    private List<List<TreeNode>> initTreeNodes(TreeNode root) {
        List<List<TreeNode>> allNodes = new ArrayList<>();
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        allNodes.add(nodes);

        while (nodes.size() > 0) {
            List<TreeNode> nextNodes = new ArrayList<>();
            nodes.forEach(node -> {
                if (node.left != null) nextNodes.add(node.left);
                if (node.right != null) nextNodes.add(node.right);
            });
            if (nextNodes.size() > 0) {
                allNodes.add(nextNodes);
            }
            nodes = nextNodes;
        }
        return allNodes;
    }

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        List<List<Integer>> list = new ArrayList<>();
        {
            List<Integer> subList = new ArrayList<>();
            subList.add(3);
            list.add(subList);
        }
        {
            List<Integer> subList = new ArrayList<>();
            subList.add(20);
            subList.add(9);
            list.add(subList);
        }
        {
            List<Integer> subList = new ArrayList<>();
            subList.add(15);
            subList.add(7);
            list.add(subList);
        }
        assertThat(zigzagLevelOrder(node1), equalTo(list));
    }

}
