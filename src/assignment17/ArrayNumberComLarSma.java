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
public class ArrayNumberComLarSma {
    
    public int[] arrayNumberComLarSma(int[] array) {
        if (array == null || array.length == 0 || array.length == 1) {
            return null;
        }
        int[] result = new int[2];
        if (array.length == 2) {
            if (array[0] > array[1]) {
                result[0] = array[0];
                result[1] = array[1];
            } else {
                result[0] = array[1];
                result[1] = array[0];
            }
            return result;
        }
        
        int length = array.length;
        int[] max = new int[length / 2];
        int[] min = new int[length / 2];
        int maxNum = array[0];
        int minNum = array[1];
        
            for (int i = 0; i < length / 2; ++i) {
                if (array[i] > array[length - 1 - i]) {
                    max[i] = array[i];
                    min[i] = array[length - 1 - i];
                } else {
                    max[i] = array[length - 1 - i];
                    min[i] = array[i];
                }
            }
            
            for (int i = 0; i < length / 2; ++i) {
                if (maxNum < max[i]) {
                    maxNum = max[i];
                }
                if (minNum > min[i]) {
                    minNum = min[i];
                }
            }
            
            if (length % 2 != 0) {
                if (maxNum < array[length / 2]) {
                    maxNum = array[length / 2];
                } else if (minNum > array[length / 2] ) {
                    minNum = array[length / 2];
                }
            }
            result[0] = maxNum;
            result[1] = minNum;
            return result;
    }
    
}
