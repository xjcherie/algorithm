package leetcode;

import leetcode.common.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cherie on 2021/03/29
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 **/
public class NAryTreeLevelOrderTraversal {
    private List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return list;

        List<Integer> subList = new ArrayList<>();
        subList.add(root.val);
        list.add(subList);

        this.getNodes(root.children);
        return list;
    }

    private void getNodes(List<Node> nodes) {
        if (nodes.size() == 0) return;

        List<Node> subNodes = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        for (Node node : nodes) {
            subList.add(node.val);
            if (node.children != null) subNodes.addAll(node.children);
        }
        list.add(subList);
        this.getNodes(subNodes);
    }
}
