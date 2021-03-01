package leetcode.amber2021;

import leetcode.common.ListNode;
import org.junit.Test;

/**
 * Created by Cherie on 2021/02/28
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 **/
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode ans = head.next;
        ListNode last = head;
        ListNode next = ans.next;
        ans.next = last;
        last.next = null;

        while (next != null && next.next != null) {
            ListNode first = next;
            ListNode second = next.next;
            ListNode temp = second.next;

            last.next = second;
            second.next = first;

            last = first;
            last.next = null;
            next = temp;
        }
        if (next != null) {
            last.next = next;
        }
        return ans;
    }

    @Test
    public void test() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        swapPairs(node1);
    }

}
