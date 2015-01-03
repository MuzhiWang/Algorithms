/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment19;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author Muzhi
 */
public class KWayLinkedListMerge {
    /*******  There are still some corner case in this method, such as List<> = null, one of the List = null  *******/
    
    public static class ListNode {
        int value;
        ListNode next;
        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }
    }
    
    public ListNode merge(List<ListNode> kWay) {
        int ways = kWay.size();
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(ways, new myComparator());
        for (int i = 0; i < ways; ++i) {
            minHeap.add(kWay.get(i));
        }
        ListNode newHead = new ListNode(0, null);
        ListNode head = newHead;
        while (minHeap != null && !minHeap.isEmpty()) {
            newHead.next = minHeap.poll();
            if (newHead.next.next != null) {
                minHeap.add(newHead.next.next);
            }
            newHead = newHead.next;
        }
        return head.next;
    }
    
    private class myComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode one, ListNode two) {
            return one.value - two.value;
        } 
    }
    
    private void print(ListNode head) {
        while (head != null) {
            System.out.print(head.value + " -> ");
            head = head.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        ListNode node15 = new ListNode(11, null);
        ListNode node14 = new ListNode(8, node15);
        ListNode node13 = new ListNode(5, node14);
        ListNode node12 = new ListNode(3, node13);
        ListNode node11 = new ListNode(1, node12);
        
        ListNode node25 = new ListNode(15, null);
        ListNode node24 = new ListNode(10, node25);
        ListNode node23 = new ListNode(9, node24);
        ListNode node22 = new ListNode(6, node23);
        ListNode node21 = new ListNode(2, node22);
        
        ListNode node35 = new ListNode(22, null);
        ListNode node34 = new ListNode(18, node35);
        ListNode node33 = new ListNode(14, node34);
        ListNode node32 = new ListNode(7, node33);
        ListNode node31 = new ListNode(4, node32);
        
        List<ListNode> kWay = new ArrayList<ListNode>();
        kWay.add(node11);
        kWay.add(node21);
        kWay.add(node31);
        KWayLinkedListMerge kWayMerge = new KWayLinkedListMerge();
        kWayMerge.print(node11);
        kWayMerge.print(node21);
        kWayMerge.print(node31);
        kWayMerge.print(kWayMerge.merge(kWay));
        
    }
    
}
