/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment23;

import java.util.Arrays;

/**
 *
 * @author Muzhi
 */
public class TwoSum {
    public int[] twoSum(int[] array, int sum) {
        if (array == null) return null;
        Arrays.sort(array);
        int left = 0, right = array.length - 1;
        int[] res = {Integer.MIN_VALUE, Integer.MAX_VALUE};
        while (left < right) {
            if (array[left] + array[right] != sum) {
                if (array[left] + array[right] < sum) {
                    ++left;
                } else {
                    --right; 
               }
            } else {
                res[0] = array[left];
                res[1] = array[right];
                return res;
            }
        }
        return res;
        
    }
    
    public static void main(String[] args) {
        int[] array = {1,3,4,5,6,9,8,11,2,-2};
        int sum = 20;
        TwoSum twoSum = new TwoSum();
        int[] res = twoSum.twoSum(array, sum);
        System.out.println(res[0] + " " + res[1]);
        
    }
}
