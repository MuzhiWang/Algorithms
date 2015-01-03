/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.util.HashMap;

/**
 *
 * @author Muzhi
 */
public class RainbowSort {
    public void rainbowSort(int[] array) {
        if (array == null) {
            return;
        }
        int left = 0;
        int right = array.length - 1;
        int boundOne = left;
        while (boundOne <= right) {
            if (array[boundOne] == 1) {
                boundOne++;
            } else if (array[boundOne] == 0) {
                swap(array, left++, boundOne++);
            } else {
                swap(array, boundOne, right--);
            }
        }
    }
    
    public void swap(int[] array, int left, int right) {
        int tem = array[left];
        array[left] = array[right];
        array[right] = tem;
        //HashMap<Integer, String> hash = new HashMap<Integer, String>();
        //hash.put(1, "aaa");
        //hash
    }
    
}
