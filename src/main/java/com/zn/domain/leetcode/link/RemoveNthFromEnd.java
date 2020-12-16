package com.zn.domain.leetcode.link;

import com.zn.domain.leetcode.bean.ListNode;

/**
 * 删除链表倒数第n个元素
 *
 * @author ning
 * @date 2020/12/07
 */
public class RemoveNthFromEnd {

    //双指针，快指针先先走n步
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int step = n;
        ListNode slow = head, fast = head;

        ListNode pre = null;

        while (n > 0) {
            fast = fast.next;
            n--;
        }
        while (fast != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next;
        }

        //删除slow指向的元素；
        if (pre != null) {
            pre.next = slow.next;
        } else {
            head = head.next;
        }

        return head;
    }
}
