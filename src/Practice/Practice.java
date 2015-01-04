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
   
    /*******  Array Hopper IV  *******/
    public int minJump(int[] array, int index) {
      if (array == null || array.length == 0)
        return -1;
      if ((array.length == 1 && array[0] == 0))
        return 0;
      boolean[] reach = new boolean[array.length];
      int[] min = new int[array.length];
      for (int i : min) {
        i = Integer.MAX_VALUE;
      }
      if (array[0] != 0)
        reach[0] = true;
      for (int i = 1; i < array.length; ++i) {
        for (int j = 0; j < i; ++j) {
          if (reach[j] && array[j] >= i - j) {
            min[i] = Math.min(min[i], min[j] + 1);
            reach[i] = true;
          }
        }
      }
      if (reach[array.length - 1] == true)
        return min[array.length - 1];
      else
        return -1;
    }
    
    public static void main(String[] args) {
        //int index = 
        int[] array = {};
        Practice p = new Practice();
        int min = p.minJump(array, 0);
        System.out.println(min);
    }
    
}
