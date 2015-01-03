/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;
import java.util.PriorityQueue;
import java.util.Comparator;
/**
 *
 * @author Muzhi
 */
public class Practice {
    public void PQ(int[] array, int k) {
        if (array == null) return; 
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b.intValue() - a.intValue();
            }
        });
    }
    
    public void PQ2(int[] array, int k) {
        if (array == null) return;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b.intValue() - a.intValue();
            }
        });
        
    }
    
}
