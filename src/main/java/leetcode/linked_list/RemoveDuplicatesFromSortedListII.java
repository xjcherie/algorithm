package leetcode.linked_list;

import leetcode.common.ListNode;
import org.junit.Test;

/**
 * Created by Cherie on 2020/08/14
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 **/
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode root = null, tail = null, pre = head, cur = head.next;
        int preNum = head.val;

        while (cur != null) {
            if (preNum == cur.val) {
                pre = null;
            } else {
                if (pre != null) {
                    if (root == null || tail == null) {
                        if (root == null) {
                            root = pre;
                        } else {
                            tail = pre;
                            root.next = tail;
                        }
                    } else {
                        tail.next = pre;
                        tail = pre;
                    }
                }
                pre = cur;
            }
            preNum = cur.val;
            cur = cur.next;
        }

        if (pre != null) {
            pre.next = null;
            if (root == null) {
                root = pre;
            } else if (tail == null) {
                tail = pre;
                root.next = pre;
            } else {
                tail.next = pre;
                tail = pre;
            }
        }
        if (tail != null) {
            tail.next = null;
        }
        if (root != null && tail == null) {
            root.next = null;
        }

        return root;
    }

    @Test
    public void test() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
//        ListNode node5 = new ListNode(4);
//        ListNode node6 = new ListNode(4);
//        ListNode node7 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
//        node6.next = node7;

        deleteDuplicates(node1);
    }
}
