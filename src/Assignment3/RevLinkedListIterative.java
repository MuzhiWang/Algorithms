/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3;
import java.util.LinkedList;

/**
 *
 * @author Muzhi
 */
public class RevLinkedListIterative {
    public Node revLinedListIterative(Node L){
        if(L == null){                          // if the input node is null, return null   
            return null;
        }
        
        Node cur = L;
        Node pre = null;
        while(cur != null){                     // linkedlist iteration
            Node next = cur.next;
            /*pre = cur;                        // false solution             
            cur = next;
            cur.next = pre;
            */
            cur.next = pre;                     //right solution
            pre = cur;
            cur = next;
        }
        return pre;
    }

}


