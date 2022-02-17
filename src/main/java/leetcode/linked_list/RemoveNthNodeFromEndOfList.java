package leetcode.linked_list;

import leetcode.common.ListNode;

/**
 * Created by Cherie on 2022/02/17
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 **/
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null && n == 1) return null;
        if (this.recursionNode(head, n) == n) {
            return head.next;
        }
        return head;
    }

    private int recursionNode(ListNode node, int n) {
        if (node.next == null) {
            return 1;
        }
        int count = recursionNode(node.next, n);
        if (count == n) {
            node.next = node.next.next;
        }
        return count + 1;
    }
}

