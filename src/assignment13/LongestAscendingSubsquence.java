/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment13;

/**
 *
 * @author Muzhi
 */
public class LongestAscendingSubsquence {
    
    public int longestAscSubsquenceTwo(int[] array) {
        assert array != null;
        if (array.length == 0) {
            return 0;
        }
        
        int[] logestNum = new int[array.length];
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            logestNum[i] = 1;
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j] && logestNum[i] <= logestNum[j]) {
                    logestNum[i] = logestNum[j] + 1;
                }
            }
        }
        
        for (int i = 0; i < array.length; i++) {
            result = max(result, logestNum[i]);
        }
        
        return result;
        
        
    }
    
    
    /***************** Correct Method One by use recursion ****************************/
    public int longestAscSubsqen(int[] array) {
        assert array != null;
        if (array.length == 0) {
            return 0;
        }
        
        int[] longestNum = new int[array.length];
        longestAscSubsqenHelper(array, longestNum, 0);
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result = max(result, longestNum[i]);
        }
        return result;
        
    }
    
    private void longestAscSubsqenHelper(int[] array, int[] longestNum, int num) {
        if (num == array.length) {
            return;
        }
        
        longestNum[num] = 1;
        for (int i = 0; i < num; i++) {
            if (array[num] > array[i] && longestNum[num] <= longestNum[i]) {
                longestNum[num] = longestNum[i] + 1;
            }
        }
        
        longestAscSubsqenHelper(array, longestNum, num + 1);
                
    }
    
    private int max(int numOne, int numTwo) {
        if (numOne >= numTwo) {
            return numOne;
        }
        return numTwo;
    }
    
    
    
    /*****************  Wrong answer ***************************************
    public int longestAscSubsquence(int[] array) {
        assert array != null;
        if (array.length == 0) {
            return 0;
        }
        
        int[] sum = new int[array.length];
        sum[0] = 1;
        int result = 0;
        sum = longestSubsquenceHelper(array, sum, 0);
        for (int i = 0; i < array.length - 1; i++) {
           result = max(result, sum[i]);
        }
        return result;
    }
    
    private int[] longestSubsquenceHelper(int[] array, int[] sum, int num) {
        if (num == array.length - 1) {
            return sum; 
        }
        
        for (int i = 0; i < num - 1; i++) {
            if (array[num - 1] > array[i]) {
                sum[num - 1]++;
            } 
        }
        //num++;
        longestSubsquenceHelper(array, sum, num + 1);
        return sum;
    }
    
    private int max(int numOne, int numTwo) {
        if (numOne >= numTwo) {
            return numOne;
        }
        return numTwo;
    }
    */
    
    /****************** Wrong Method......... Method tow ************/
    /*
    public int longestAscSubsquenceTwo(int[] array) {
        assert array != null;
        if (array.length == 0) {
            return 0;
        }
        int result = 0;
        int[] sum = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            sum[i] = 1;
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i]) {
                    sum[i]++;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            result = max(result, sum[i]);
        }
        return result;
    }
    */
    
}
