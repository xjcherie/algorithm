package leetcode.tree;

import leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Cherie
 * @Date: 2022-08-04
 * <a href="https://leetcode.com/problems/unique-binary-search-trees-ii/">95. Unique Binary Search Trees II</a>
 */
public class UniqueBinarySearchTreesII {

    public List<TreeNode> generateTrees(int n) {
        return this.genTrees(1, n);
    }

    private List<TreeNode> genTrees(int start, int end) {
        List<TreeNode> list = new LinkedList<>();
        if (start > end) {
            list.add(null);
            return list;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = this.genTrees(start, i - 1);
            List<TreeNode> rightTrees = this.genTrees(i + 1, end);
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode tree = new TreeNode(i);
                    tree.left = leftTree;
                    tree.right = rightTree;
                    list.add(tree);
                }
            }
        }
        return list;
    }
}
