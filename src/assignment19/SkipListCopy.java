/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment19;

import java.util.HashMap;

/**
 *
 * @author Muzhi
 */
public class SkipListCopy {
    
    public static class SkipListNode{
        SkipListNode next;
        SkipListNode forward;
        int value;
        
        SkipListNode(int value) {
            this.value = value;
        }
        
        SkipListNode(SkipListNode next, SkipListNode forward, int value) {
            this.next = next;
            this.forward = forward;
            this.value = value;
        }
    }
    
    public SkipListNode skipListCopy(SkipListNode head) {
        assert head != null;
        
        SkipListNode cur = head;
        SkipListNode newHead = new SkipListNode(0);
        SkipListNode Next = newHead; 
        HashMap<SkipListNode, SkipListNode> hashMap = new HashMap<SkipListNode, SkipListNode>();
        //newHead.next = cur;
        while (cur != null) {
            SkipListNode temp = new SkipListNode(cur.value);
            hashMap.put(cur, temp);
            Next.next = temp;
            Next = temp;
            //temp.next = Next;         // this sentence could not be added. There is no need. Think about it.
            cur = cur.next;
        }
        
        cur = head;
        Next = newHead.next;
        while (cur != null) {
            if (cur.forward != null) {
                Next.forward = hashMap.get(cur.forward);
            }
            cur = cur.next;
            Next = Next.next;
        }
        
        return newHead;
    }
    
        public void PrintList(SkipListNode head){
            if(head == null){
                System.out.println("null");
                return;
            }
            
            SkipListNode cur = head;
            System.out.print("The next linkedList is: ");
            while(cur != null){
                System.out.print(" " + cur.value + " ->");
                SkipListNode next = cur.next;
                cur = next;
            }
            System.out.println();
            
            System.out.println("The forward LinkedList are: ");
            cur = head;
            while (cur != null) {
                if (cur.forward != null) {
                    System.out.println(" " + cur.value + " -> " + cur.forward.value);
                }
                cur = cur.next;
            }
            
            return;
        }
    
    public static void main(String[] args) {
        SkipListCopy copy = new SkipListCopy();
        
        SkipListNode n6 = new SkipListNode(6);
        SkipListNode n5 = new SkipListNode(n6, null, 5);
        SkipListNode n4 = new SkipListNode(n5, null, 4);
        SkipListNode n3 = new SkipListNode(n4, n6, 3);
        SkipListNode n2 = new SkipListNode(n3, n5, 2);
        SkipListNode n1 = new SkipListNode(n2, n3, 1);
        
        SkipListNode newHead = copy.skipListCopy(n1);
        copy.PrintList(newHead.next);
    }
    
}
