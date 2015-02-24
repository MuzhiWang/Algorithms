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
public class RainwaterCollection {
    
    /****** This is O(n) solution, the constant is 2 * N, scan twice from left to right & right to left  *******/
    public int rainwater(int[] histogram) {
        assert histogram != null && histogram.length > 3;
        int left = 0, right = 1;
        int sumWater = 0;
        int tempWater = 0;
        
        /// scan from left to right. To add the water while histogram[left] >= histogram[right]
        while (left < histogram.length && right < histogram.length) {
            if (histogram[left] > histogram[right]) {
                tempWater = 0;
                while (right < histogram.length && histogram[right] < histogram[left]) {
                    tempWater += histogram[left] - histogram[right++];
                }
                if (right == histogram.length && histogram[right - 1] < histogram[left]);
                else {
                    sumWater += tempWater;
                }
                left = right;
                right++;
            } else {
                left++;
                right++;
            }
        }
        
        /// sacn from right to left. To add water while histogram[right] > histogram[left], 
        /// ignore histogram[right] == histogram[left]
        right = histogram.length - 1; 
        left = right - 1;
        while (left >= 0) {
            if (histogram[left] < histogram[right]) {
                tempWater = 0;
                while (left >= 0 && histogram[left] < histogram[right]) {
                    tempWater += histogram[right] - histogram[left--];
                }
                /// ignore the situation when histogram[left] == histogram[right] since it has already be calculated in left to right scanning.
                if ((left == -1 && histogram[left + 1] < histogram[right]) || histogram[left] == histogram[right]);
                else {
                    sumWater += tempWater;
                }
                right = left;
                left--;
            } else {
                right--;
                left--;
            }
        }
        
        return sumWater;
    }
    
    
    /*******  This is the optimal solution. O(n) complextity with constant 1 * N ********/
    public int rainwaterOptimal(int[] histogram) {
        assert histogram != null && histogram.length > 3;
        int left = 0;
        int right = histogram.length - 1;
        int leftMax = histogram[0];
        int rightMax = histogram[histogram.length - 1];
        int result = 0;
        
        while (left < right) {
            if (histogram[left] <= histogram[right]) {
                result += Math.max(0, leftMax - histogram[left]);
                leftMax = Math.max(leftMax, histogram[left]);
                left++;
            } else {
                result += Math.max(0, rightMax - histogram[right]);
                rightMax = Math.max(rightMax, histogram[right]);
                right--;
            }
        }
        
        return result;
    }
    
    
    public static void main(String... args) {
        RainwaterCollection r = new RainwaterCollection();
        int[] histogram = {4, 1, 7, 2, 4, 2, 6, 7, 2, 5};
        System.out.println(r.rainwater(histogram));
        System.out.println(r.rainwaterOptimal(histogram));
        
    }
    
}
