package leetcode.linkedlist;

import leetcode.common.ListNode;
import org.junit.Test;

import static common.GenerateParams.genLinkedList;

/**
 * Created by Cherie on 2022/04/28
 * https://leetcode.com/problems/rotate-list/
 **/
public class RotateList {

    private Integer newK;

    private ListNode tail;

    private ListNode newHead;

    public ListNode rotateRight(ListNode head, int k) {
        try {
            this.reverse(head, k, 1);
        } catch (Exception ignored) {

        }
        if (tail != null) {
            tail.next = head;
        }
        return newHead == null ? head : newHead;
    }

    private int reverse(ListNode node, int k, int total) {
        if (node.next == null) {
            if (k >= total) {
                newK = k % total;
            } else {
                newK = k;
            }
            if (newK == 0) {
                throw new RuntimeException();
            }
            if (newK == 1) {
                newHead = node;
            }
            tail = node;
            return 1;
        }
        total++;
        int count = this.reverse(node.next, k, total) + 1;
        if (count == newK) {
            newHead = node;
        } else if (count == newK + 1) {
            node.next = null;
            throw new RuntimeException();
        }
        return count;
    }

    @Test
    public void test() {
        ListNode node = genLinkedList(new int[]{0, 1, 2});
        rotateRight(node, 4);
    }

}
