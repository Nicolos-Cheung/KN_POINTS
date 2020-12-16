package com.zn.domain.leetcode.link;

import com.zn.domain.leetcode.bean.ListNode;
import com.zn.domain.leetcode.utils.DateCreateUtil;

import java.util.Objects;
import java.util.Stack;

/**
 * 回文链表
 * <p>
 * tag 链表
 *
 * @author ning
 * @date 2020/04/18
 */
public class Palindrome {

    public static void main(String[] args) {

        int[] arr = {1, 0, 1};

        ListNode linkDate = DateCreateUtil.getLinkDate(arr);

        boolean palindrome = isPalindrome(linkDate);

        System.out.println(palindrome);
    }

    /**
     * 空间复杂度O(n)
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {

        Stack stack = new Stack();

        if (head.next == null) {
            return true;
        }

        ListNode p = head;
        while (p != null) {
            stack.push(p.val);
            p = p.next;
        }

        p = head;

        while (!stack.empty()) {
            if (!Objects.equals(p.val, stack.pop())) {
                return false;
            }
            p = p.next;
        }
        return true;


    }


    /**
     * 空间复杂度O(1) 时间复杂度O(n)
     * <p>
     * 找到中心点，中心点后半部分反转
     * 1 -2 - 2- 1
     * <p>
     * 1 -2 - 1- 2
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome2(ListNode head) {

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        ListNode p = head;

        reverse(slow);

        while (slow != null) {
            if (p.val != slow.val) {
                return false;
            }
            slow = slow.next;
            p = p.next;
        }

        return true;

    }


    private static void reverse(ListNode head) {

        // null  1 -> 2 -> 3
        // pre
        ListNode pre = null;
        while (head != null) {

            //  null <-  1 -> 2 -> 3
            //   pre   head
            ListNode next = head.next;
            head.next = pre;


            //  null <- 1 -> 2 -> 3
            //         pre  head
            pre = head;
            head = next;
        }
    }


}
