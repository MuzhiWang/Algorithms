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
public class Node {
    public int value;
    public Node next;
    
    Node(int v, Node n){
        this.value = v;
        this.next = n;
        if(n == null){
        return;
        }
    }
}

        
