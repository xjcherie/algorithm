package leetcode.tree;

import leetcode.common.TreeNode;
import org.junit.Test;

/**
 * Created by Cherie on 2020/04/20
 * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 **/
public class ConstructBinarySearchTreeFromPreorderTraversal {

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = new TreeNode(preorder[i]);
            TreeNode preNode = root;
            while (true) {
                if (node.val < preNode.val) {
                    if (preNode.left == null) {
                        preNode.left = node;
                        break;
                    }
                    preNode = preNode.left;
                } else {
                    if (preNode.right == null) {
                        preNode.right = node;
                        break;
                    }
                    preNode = preNode.right;
                }
            }
        }
        return root;
    }

    @Test
    public void test() {
        bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12});
    }
}
