package leetcode.linked_list;

import leetcode.common.ListNode;

/**
 * Created by Cherie on 2020/08/17
 * https://leetcode.com/problems/remove-linked-list-elements/
 **/
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode root = null, tail = null;
        while (head != null) {
            if (head.val != val) {
                if (root == null) {
                    root = head;
                } else if (tail == null) {
                    tail = head;
                    root.next = tail;
                } else {
                    tail.next = head;
                    tail = tail.next;
                }
            }
            head = head.next;
        }

        if (tail != null) {
            tail.next = null;
        } else if (root != null) {
            root.next = null;
        }
        return root;
    }
}
