/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5;
import java.util.*;

/**
 *
 * @author Muzhi
 */
public class FirstKElements {
    
    public int[] firstKElements(int[] unsorted) {
        int[] intHeap = new int[7];
        //String[] result = new String[7];
        if (unsorted.length < 7) {
            return unsorted;
        }
        /*
        for (int i = 0; i < 7; i++) {
            intHeap[i] = unsorted[i];
        }
        */
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(7, new MyComparator());
        for (int i = 0; i < 7; i++) {
            heap.add(unsorted[i]);
        }
        for (int i = 7; i < unsorted.length; i++) {
            if (unsorted[i] < heap.peek()) {
                heap.poll();
                heap.add(unsorted[i]);
            }
        }
        for (int i = 0; i < 7; i++) {
            intHeap[i] = heap.poll();
        }
        return intHeap;
    }
    
    public class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer one, Integer two) {
            return two - one;
        }
    }
    
}
