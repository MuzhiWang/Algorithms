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
public class Homework_3 {
    int node_num;
    Node middleNode(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node cur1 = head;
        Node cur2 = head;
        int counter = 1;
        
        while(cur2.next != null){
            if(cur2.next.next == null){
                this.node_num = counter + 1;
                return cur1.next; 
            }
            cur1 = cur1.next;
            cur2 = cur2.next.next;
            counter++;
        }
        this.node_num = counter;
        return cur1;
    }
    

}
