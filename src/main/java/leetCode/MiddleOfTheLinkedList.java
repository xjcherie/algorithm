package leetCode;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cherie on 2020/04/08
 **/
public class MiddleOfTheLinkedList {

    public ListNode middleNode(ListNode head) {
        int total = 0;
        ListNode temp = head;
        while (temp.next != null) {
            total++;
            temp = temp.next;
        }
        int half = total / 2 + (total % 2 == 0 ? 0 : 1);
        int count = 0;
        while (count < half) {
            count++;
            head = head.next;
        }
        return head;
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
        assertThat(middleNode(node1), equalTo(node3));
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
