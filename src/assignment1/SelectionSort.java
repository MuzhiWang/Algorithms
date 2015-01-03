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
public class SelectionSort {
    public void selectionSort(int[] array) {
        if (array == null) {
            return;
        }
        for (int index = 0; index < array.length - 1; index++) {
            int minIndex = index;
            for (int temIndex = index + 1; temIndex < array.length - 1; temIndex++) {
                if (array[temIndex] < array[minIndex]) {
                    minIndex = temIndex;
                }
            }
            swap(array, index, minIndex);
        }
    }
    
    public void swap(int[] array, int left, int right) {
        int tem = array[left];
        array[left] = array[right];
        array[right] = tem;
    }
    
}
