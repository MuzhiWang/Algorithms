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
public class PrintList {
    public void PrintList(Node head){
        if(head == null){
            System.out.println("null");
            return;
        }
        
        while(head != null){
            System.out.print(" " + head.value + " ->");
            Node next = head.next;
            head = next;
        }
        System.out.println();
        return;
    }
    
}
