package leetcode.linkedlist;

import leetcode.common.ListNode;
import org.junit.Test;

/**
 * Created by Cherie on 2018/7/15.
 * 两个数相加
 * https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1 = l1, node2 = l2, resultNode = null, nextNode = null;
        int extraNum = 0, val;
        while (node1 != null || node2 != null) {
            val = (node1 == null ? 0 : node1.val) + (node2 == null ? 0 : node2.val) + extraNum;
            extraNum = val / 10;
            ListNode node = new ListNode(val % 10);
            if (resultNode != null) {
                nextNode.next = node;
            } else {
                resultNode = node;
            }
            nextNode = node;
            node1 = node1 == null ? null : node1.next;
            node2 = node2 == null ? null : node2.next;
        }
        if (extraNum > 0) {
            nextNode.next = new ListNode(extraNum);
        }
        return resultNode;
    }

    private ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        int extraNum = 0, sum;
        ListNode resultNode = null, nextNode = null, node1 = l1, node2 = l2;
        while (node1 != null || node2 != null) {
            sum = (node1 != null ? node1.val : 0) + (node2 != null ? node2.val : 0) + extraNum;
            if (sum >= 10) {
                sum -= 10;
                extraNum = 1;
            } else {
                extraNum = 0;
            }
            if (resultNode == null) {
                resultNode = new ListNode(sum);
                nextNode = resultNode;
            } else {
                ListNode newNode = new ListNode(sum);
                nextNode.next = newNode;
                nextNode = newNode;
            }
            node1 = node1 != null ? node1.next : null;
            node2 = node2 != null ? node2.next : null;
        }

        if (extraNum == 1) {
            nextNode.next = new ListNode(1);
        }
        return resultNode;
    }

    @Test
    public void test() {
        ListNode l11 = new ListNode(8);
        ListNode l12 = new ListNode(9);
        ListNode l13 = new ListNode(9);
        l11.next = l12;
        l12.next = l13;

        ListNode l21 = new ListNode(2);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);
        l21.next = l22;
        l22.next = l23;

        System.out.println(addTwoNumbers(l11, l21));
    }


}
