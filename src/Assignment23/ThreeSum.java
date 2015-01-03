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
public class ThreeSum {
    public int[] threeSum(int[] array, int sum) {
        if (array == null) return null;
        int left = 1, right = array.length - 1, fixed = 0, twoSum;
        int[] res = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE};
        Arrays.sort(array);
        for (fixed = 0; fixed < array.length - 2; ++fixed) {
            twoSum = sum - array[fixed];
            left = fixed + 1;
            right = array.length - 1;
            while (left < right) {
                if (array[left] + array[right] < twoSum) {
                    ++left;
                } else if (array[left] + array[right] > twoSum) {
                    --right;
                } else {
                    res[0] = array[fixed];
                    res[1] = array[left];
                    res[2] = array[right];
                    return res;
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] array = {-3,-1,1,2,4,6,7,8,10,12,17,20};
        int sum = 37;
        ThreeSum three = new ThreeSum();
        int[] res = three.threeSum(array, sum);
        System.out.println(res[0] + " " + res[1] + " " + res[2]);
        
    }
    
}
