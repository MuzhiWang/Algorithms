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
public class Homework_4 {
    boolean ifCircular(Node head){
        if(head == null || head.next == null){
            return false;
        }
        
        Node cur1, cur2;
        cur1 = head;
        cur2 = head;
        while(cur2 != null && cur2.next != null){
            cur2 = cur2.next.next;
            cur1 = cur1.next;
            if(cur2 == cur1){
                return true;
            }
            
        }
        return false;
    }
    
}
