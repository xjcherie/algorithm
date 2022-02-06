package leetcode.list;

import leetcode.common.ListNode;
import org.junit.Test;

/**
 * Created by Cherie on 2022/02/06
 * https://leetcode.com/problems/merge-two-sorted-lists/
 **/
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode root;
        if (list1.val <= list2.val) {
            root = new ListNode(list1.val);
            list1 = list1.next;
        } else {
            root = new ListNode(list2.val);
            list2 = list2.next;
        }
        ListNode nextNode = root;
        while (list1 != null && list2 != null) {
            ListNode node;
            if (list1.val <= list2.val) {
                node = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                node = new ListNode(list2.val);
                list2 = list2.next;
            }
            nextNode.next = node;
            nextNode = nextNode.next;
        }
        if (list1 != null) {
            nextNode.next = list1;
        }
        if (list2 != null) {
            nextNode.next = list2;
        }

        return root;
    }

    @Test
    public void test() {
        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(2);
        ListNode node13 = new ListNode(4);
        node11.next = node12;
        node12.next = node13;

        ListNode node21 = new ListNode(1);
        ListNode node22 = new ListNode(3);
        ListNode node23 = new ListNode(4);
        node21.next = node22;
        node22.next = node23;
        mergeTwoLists(node11, node21);
    }

}
