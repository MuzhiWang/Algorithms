/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leetcode;
//import java.math.*;

/**
 *
 * @author Muzhi
 */
public class PalindromeNumber {
    
    public boolean isPalindrome(long x) {
        if (x > -9 && x < 9) {
            return true;
        }
        x = Math.abs(x);
        //x = (int)(long)x;
        int size = 0;
        long temp = x;
        while (temp > 0) {
            temp = temp / 10;
            size++;
        }
        long y = x;
        for (int i = 1;  i < size; ++i) {
            if (y / (long)Math.pow(10, size - i) != x % 10 ) {
                return false;
            }
            y %= (long)Math.pow(10, size - i);
            x /= 10;
        }
        return true;
    }
    
    public static void main(String[] args) {
        PalindromeNumber palindrome = new PalindromeNumber();
        long num = -2147483648;
        int num2 = -2147483648;
        boolean result = palindrome.isPalindrome(num);
        boolean result2 = palindrome.isPalindrome(num2);
        System.out.println(result);
        System.out.println(result2);
        //int test = (int) Math.pow(10, 8);
        System.out.println(Math.pow(10, 8));
        System.out.println(num2);
        
    }
    
}
