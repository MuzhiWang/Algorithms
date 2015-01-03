/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment17;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Muzhi
 */
public class ArrayDuplicateNoneLeft {
    
    // Method One by using stack
    public int[] arrayDeplicateNone(int[] array) {
        if (array == null || array.length == 0 || array.length == 1) {
            return array;
        }
        
        LinkedList<Integer> stack = new LinkedList<Integer>();
        stack.push(array[0]);
        int index = 1;
        for (index = 1; index < array.length; ++index) {
            if (array[index] != stack.peek()) {
                stack.push(array[index]);
            } else {
                int indexTwo = index;
                while (indexTwo < array.length && array[indexTwo] == stack.peek()) {
                    indexTwo++;
                }
                stack.pop();
                index = indexTwo - 1;
            }
        }
        
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >=0; --i) {
            result[i] = stack.pop();
        }
        return result;    
    }
    
    //Method Two not use stack.  There is corner case in this method, so still need to be checked.
    public int[] arrayDeplicateNoneMethodTwo(int[] array){
            int fast = 1;
            int slow = 0;
            int flag = 0;
            for (fast = 1; fast < array.length; fast++) {
                if (array[fast] == array[slow]) {
                    flag = 1;
                } else if (flag == 0) {
                    array[++slow] = array[fast];
                } else {
                    array[slow] = array[fast];              // This is the corner case, when the input array is like{1,2,2,3,4,4,4}
                    flag = 0;                               // the last integer will not be remove as reqiurement.
                }
            }
            
        int[] result =new int[slow + 1];
        for (int i = 0; i < slow + 1; ++i) {
            result[i] = array[i];
        }    
        return result;   
    }
    
    public static void main(String[] args) {
        ArrayDuplicateNoneLeft arrayNone = new ArrayDuplicateNoneLeft();
        int[] array3 = {1,2,2,2,3,4,4,5,6,6,6,6};
        System.out.println("None duplicate element of this array: ");
        int[] result3 = arrayNone.arrayDeplicateNone(array3);
        int[] result4 = arrayNone.arrayDeplicateNoneMethodTwo(array3);
        for (int i = 0; i < result3.length; ++i) {
            System.out.print(result3[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < result4.length; ++i) {
            System.out.print(result4[i] + " ");
        }
        System.out.println();
    }
    
}
