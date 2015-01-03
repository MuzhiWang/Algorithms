/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author Muzhi
 */
public class KWayMerge {
    public int[] merge(List<int[]> arrays) {
        int ways = arrays.size();
        List<List<element>> kWay = new ArrayList<List<element>>();
        for (int i = 0; i < ways; ++i) {
            List<element> oneWay = new ArrayList<element>();
            for (int j = 0; j < arrays.get(i).length; ++j) {
                element newElement = new element(arrays.get(i)[j], i, j);
                oneWay.add(newElement);
            }
            kWay.add(i, oneWay);
        }
        
        PriorityQueue<element> minHeap = new PriorityQueue<element>(ways, new myComparator());
        for (int i = 0; i < ways; ++i) {
            minHeap.add(kWay.get(i).get(0));
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        while (!minHeap.isEmpty()) {
            element pop = minHeap.poll();
            result.add(pop.value);
            if (pop.index != kWay.get(pop.position).size() - 1) {
                minHeap.add(kWay.get(pop.position).get(pop.index + 1));
            }
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); ++i) {
            res[i] = result.get(i);
        }
        return res;
        
    }
    
    private class myComparator implements Comparator<element> {
        @Override
        public int compare (element one, element two) {
            return one.value - two.value;
        }
    }
    
    public static class element {
        int value, position, index;
        element(int value, int pos, int index) {
            this.value = value;
            this.position = pos;
            this.index = index;
        }
    }
    
    public static void main(String[] args) {
        KWayMerge kWayMerge = new KWayMerge();
        List<int[]> arrays = new ArrayList<int[]>();
        int[] array1 = {1,4,9,11,13,18};
        int[] array2 = {2,5,10,16,22,27};
        int[] array3 = {3,7,15,19,31};
        arrays.add(array1);
        arrays.add(array2);
        arrays.add(array3);
        int[] res = kWayMerge.merge(arrays);
        System.out.println(Arrays.toString(res));
    }
    
}
