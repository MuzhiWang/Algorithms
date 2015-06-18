/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment25;

import java.util.Arrays;

/**
 *
 * @author Muzhi
 */
public class FindTheKthSmallestEleInTwoArray {
    
    public int findTheKthSmallestEleInTwoArray(int[] arrayOne, int[] arrayTwo, int k) {
        if (arrayOne.length == 0 || arrayTwo.length == 0) {
            if (arrayOne.length != 0) {
                if (arrayOne.length >= k) {
                    return arrayOne[k - 1];
                } else {
                    System.out.println("Input Error, the input arrays' length less than k");
                    return Integer.MIN_VALUE;
                }
            } else if (arrayTwo.length >= k) {
                return arrayTwo[k - 1];
            } else {
                System.out.println("Input error, the input arrays' length less than k");
                return Integer.MIN_VALUE;
            }
        } else if (arrayOne.length + arrayTwo.length < k) {
            System.out.println("Input error, the input arrays' length less than k");
            return Integer.MIN_VALUE;
        }
        
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        
        int indexOne = 0, indexTwo = 0, count = 0;
        int res = Integer.MIN_VALUE;
        while (indexOne < arrayOne.length && indexTwo < arrayTwo.length) {
            if (count < k) {
                if (arrayOne[indexOne] < arrayTwo[indexTwo]) {
                    res = arrayOne[indexOne];
                    indexOne++;
                } else {
                    res = arrayTwo[indexTwo];
                    indexTwo++;
                }
                count++;
            } else 
                return res;
        }
        
        if (count == k)
            return res;
        
        if (indexOne < arrayOne.length) {
            return arrayOne[indexOne + (k - count) - 1];
        } else 
            return arrayTwo[indexTwo + (k - count) - 1];
    }
    
    public static void main(String... args) {
        FindTheKthSmallestEleInTwoArray f = new FindTheKthSmallestEleInTwoArray();
        int[] arrayOne = {1,3,7,9,12,18};
        int[] arrayTwo = {2,4,6};
        int res = f.findTheKthSmallestEleInTwoArray(arrayOne, arrayTwo, 5);
        System.out.println(res);
    }
}
