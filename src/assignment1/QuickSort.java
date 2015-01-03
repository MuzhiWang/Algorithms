/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;
import java.util.Arrays;

/**
 *
 * @author Muzhi
 */
public class QuickSort {
    public void quickSort(int[] array) {
        if (array == null) {
            return;
        }
        
        
    }
    
    public void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotPos = partition(array, left, right);
        quickSort(array, left, pivotPos - 1);
        quickSort(array, pivotPos + 1, right);
    }
    
    public void swap(int[] array, int left, int right) {
        int tem = array[left];
        array[left] = array[right];
        array[right] = tem;
    }
    
    private int partition(int[] array, int left, int right) {
        int pivotPos = pivotPos(left, right);
        int pivot = array[pivotPos];
        swap(array, pivotPos, right);
        
        int leftBound = left;
        int rightBound = right - 1;
        for (int index = left; index <= right - 1; index++) {
            if (array[index] < pivot) {
                swap(array, leftBound++, index);
            }
        }
        
        swap(array, leftBound, right);
        return leftBound;
    }
    
    private int pivotPos(int left, int right) {
        return left + (int)(Math.random() * (right - left + 1));
    }
    
}
