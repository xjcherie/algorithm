package leetcode.linkedlist;

import leetcode.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Cherie
 * @Date: 2022-07-03
 * https://leetcode.com/problems/linked-list-cycle/
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
