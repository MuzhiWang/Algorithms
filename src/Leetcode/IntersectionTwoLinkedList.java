/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leetcode;

/**
 *
 * @author Muzhi
 */
public class IntersectionTwoLinkedList {
    public ListNode intersection(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        //if ((headA.next == null || headB.next == null) && headA != headB) return null;

        ListNode curA = headA;
        ListNode curB = headB;
        int countA = 0, countB = 0;
        while (curA != null) {
            countA++;
            curA = curA.next;
        }
        while (curB != null) {
            countB++;
            curB = curB.next;
        }
        
        curA = headA;
        curB = headB;
        if (countA > countB) {
            for (int i = 0; i < (countA - countB); ++i) {
                curA = curA.next;
            }
        } else {
            for (int i = 0; i < (countB - countA); ++i) {
                curB = curB.next;
            }
        }
        
        while (curA != null) {
            if (curA.val == curB.val) return curA;
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
    
    public static class ListNode {
        ListNode next;
        int val;
        ListNode(int val) {
            this.val = val;
            next = null;
        }
    }
    
    public static void main(String[] args) {
        IntersectionTwoLinkedList inter = new IntersectionTwoLinkedList();
        ListNode headA = new  ListNode(3);
        ListNode headB = new ListNode(2);
        headB.next = new ListNode(3);
        ListNode res = inter.intersection(headA, headB);
        System.out.println(res.val);
        
    }
    
}
