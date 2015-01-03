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
public class Homework_7 {
    Node reorder(Node head){
        if (head == null){
            return null;
        }
        
        Node pointOne, pointTwo;
        Node newHead = new Node(0, null);
        pointOne = head;
        pointTwo = head;
        while (pointTwo.next != null && pointTwo.next.next != null){
            pointOne = pointOne.next;
            pointTwo = pointTwo.next.next;
        }
        //Node pre = pointOne;
        
        RevLinkedListRecursion reverseFromMid = new RevLinkedListRecursion();
        Node reverseNode = pointOne.next;
        Node newHeadOne, newHeadTwo;
        pointOne.next = null;
        newHeadOne = head;
        newHeadTwo = reverseFromMid.revLinkedListRecursion(reverseNode);
        
        Node point = newHead;
        Node leftOne = newHeadOne;
        Node leftTwo = newHeadTwo;
        while (newHeadTwo != null){
            leftOne = newHeadOne.next;
            leftTwo = newHeadTwo.next;
            newHeadOne.next = null;
            newHeadTwo.next = null;
            newHeadOne.next = point.next;
            point.next = newHeadOne;
            newHeadOne.next = null;
            point = point.next;
            newHeadTwo.next = point.next;
            point.next = newHeadTwo;
            newHeadTwo.next = null;
            point = point.next;
            newHeadTwo = leftTwo;
            newHeadOne = leftOne;
            //newHeadTwo = newHeadTwo.next;
            //newHeadOne = newHeadOne.next;
            
        }
        if (newHeadOne == null){
            return newHead.next;
        } else {
            point.next = newHeadOne;
        }
        return newHead.next;
       
    }
    
    
}
