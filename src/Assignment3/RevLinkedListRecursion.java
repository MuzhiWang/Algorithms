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
public class RevLinkedListRecursion {
    Node revLinkedListRecursion(Node R){
        if(R == null || R.next == null){
            return R;
        }
        
        Node next = R.next;
        Node newhead = revLinkedListRecursion(next);
        next.next = R;
        R.next = null;
        return newhead;
 
    }
    
}
