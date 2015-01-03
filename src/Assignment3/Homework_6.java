/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3;

/**
 *
 * @author Muzhi
 */
public class Homework_6 {
    
    Node mergeTwoLL(Node head1, Node head2){
        
        Node newHead = new Node(0, null);
        Node cur = newHead;
        if (head1 == null || head2 == null){
            if (head1 == null){
                return head2;
            } else{
                return head1;
            }
        }
        
        while (head1 != null && head2 != null){
            if (head1.value < head2.value){
                cur.next = head1;
                head1 = head1.next;
            } else{
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        if(head1 == null){
            cur = head2;
        } else{
            cur = head1;
        }
        return newHead.next;
    }
    
}
