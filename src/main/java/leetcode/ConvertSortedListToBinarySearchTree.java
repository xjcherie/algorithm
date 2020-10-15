package leetcode;

import leetcode.common.ListNode;
import leetcode.common.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cherie on 2020/08/18
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 **/
public class ConvertSortedListToBinarySearchTree {

    private ListNode head;

    private int findSize(ListNode head) {
        ListNode ptr = head;
        int c = 0;
        while (ptr != null) {
            ptr = ptr.next;
            c += 1;
        }
        return c;
    }

    private TreeNode convertListToBST(int l, int r) {
        // Invalid case
        if (l > r) {
            return null;
        }

        int mid = (l + r) / 2;

        // First step of simulated inorder traversal. Recursively form
        // the left half
        TreeNode left = this.convertListToBST(l, mid - 1);

        // Once left half is traversed, process the current node
        TreeNode node = new TreeNode(this.head.val);
        node.left = left;

        // Maintain the invariance mentioned in the algorithm
        this.head = this.head.next;

        // Recurse on the right hand side and form BST out of them
        node.right = this.convertListToBST(mid + 1, r);
        return node;
    }

    public TreeNode sortedListToBST(ListNode head) {
        // Get the size of the linked list first
        int size = this.findSize(head);

        this.head = head;

        // Form the BST now that we know the size
        return convertListToBST(0, size - 1);
    }


    private List<Integer> list = new ArrayList<>();

    public TreeNode sortedListToBST1(ListNode head) {
        if (head == null) {
            return null;
        }

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        return fillTreeNode(0, list.size() - 1);
    }

    private TreeNode fillTreeNode(int left, int right) {
        if (left > right) {
            return null;
        }
        int middle = (int) Math.ceil(((double) left + (double) right) / 2);
        TreeNode root = new TreeNode(list.get(middle));
        root.left = fillTreeNode(left, middle - 1);
        root.right = fillTreeNode(middle + 1, right);
        return root;
    }

    @Test
    public void test() {
        ListNode node1 = new ListNode(-10);
        ListNode node2 = new ListNode(-3);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(9);
//        ListNode node6 = new ListNode(4);
//        ListNode node7 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
//        node5.next = node6;
//        node6.next = node7;

        TreeNode tree = sortedListToBST(node1);
        System.out.println(tree);
    }

}
