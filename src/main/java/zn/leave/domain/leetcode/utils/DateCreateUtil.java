package zn.leave.domain.leetcode.utils;

import zn.leave.domain.leetcode.bean.ListNode;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/04/18
 */
public class DateCreateUtil {


    public static ListNode getLinkDate(int []arr){

        ListNode head = new ListNode(arr[0]);
        ListNode p = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode next = new ListNode(arr[i]);
            p.next = next;
            p = p.next;
        }
        return head;
    }
}
