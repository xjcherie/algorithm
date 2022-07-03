package leetcode.linkedlist;

import leetcode.common.ListNode;

/**
 * @Author: Cherie
 * @Date: 2022-06-22
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode smallerHead = null, smaller = null;
        ListNode largerHead = null, larger = null;
        while (head != null) {
            if (head.val < x) {
                if (smallerHead == null) {
                    smallerHead = head;
                    smaller = smallerHead;
                } else {
                    smaller.next = head;
                    smaller = smaller.next;
                }
            } else {
                if (largerHead == null) {
                    largerHead = head;
                    larger = largerHead;
                } else {
                    larger.next = head;
                    larger = larger.next;
                }
            }
            head = head.next;
        }
        if (larger != null) {
            larger.next = null;
        }
        if (smaller != null) {
            if (largerHead != null) {
                smaller.next = largerHead;
            }
            return smallerHead;
        }
        return largerHead;
    }
}
