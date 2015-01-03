/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leetcode;

/**
 *
 * @author Muzhi
 */
public class EditDistance {
    
    /*********  Recursion  O(2^n) ***********/
    public int editDistanceRecursion(String s1, String s2) {
        if (s1.isEmpty()) return s2.length();
        if (s2.isEmpty()) return s1.length();
        if (s1.charAt(0) == s2.charAt(0)) {
            return editDistanceRecursion(s1.substring(1), s2.substring(1));
        } else {
            int delete = editDistanceRecursion(s1, s2.substring(1)) + 1;
            int replace = editDistanceRecursion(s1.substring(1), s2.substring(1)) + 1;
            int insert = editDistanceRecursion(s1.substring(1), s2) + 1;
            int min = Math.min(delete, replace);
            min = Math.min(min, insert);
            return min;
        }
    }
    
    /*************  DP solution O(n^2)  *****************/
    public int editDistanceDP(String s1, String s2) {
        if (s1 == null) return s2.length();
        if (s2 == null) return s1.length();
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < s1.length() + 1; ++i) dp[i][0] = i;
        for (int j = 0; j < s2.length() + 1; ++j) dp[0][j] = j;
        for (int i = 1; i < s1.length() + 1; ++i) {
            for (int j = 1; j < s2.length() + 1; ++j) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; 
                } else {
                    int replace = dp[i - 1][j - 1] + 1;
                    int delete = dp[i - 1][j] + 1;
                    int insert = dp[i][j - 1] + 1;
                    int min = Math.min(replace, delete);
                    dp[i][j] = Math.min(min, insert);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
    
    
    
    
    public static void main(String[] args) {
        EditDistance e = new EditDistance();
        String s1 = "abc";
        String s2 = "bdec";
        System.out.println(e.editDistanceRecursion(s1, s2));
        System.out.println(e.editDistanceDP(s1, s2));
    }
    
}
