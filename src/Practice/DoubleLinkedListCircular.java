/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;
import myTools.DLLNode;
/**
 *
 * @author Muzhi
 */
public class DoubleLinkedListCircular {
    
    public boolean ifCircular(DLLNode head) {
        if (head == null) 
            return false;
        DLLNode fast = head, slow = head;
        //DLLNode cur = head;
        boolean pre = false;
        boolean next = false;
        while (fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
        fast = head;
        slow = head;
        while (fast.pre != null) {
            if (fast == slow)
                return true;
            fast = fast.pre.pre;
            slow = slow.pre;
        }
        return false;
    }
    
    public static void main(String[] args) {
        DoubleLinkedListCircular dll = new DoubleLinkedListCircular();
        DLLNode head = new DLLNode(1).example2();
        boolean res = dll.ifCircular(head);
        System.out.println(res);
    }
}
