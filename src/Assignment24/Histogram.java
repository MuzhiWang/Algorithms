/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment24;

import java.util.ArrayDeque;
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
        stack.push(histogram[0]);
        for (int i = 0; i < histogram.length; ++i) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && histogram[i] < stack.peek())
                    stack.pop();
                int tempRet = (stack.isEmpty()) ? histogram[i] : (histogram[i] - histogram[stack.peek()]) * histogram[i];
                maxRet = Math.max(maxRet, tempRet);
                stack.push(histogram[i]);
            }
        }
        return maxRet;
    }
    
    
    
    
    
    public static void main(String[] args) {
        Histogram h = new Histogram();
        int[] his = {1, 2, 1, 4, 3, 3};
        System.out.println("O(n^2) solution: " + h.maxRetangle(his));
        System.out.println("O(n) solution: " + h.maxRetangle2(his));
        
    }
    
}
