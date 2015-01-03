/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment17;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Muzhi
 */
public class ArrayCompareTopTwoLargestNum {

    public int[] arrayComTopTwoLarNum(int[] array) {
        assert array != null || array.length != 0 || array.length != 1;     // I found the assert never works when there is empty imput array.
        if (array.length == 2) {                                            // how could i use "assert" ?
            return array;
        }
        
        //int[][] data = new int[array.length][];
        List<List<Integer>> compElement = new ArrayList<List<Integer>>();
        for (int i = 0; i < array.length; ++i) {
            List<Integer> elementList = new LinkedList<Integer>();
            elementList.add(array[i]);
            compElement.add(i, elementList);
        }
        
        comTopTwoLarNumHelper(array, compElement, array.length);
        
        int[] result = new int[2];
        result[0] = compElement.get(0).get(0);
        result[1] = compElement.get(0).get(1);
        for (int i = 1; i < compElement.get(0).size(); ++i) {
            if (result[1] < compElement.get(0).get(i)) {
                result[1] = compElement.get(0).get(i);
            }
        }
        return result;
        
    }

    private void comTopTwoLarNumHelper(int[] array, List<List<Integer>> compElement, int length) {
        if (length == 1) {
            return;
        }
        for (int i = 0; i < length / 2; ++i) {
            if (compElement.get(i).get(0) > compElement.get(length - 1 - i).get(0)) {
                compElement.get(i).add(compElement.get(length - 1 - i).get(0));
                compElement.remove(length - 1 - i);
            } else {
                compElement.get(length - 1 - i).add(compElement.get(i).get(0));
                compElement.remove(i);
            }
        }
        
        if (length % 2 == 1) {
            if (compElement.get(length / 2).get(0) > compElement.get(0).get(0)) {
                compElement.get(length / 2).add(compElement.get(0).get(0));
                compElement.remove(0);
            } else {
                compElement.get(0).add(compElement.get(length / 2).get(0));
                compElement.remove(length / 2);
            }
        }
        
        int newLength = compElement.size();
        comTopTwoLarNumHelper(array, compElement, newLength);
        
    }
    
    public static void main(String[] args) {
        ArrayCompareTopTwoLargestNum topTwoLarNum = new ArrayCompareTopTwoLargestNum();
        int[] array6 = {2,3,9,7,5,6,1,8,4,11};
        int[] result7 = topTwoLarNum.arrayComTopTwoLarNum(array6);
        System.out.println("The top two largest num of array is: ");
        System.out.print("Largest number is: " + result7[0] + "   ");
        System.out.println("Second largest number is: " + result7[1]);
    }
    
}
