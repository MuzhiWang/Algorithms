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
public class LinkedListReverseInPair {
    public static class LinkedListNode{
        LinkedListNode next;
        int value;
        
        public LinkedListNode(int value, LinkedListNode next) {
            this.next = next;
            this.value = value;
        }
    }
    
    public LinkedListNode recursionRev(LinkedListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        LinkedListNode next = head.next;
        head.next = recursionRev(next.next);
        next.next = head;
        return next;
        
    }
    
    /****** The iteration method still has problem, please fix it. *************/
    public LinkedListNode reverseInPair(LinkedListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        LinkedListNode temp = new LinkedListNode(0, null);
        LinkedListNode cur = head;
        LinkedListNode next;
        LinkedListNode nextNext;
        LinkedListNode newHead;
        
        next = cur.next;
        nextNext = next.next;
        cur.next = null;
        next.next = cur;
        temp.next = next;
        newHead = temp.next;
        LinkedListNode newHead2;
        newHead2 = newHead;
        temp = cur;
        cur = nextNext; 
        while (cur != null && cur.next != null) {
//            next = cur.next;
//            nextNext = next.next;
//            cur.next = null;
//            next.next = cur;
//            temp.next = next;
//            newHead = temp.next;
//            temp = cur;
//            cur = nextNext;
            next = cur.next;
            next.next = cur;
            cur.next = null;
            
        }
        return newHead2;
        
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
        LinkedListNode n7 = new LinkedListNode(7, null);
        LinkedListNode n6 = new LinkedListNode(6, n7);
        LinkedListNode n5 = new LinkedListNode(5, n6);
        LinkedListNode n4 = new LinkedListNode(4, n5);
        LinkedListNode n3 = new LinkedListNode(3, n4);
        LinkedListNode n2 = new LinkedListNode(2, n3);
        LinkedListNode n1 = new LinkedListNode(1, n2);
        
        LinkedListReverseInPair reversePair = new LinkedListReverseInPair();
        reversePair.print(n1);
        LinkedListNode result2 = reversePair.recursionRev(n1);
        reversePair.print(result2);
        LinkedListNode result = reversePair.reverseInPair(n1);
        reversePair.print(result);
        
    }
    
}
