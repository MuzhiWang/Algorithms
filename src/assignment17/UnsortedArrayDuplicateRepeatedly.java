/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment17;

import java.util.LinkedList;

/**
 *
 * @author Muzhi
 */
public class UnsortedArrayDuplicateRepeatedly {
    
    public int[] unsortedArrayDuplicateRepeatedly(int[] array) {
        if (array == null || array.length == 0 || array.length == 1) {
            return array;
        }
        
        LinkedList<Integer> stack = new LinkedList<Integer>();
        int index = 1;
        stack.push(array[0]);
        for (index = 1; index < array.length; ++index) {
            if (stack.isEmpty()) {
                stack.push(array[index]);
            } else if (array[index] != stack.peek()) {
                stack.push(array[index]);
            } else {
                while (index < array.length && array[index] == stack.peek()) {
                    index++;
                }
                stack.pop();
                index--;
            }
        }
        
        int[] result = new int[stack.size()];
        for (int i = 0; i < stack.size(); ++i) {
            result[stack.size() - 1 - i] = stack.pop();
        }
        
        return result;
        
    }
    
}
