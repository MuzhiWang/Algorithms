/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.util.Arrays;
import java.util.Iterator;

/**
 *
 * @author Muzhi
 */
public class MergeSort {
    public int[] mergeSort(int[] array) {
        if (array == null || array.length == 0)
            return null;
        int[] res = divider(array, 0, array.length - 1); 
        array = res;
        return res;
    }
    
    private int[] divider(int[] array, int left, int right) {
        if (left > right)
            return null;
        if (left == right)
            return new int[] {array[left]} ;
        int mid = left + (right - left) / 2;
        int[] leftArray = divider(array, left, mid);
        int[] rightArray = divider(array, mid + 1, right);
        return merge(leftArray, rightArray);
    }
    
    private int[] merge(int[] leftArray, int[] rightArray) {
        int indexL = 0, indexR = 0, indexRes = 0;
        int[] res = new int[leftArray.length + rightArray.length];
        while (indexL < leftArray.length && indexR < rightArray.length) {
            if (leftArray[indexL] < rightArray[indexR])
                res[indexRes++] = leftArray[indexL++];
            else 
                res[indexRes++] = rightArray[indexR++];
        }
        while (indexL < leftArray.length) 
            res[indexRes++] = leftArray[indexL++];
        while (indexR < rightArray.length)
            res[indexRes++] = rightArray[indexR++];
        return res;
    }
    
    public static void main(String[] args) {
        MergeSort m = new MergeSort();
        int[] array = {2,1,3,6,5};
        int[] res = m.mergeSort(array);
        Iterator it;
        //array = res;
        System.out.println(Arrays.toString(res));
        System.out.println(Arrays.toString(array));
        
    }
    
}
