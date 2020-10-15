package leetcode.linked_list;

import leetcode.common.ListNode;
import org.junit.Test;

/**
 * Created by Cherie on 2020/08/13
 * https://leetcode.com/problems/reverse-linked-list-ii/
 **/
public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }

        ListNode cur = head, prev = null;
        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }

        ListNode con = prev, tail = cur;

        ListNode third;
        while (n > 0) {
            third = cur.next;

            /**
             * todo
             */
            cur.next = prev;
            prev = cur;

            cur = third;
            n--;
        }

        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }

        tail.next = cur;
        return head;
    }

    public ListNode reverseBetween1(ListNode head, int m, int n) {
        if (head == null || n == 1) {
            return head;
        }

        int i = 1;
        ListNode first = null;
        ListNode node = null;

        ListNode reverseFirst = null;
        ListNode reverseLast = null;
        ListNode tempNode;

        while (head != null && i <= n) {
            tempNode = new ListNode(head.val);
            if (i >= m) {
                if (reverseFirst == null) {
                    reverseLast = tempNode;
                    reverseFirst = tempNode;
                } else {
                    tempNode.next = reverseFirst;
                    reverseFirst = tempNode;
                }
            } else {
                if (first == null) {
                    first = tempNode;
                    node = tempNode;
                } else {
                    node.next = tempNode;
                    node = node.next;
                }
            }
            head = head.next;
            i++;
        }
        if (reverseFirst != null) {
            reverseLast.next = head;
        }
        if (node == null) {
            first = reverseFirst;
        } else {
            node.next = reverseFirst;
        }

        return first;
    }

    @Test
    public void test() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        reverseBetween(node1, 2, 4);
    }
}
