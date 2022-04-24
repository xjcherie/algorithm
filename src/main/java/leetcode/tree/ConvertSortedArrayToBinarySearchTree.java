package leetcode.tree;

import leetcode.common.TreeNode;
import org.junit.Test;

/**
 * Created by Cherie on 2022/04/24
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 **/
public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        return this.recursion(nums, 0, nums.length - 1);
    }

    private TreeNode recursion(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int middle = (start + end) / 2;
        TreeNode node = new TreeNode(nums[middle]);
        node.left = this.recursion(nums, start, middle - 1);
        node.right = this.recursion(nums, middle + 1, end);
        return node;
    }

    @Test
    public void test() {
        TreeNode node = sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(node);
    }
}
