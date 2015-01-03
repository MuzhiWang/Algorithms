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
public class Assignment_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Node N6 = null;
        Node N5 = new Node(11, N6);
        Node N4 = new Node(7, N5);
        Node N3 = new Node(4, N4);
        Node N2 = new Node(2, N3);
        Node N1 = new Node(1, N2);

        RevLinkedListIterative L = new RevLinkedListIterative();
        RevLinkedListRecursion R = new RevLinkedListRecursion();
        
        PrintList P = new PrintList();
        System.out.println("the original LinkedList is ");
        P.PrintList(N1);
        System.out.println("Q1: the iteration reverse LinkedList is ");
        P.PrintList(L.revLinedListIterative(N1));
        System.out.println("Q2: the recursion reverse LinkedList is ");
        P.PrintList(R.revLinkedListRecursion(N5));
        
        Homework_3 H3 = new Homework_3();
        System.out.println("Q3: the middle node of LinkedList N1 is " + H3.middleNode(N1).value);
        System.out.println("    the index the the middle node is " + H3.node_num);
        
        Homework_4 H4 = new Homework_4();
        //N5.next = N2;                                    //test if N5 -> N2 whether it is circular
        System.out.println("Q4: whether the LinkedList is circular or not: " + H4.ifCircular(N1));
        
        Homework_5 H5 = new Homework_5();
        Node insert = new Node(16, null);
        System.out.println("Q5: the LinkedList after inserting a node: ");
        P.PrintList(H5.insertNode(N1, insert));
        
        Node M6 = null;
        Node M5 = new Node(17, M6);
        Node M4 = new Node(13, M5);
        Node M3 = new Node(9, M4);
        Node M2 = new Node(5, M3);
        Node M1 = new Node(3, M2);
        Homework_6 H6 = new Homework_6();
        System.out.println("Q6: merged N1 & M1 LinkedLists: ");
        //System.out.println("Sorry I got some big problem with the code..");
        P.PrintList(H6.mergeTwoLL(N1, M1));
        //P.PrintList(H6.merge(N1, M1));
        
        Homework_7 H7 = new Homework_7();
        System.out.println("Q7: mid-reversed merged LinkedList: ");
        P.PrintList(H7.reorder(N1));
        
        Node L6 = null;
        Node L5 = new Node(9, L6);
        Node L4 = new Node(14, L5);
        Node L3 = new Node(6, L4);
        Node L2 = new Node(11, L3);
        Node L1 = new Node(4, L2);
        PartitionList H8 = new PartitionList();
        System.out.println("Q8: the partition list is ");
        P.PrintList(H8.partitionList(L1, 7));
        
        
        
    }
    
}
