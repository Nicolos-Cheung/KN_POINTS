package zn.leave.domain.leetcode.link;

import zn.leave.domain.leetcode.bean.ListNode;

/**
 * 环形链表
 *
 * tag 链表
 * @author ning
 * @date 2020/04/15
 */
public class Cycle {

    public boolean hasCycle(ListNode head) {

        if(head ==null || head.next == null){
            return false;
        }

        ListNode faster = head.next;
        ListNode latter = head;

        while (latter != null && faster != null && faster.next != null && latter != faster){
            faster =  faster.next.next;
            latter = latter.next;
        }

        if(latter == faster){
            return true;
        }
        return false;

    }
}
