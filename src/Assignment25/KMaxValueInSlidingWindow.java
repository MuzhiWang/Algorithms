/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment25;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * @author Muzhi
 */
public class KMaxValueInSlidingWindow {
    
    static class Pair {
        int index;
        int val;
        Pair(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }
    
    public void maxVal(int[] array, int K) {
        assert array != null && array.length > K && K > 0;
        Deque<Pair> deque = new LinkedList<>();
        for (int i = 0; i < array.length; ++i) {
            Pair p = new Pair(i, array[i]);
            if (deque.isEmpty()) 
                deque.addFirst(p);
            else if (deque.getFirst().val < array[i]) {
                deque.pollFirst();
                deque.addFirst(p);
            } else if (deque.getLast().val < array[i]) {
                while (deque.getLast().val < array[i]) {
                    deque.pollLast();
                }
                deque.addLast(p);
            } else if (deque.getLast().val > array[i])
                deque.addLast(p);
            if (i - deque.getFirst().index >= K)
                deque.pollFirst();
            System.out.println("Current max value in K window is: " + deque.peek().val);
        }
    } 
    
    // Optimal solution. Do not store val in Pair in Deque, just store index in Deque.
    public void maxVal2(int[] array, int K) {
        assert array != null && array.length > K && K > 0;
        Deque<Integer> deque = new LinkedList<>();
        
        for (int i = 0; i < array.length; ++i) {
            if (deque.isEmpty())
                deque.addFirst(i);
            else if (array[deque.getFirst()] < array[i]) {
                deque.pollFirst();
                deque.addFirst(i);
            } else if (array[deque.getLast()] < array[i]) {
                while (array[deque.getLast()] < array[i]) {
                    deque.pollLast();
                }
                deque.addLast(i);
            } else if (array[deque.getLast()] > array[i])
                deque.addLast(i);
            if (i - deque.getFirst() >= K)
                deque.pollFirst();
            System.out.println(array[deque.getFirst()]);
        }
    }
    
    
    public static void main(String... args) {
        int[] array = {2, 1, 3, 5, 4, 6, 9, 8, 2, 1, 1};
        KMaxValueInSlidingWindow k = new KMaxValueInSlidingWindow();
        int K = 2;
        k.maxVal(array, K);
        System.out.println();
        k.maxVal2(array, K);
    }
    
}
