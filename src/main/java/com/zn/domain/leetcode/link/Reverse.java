package com.zn.domain.leetcode.link;

import com.zn.domain.leetcode.bean.ListNode;
import com.zn.domain.leetcode.utils.DateCreateUtil;

/**
 * 反转链表
 *
 * @author ning
 * @date 2020/05/15
 */
public class Reverse {


    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};
        ListNode linkDate = DateCreateUtil.getLinkDate(arr);

        ListNode listNode = reverseList(linkDate);
        System.out.println();
    }

    public static ListNode reverseList(ListNode head) {

        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 递归
     *
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {

        return null;

    }
}
