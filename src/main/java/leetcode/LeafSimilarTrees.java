package leetcode;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cherie on 2021/03/29
 * https://leetcode.com/problems/leaf-similar-trees/
 **/
public class LeafSimilarTrees {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>(), list2 = new ArrayList<>();
        this.getLeaf(root1, list1);
        this.getLeaf(root2, list2);
        return list1.equals(list2);
    }

    private void getLeaf(TreeNode node, List<Integer> list) {
        if (node == null) return;
        if (node.left == null && node.right == null) list.add(node.val);
        this.getLeaf(node.left, list);
        this.getLeaf(node.right, list);
    }

}
