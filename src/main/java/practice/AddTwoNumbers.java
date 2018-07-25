package practice;

/**
 * create by cherie on 2018/7/15.
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class AddTwoNumbers {

    static class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode node11 = new ListNode(9);
        ListNode node12 = new ListNode(9);
        ListNode node13 = new ListNode(9);
        ListNode node14 = new ListNode(9);
        ListNode node15 = new ListNode(9);
        ListNode node16 = new ListNode(9);
        ListNode node17 = new ListNode(9);
        ListNode node18 = new ListNode(9);
        ListNode node19 = new ListNode(9);
        node11.next = node12;
        node12.next = node13;
        node13.next = node14;
        node14.next = node15;
        node15.next = node16;
        node16.next = node17;
        node17.next = node18;
        node18.next = node19;

        ListNode node21 = new ListNode(9);
        ListNode node22 = new ListNode(9);
        ListNode node23 = new ListNode(9);
        ListNode node24 = new ListNode(9);
        ListNode node25 = new ListNode(9);
        ListNode node26 = new ListNode(9);
        ListNode node27 = new ListNode(9);
        ListNode node28 = new ListNode(9);
        ListNode node29 = new ListNode(9);
        node21.next = node22;
        node22.next = node23;
        node23.next = node24;
        node24.next = node25;
        node25.next = node26;
        node26.next = node27;
        node27.next = node28;
        node28.next = node29;

        addTwoNumbers(node11, node21);
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

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

}
