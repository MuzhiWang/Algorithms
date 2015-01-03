/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Muzhi
 */
public class KthSmallestInMatrix {
    /*
    public static class Entry {
        int xIndex;
        int yIndex;
        int value;
        
        public Entry(int xIndex, int yIndex, int value) {
            this.xIndex = xIndex;
            this.yIndex = yIndex;
            this.value = value;
        }
        
        @Override
        public int hashCode() {
            return xIndex * 101 + yIndex;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof Entry)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            Entry another = (Entry)obj;
            return this.xIndex == another.xIndex && this.yIndex == another.yIndex;
        }
                
    }
    
    public int kth(final int[][] matrix, int k) {
        sanityCheck(matrix, k);
        int len = matrix.length;
        PriorityQueue<Entry> minHeap = new PriorityQueue<Entry>(k,
        new Comparator<Entry>() {
            @Override
            public int compare(Entry arg1, Entry arg2) {
                return matrix[arg1.xIndex][arg1.yIndex] - matrix[arg2.xIndex][arg2.yIndex];
            }
        });
        
        HashSet<Entry> visited = new HashSet<Entry>();
        
        int result = Integer.MIN_VALUE;
        Entry start = new Entry(0, 0, matrix[0][0]);
        minHeap.offer(start);
        visited.add(start);
        while (k > 0) {
            Entry current = minHeap.poll();
            result = current.value;
            
            if (current.xIndex + 1 < len) {
                Entry right = new Entry(current.xIndex + 1, current.yIndex, matrix[current.xIndex + 1][current.yIndex]);
                if (!visited.contains(right)) {
                    minHeap.offer(right);
                    visited.add(right);
                }
            }
            if (current.yIndex + 1 < len) {
                Entry down = new Entry(current.xIndex, current.yIndex + 1, matrix[current.xIndex][current.yIndex + 1]);
                if (!visited.contains(down)) {
                    minHeap.offer(down);
                    visited.add(down);
                }
            }
            k--;
            
        }
        return result;
        
    }
    
    private void sanityCheck(int[][] matrix, int k) {
        assert matrix != null && matrix.length > 0;
        int len = matrix.length;
        assert k >= 1 && k <= len * len;
        for (int index = 0; index < len; index++) {
            assert matrix[index] != null && matrix[index].length == len;
        }
    }
    */
    
    public static class Entry {
        int xIndex, yIndex, value;
        public Entry(int xIndex, int yIndex, int value){
            this.xIndex = xIndex;
            this.yIndex = yIndex;
            this.value = value;
        }
        @Override
        public int hashCode() {
            return xIndex * 101 + yIndex;
        }
        @Override
        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof Entry)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            Entry another = (Entry)obj;
            return another.xIndex == this.xIndex && another.yIndex == this.yIndex;
        }
    }

    public int[] kthSmallestInMatrix(int[][] matrix, int k) {
        int[] returnResult = new int[k];
        if (k > matrix.length * matrix.length) {
            int resultIndex = 0;
            int [] returnOriginal = new int[matrix.length * matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    returnOriginal[resultIndex] = matrix[i][j];
                    resultIndex++;
                }
            }
            return returnOriginal;
        }
        PriorityQueue<Entry> minHeap = new PriorityQueue<Entry>(k, new myComparator());
        Entry first = new Entry(0, 0, matrix[0][0]);
        List<Entry> result = new ArrayList<Entry>();
        HashSet<Entry> hashSet = new HashSet<Entry>();
        minHeap.offer(first);
        hashSet.add(first);
        int index = 0;
        int length = matrix.length;
        int size = k;
        while (k > 0) {
            result.add(minHeap.poll());
            int xIndex = result.get(index).xIndex;
            int yIndex = result.get(index).yIndex;
            if (result.get(index).xIndex < length - 1) {
                Entry right = new Entry(xIndex + 1, yIndex, matrix[xIndex + 1][yIndex]);
                if (!hashSet.contains(right)) {
                    minHeap.add(right);
                    hashSet.add(right);
                }
            }
            if (result.get(index).yIndex < length - 1) {
                Entry left = new Entry(xIndex, yIndex + 1, matrix[xIndex][yIndex + 1]);
                if (!hashSet.contains(left)) {
                    minHeap.add(left);
                    hashSet.add(left);                    
                }    

            }
            index++;
            k--;
        }
        for (int i = 0; i < size; i++) {
            returnResult[i] = result.get(i).value;
        }
        return returnResult;
    }
    
    public class myComparator implements Comparator<Entry> {
        @Override
        public int compare(Entry one, Entry two) {
            return one.value - two.value;
        }
    }
    
    
}

