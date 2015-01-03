/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment23;

/**
 *
 * @author Muzhi
 */
public class ReverseLinkedList {
    
    public static class LinkedListNode{
        LinkedListNode next;
        int value;
//        public LinkedListNode() {
//            //this.next = new LinkedListNode();
//        }
        public LinkedListNode(int value) {
            //this.next = new LinkedListNode();
            this.value = value;
        }
    }
    
    //  Iteration reverse
    public LinkedListNode reverse(LinkedListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedListNode next;
        LinkedListNode cur = head;
        LinkedListNode pre = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    
    // recursion reverse method
    public LinkedListNode recursionReverse(LinkedListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        LinkedListNode newHead = recursionReverse(head.next);
        LinkedListNode next = head.next;
        next.next = head;
        head.next = null;
        return newHead;
    }
    
    void print(LinkedListNode head) {
        assert head != null;
        LinkedListNode cur = head;
        while (cur != null) {
            System.out.print(cur.value + " -> ");
            cur = cur.next;
        }
        System.out.println();
        
    }
    
    public static void main(String[] args) {
        LinkedListNode n1 = new LinkedListNode(1);
        LinkedListNode n2 = new LinkedListNode(2);
        LinkedListNode n3 = new LinkedListNode(3);
        LinkedListNode n4 = new LinkedListNode(4);
        LinkedListNode n5 = new LinkedListNode(5);
        LinkedListNode n6 = new LinkedListNode(6);
        n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = n6; //n6.next = null;
        ReverseLinkedList reverse = new ReverseLinkedList();
        reverse.print(n1);
        LinkedListNode newHead = reverse.reverse(n1);
        reverse.print(newHead);
        reverse.reverse(n6);
        //n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = n6; //n6.next = null;
        reverse.print(n1);
        LinkedListNode newHead2 = reverse.recursionReverse(n1);
        reverse.print(newHead2);
        
    }
}
