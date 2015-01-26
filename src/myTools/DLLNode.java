/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myTools;

/**
 *
 * @author Muzhi
 */
public class DLLNode {
    public int val;
    public DLLNode pre, next;
    public DLLNode(int val) {
        this.val = val;
        pre = null;
        next = null;
    }
    
    public DLLNode example1() {
        DLLNode head = new DLLNode(1);
        DLLNode two = new DLLNode(2);
        DLLNode three = new DLLNode(3);
        DLLNode four = new DLLNode(4);
        DLLNode five = new DLLNode(5);
        head.next = two;
        two.pre = head;
        two.next = three;
        three.pre = two;
        four.next = five;
        five.pre = four;
        
        return head;
    }
    
    public DLLNode example2() {
        DLLNode head = new DLLNode(1);
        DLLNode two = new DLLNode(2);
        DLLNode three = new DLLNode(3);
        DLLNode four = new DLLNode(4);
        DLLNode five = new DLLNode(5);
        head.next = two;
        two.pre = head;
        two.next = three;
        three.pre = two;
        four.next = five;
        five.pre = four;
        //five.next = head;
        head.pre = five;
        
        return head;
    }
    
}
