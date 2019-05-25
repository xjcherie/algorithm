package leetcode;

/**
 * Created by Cherie on 2019/5/10.
 * 两个数相加
 * https://leetcode.com/problems/add-two-numbers/
 */
public class L3_AddTwoNumbers {

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int extraNum = 0;
        int sum;

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

    public static void main(String[] args) {
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

    static class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
