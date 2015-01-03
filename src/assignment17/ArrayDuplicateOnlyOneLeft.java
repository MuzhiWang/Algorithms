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
public class ArrayDuplicateOnlyOneLeft {
    
    public int[] arrayDuplicateOneLeft(int[] array) {
        if (array == null || array.length == 0 || array.length == 1) {
            return array;
        }
        
        int fast = 1;
        int slow = 0;
        
        for (fast = 1; fast < array.length; ++fast) {
            if (array[fast] != array[slow]) {
                array[++slow] = array[fast];
            }
        }
        int[] result = new int[slow + 1];
        for (int i = 0; i < slow + 1; ++i) {
            result[i] = array[i];
        }
        return result;
    }
    
}
