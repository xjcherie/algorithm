package leetcode;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cherie on 2021/03/19
 * https://leetcode.com/problems/minimum-distance-between-bst-nodes/
 **/
public class MinimumDistanceBetweenBSTNodes {

    private List<Integer> list = new ArrayList<>();

    public int minDiffInBST(TreeNode root) {
        this.traverseTree(root);

//        int minDiff = Math.abs(list.get(0) - list.get(1));
//        for (int i = 1; i < list.size() - 1; i++) {
//            minDiff = Math.min(minDiff, Math.min(Math.abs(list.get(i) - list.get(i - 1)), Math.abs(list.get(i) - list.get(i + 1))));
//        }
//        minDiff = Math.min(minDiff, Math.abs(list.get(list.size() - 1) - list.get(list.size() - 2)));

        Integer[] array = list.toArray(new Integer[0]);
        int minDiff = Math.abs(array[0] - array[1]);
        int length = array.length;
        for (int i = 1; i < length - 1; i++) {
            minDiff = Math.min(minDiff, Math.min(Math.abs(array[i] - array[i - 1]), Math.abs(array[i] - array[i + 1])));
        }
        minDiff = Math.min(minDiff, Math.abs(array[length - 1] - array[length - 2]));

        return minDiff;
    }

    private void traverseTree(TreeNode node) {
        if (node == null) return;
        this.traverseTree(node.left);
        list.add(node.val);
        this.traverseTree(node.right);
    }

}
