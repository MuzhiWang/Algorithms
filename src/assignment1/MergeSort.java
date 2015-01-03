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
public class MergeSort {
    public void mergeSort(int[] array) {
        if (array == null) {
            return;
        }
        int[] helper = new int[array.length];
        mergeSort(array, helper, 0, array.length - 1);
    }
    
    public void copyArray(int[] source, int[] dest, int left, int right) {
        for (int index = left; index <= right; index++) {
            dest[index] = source[index];
        }
    }
    
    private void mergeSort(int[] array, int[] helper, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(array, helper, left, mid);
        mergeSort(array, helper, mid + 1, right);
        merge(array, helper, left, mid, right);
    }
    
    private void merge(int[] array, int[] helper, int left, int mid, int right) {
        copyArray(array, helper, left, right);
        
        int leftIndex = left;
        int rightIndex = mid + 1;
        
        while(leftIndex <= mid && rightIndex <= right) {
            if (helper[leftIndex] <= helper[rightIndex]) {
                array[left++] = helper[leftIndex++];
            } else {
                array[left++] = helper[rightIndex++];
            }
        }
        
        while (leftIndex <= mid) {
            array[left++] = helper[leftIndex++];
        }
    }
    
}
