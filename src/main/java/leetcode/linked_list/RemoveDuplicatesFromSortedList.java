package leetcode.linked_list;

import leetcode.common.ListNode;

/**
 * Created by Cherie on 2022/04/03
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/submissions/
 **/
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode lastNode = head;
        while (lastNode != null && lastNode.next != null) {
            if (lastNode.val == lastNode.next.val) {
                lastNode.next = lastNode.next.next;
            } else {
                lastNode = lastNode.next;
            }
        }
        return head;
    }
}
