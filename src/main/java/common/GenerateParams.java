package common;

import leetcode.common.ListNode;

/**
 * Created by Cherie on 2021/09/13
 **/
public class GenerateParams {

    public static Integer[][] generateMatrix() {
        return null;
    }

    public static ListNode genLinkedList(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        ListNode head = new ListNode(array[0]);
        ListNode tmp = head;
        for (int i = 1; i < array.length; i++) {
            ListNode newNode = new ListNode(array[i]);
            tmp.next = newNode;
            tmp = newNode;
        }
        return head;
    }
}
