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
public class PartitionList {
    Node partitionList(Node head, int target){
        if (head == null){
            return null;
        }
        //Node newHead;
        Node newHeadOne = new Node(0, null);
        Node newHeadTwo = new Node(0, null);
        Node curOne = newHeadOne;
        Node curTwo = newHeadTwo;
        Node point = head;
        while (point != null){
            if (point.value < target){
                curOne.next = point;
                curOne = curOne.next;
            } else {
                curTwo.next = point;
                curTwo = curTwo.next;
            }
            point = point.next;
        }
        curOne.next = newHeadTwo.next;
        return newHeadOne.next;
    }
    
}
