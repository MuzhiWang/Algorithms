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
public class Homework_5 {
    Node head;
    Node insert;
    
    Node insertNode(Node head, Node insert){
        this.head = head;
        this.insert = insert;
        
        if(head == null){
            return insert;
        }
        
        Node cur = head;
        Node pre = null;
        if(cur.value >= insert.value){
            insert.next = cur;
            return insert;
        }
        while(cur.value < insert.value){
            if(cur.next == null){
                cur.next = insert;
                insert.next = null;
                return head;
            }
            pre = cur;
            cur = cur.next;
        }
        pre.next = insert;
        insert.next = cur;
        return head;
        
    }
    
}
