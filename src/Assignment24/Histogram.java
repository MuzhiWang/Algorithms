/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment24;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

/**
 *
 * @author Muzhi
 */
public class Histogram {
    
    /***** O(n^2) ****/
    public int maxRetangle(int[] histogram) {
        if (histogram == null || histogram.length == 0)
            return -1;
        int index = 0, left, right;
        int maxRet = Integer.MIN_VALUE;
        for (int i = 0; i < histogram.length; ++i) {
            int height = histogram[index];
            left = index;
            right = index;
            while (left >= 0) {
                if (histogram[left] < height) 
                    break;
                left--;
            }
            while (right < histogram.length) {
                if (histogram[right] < height)
                    break;
                right++;
            }
            maxRet = Math.max((right - left - 1) * height, maxRet);
            index++;
        }
        return (maxRet == Integer.MIN_VALUE) ? 0 : maxRet;
    }
    
    /***********  Stack O(n)  *************/
    public int maxRetangle2(int[] histogram) {
        if (histogram == null || histogram.length == 0)
            return -1;
        Deque<Integer> stack = new ArrayDeque<>();
        int maxRet = Integer.MIN_VALUE;
        stack.push(0);
        for (int i = 0; i < histogram.length; ++i) {
            if (!stack.isEmpty()) {
                int tempStackMaxRet = Integer.MIN_VALUE;
                while (!stack.isEmpty() && histogram[i] <= histogram[stack.peek()])
                    stack.pop();
                //Deque<Integer> stackTemp = Collections.copy(stackTemp, stack);
                int tempRet = (stack.isEmpty()) ? 0 : (i - stack.peek()) * histogram[i];
                maxRet = Math.max(maxRet, tempRet);
                stack.push(i);
            }
        }
        return maxRet;
    }
    
    /*********  teacher's solution, I think it should be tested. 
     * I think there is logical problem of the solution ********/
    public int maxRectangleOptimal(int[] array) {
        assert array != null && array.length != 0;
        int maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i <= array.length; ++i) {
            int cur = (i == array.length) ? 0 : array[i];
            while (!stack.isEmpty() && array[stack.peek()] >= cur) {
                int height = array[stack.pop()];
                int left = stack.isEmpty() ? 0 : stack.peek();
                maxArea = Math.max(maxArea, height * (i - left));
            }
            stack.push(i);
        }
        return maxArea;
    }
    
    public static void main(String[] args) {
        Histogram h = new Histogram();
        int[] his = {1, 2, 1, 4, 3, 2};
        int[] his2 = {4, 2, 1, 3, 4, 1, 5};
        System.out.println("O(n^2) solution: " + h.maxRetangle(his2));
        System.out.println("O(n) solution: " + h.maxRetangle2(his2));
        System.out.println("O(n) stack test: " + h.maxRectangleOptimal(his2));
    }
    
}
