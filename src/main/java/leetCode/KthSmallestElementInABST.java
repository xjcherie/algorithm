package leetCode;

import leetCode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cherie on 2020/05/20
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 **/
public class KthSmallestElementInABST {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = this.inorder(root, new ArrayList<>());
        return list.get(k - 1);
    }

    private List<Integer> inorder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return list;
        }
        this.inorder(node.left, list);
        list.add(node.val);
        this.inorder(node.right, list);
        return list;
    }

}
