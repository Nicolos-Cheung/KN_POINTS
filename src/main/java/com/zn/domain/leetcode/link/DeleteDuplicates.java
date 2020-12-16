package com.zn.domain.leetcode.link;

import com.zn.domain.leetcode.bean.ListNode;

/**
 * 删除有序链表中重复元素
 *
 * @author ning
 * @date 2020/11/27
 */
public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {

        ListNode p = head;

        while(p!=null && p.next!=null){

            if(p.val == p.next.val){
                p.next = p.next.next;
            }else{
                p = p.next;
            }
        }
        return head;
    }
}
