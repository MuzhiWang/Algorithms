/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment24;

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
        
        
        return 0;
    }
    
    
    
    
    
    public static void main(String[] args) {
        Histogram h = new Histogram();
        int[] his = {1, 2, 1, 4, 3, 3};
        System.out.println(h.maxRetangle(his));
    }
    
}
