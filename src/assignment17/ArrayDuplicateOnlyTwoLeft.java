/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment17;

/**
 *
 * @author Muzhi
 */
public class ArrayDuplicateOnlyTwoLeft {
    
    public int[] arrayDupicateTwoLeft(int[] array) {
        if (array == null || array.length == 0 || array.length == 1) {
            return array;
        }
        
        int slow = 1;
        int fast = 2;
        for (fast = 2; fast < array.length; ++fast) {
            if (array[slow - 1] != array[fast]) {
                array[++slow] = array[fast];
            }
        }
        
        int[] result = new int[slow + 1];
        for (int i = 0; i < slow + 1; i++) {
            result[i] = array[i];
        }
        return result;
    }
    
}
