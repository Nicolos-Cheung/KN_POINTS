package com.zn.domain.leetcode.link;

import com.zn.domain.leetcode.bean.ListNode;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/12/01
 */
public class IntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 4，1，8，4，5，5，0，1，8，4，5
        // 5，0，1，8，4，5，4，1，8，4，5

        ListNode p1 = headA;
        ListNode p2 = headB;
        int flag = 0;
        while(p1!=p2){
            if(flag>2){
                return null;
            }
            if(p1==headA){
                flag ++;
            }
            p1 = p1 != null? p1.next:headB;
            p2 = p2 != null? p2.next:headA;
        }
        return p1;


    }



}
