/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Epic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Muzhi
 */

/*	The decimal and octal values of some numbers are both 
 *	palindromes sometimes. Find such numbers within a given 
 *	range.
 *
 */

public class DecimalOctalPalindrome {
    
    public List<Integer> getNumberFromRange(int start, int end) {
        assert start <= end;
        List<Integer> res = new ArrayList<>();
        for (int i = start; i <= end; ++i) {
            if (isPalindrome(getOctal(i)) && isPalindrome(getDecimal(i)))
                res.add(i);
        }
        return res;
    }
    
    private String getOctal(int num) {
        String res = "";
        while (num > 0) {
            int digit = num % 8;
            num /= 8;
            res = digit + res;
        }
        return res;
    }
    
    private String getDecimal(int num) {
        return String.valueOf(num);
    }
    
    private boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right))
                return false;
            else {
                left++;
                right--;
            }
        }
        return true;
    }
    
    public static void main(String... args) {
        DecimalOctalPalindrome dop = new DecimalOctalPalindrome();
        System.out.println(Arrays.toString(dop.getNumberFromRange(1, 10000).toArray()));
        
        int test = 3663;
        System.out.println(dop.getOctal(test) + " -- " + Integer.toOctalString(test));
       
    }
    
}
