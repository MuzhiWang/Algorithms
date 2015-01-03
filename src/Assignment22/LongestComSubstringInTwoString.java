/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment22;

/**
 *
 * @author Muzhi
 */
public class LongestComSubstringInTwoString {
//    public String longComSubstring(String str1, String str2) {
//        assert str1.length() != 0 || str2.length() != 0;
//        int maxLen = 0;
//        for (int i = 0; i < str1.length(); ++i) {
//            for (int j = 0; j < str2.length(); ++i) {
//                if (str1.charAt(i) == str2.charAt(j)) {
//                    while () {
//                        
//                    }
//                }
//            }
//        }
//        
//    }
    String longestSubstring;
    public int longComSubstring(String str1, String str2) {
        assert str1.length() != 0 || str2.length() != 0;
        int[][] dp = new int[str1.length()][str2.length()];
        for (int i = 0; i < str1.length(); ++i) {
            for (int j = 0; j < str2.length(); ++j) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    if ((i > 0 && j > 0) && dp[i - 1][j - 1] > 0) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        int longIndex = 0, longSum = 0;
        for (int i = 0; i < str1.length(); ++i) {
            for (int j = 0; j < str2.length(); ++j) {
                if (longSum < dp[i][j]) {
                    longSum = dp[i][j];
                    longIndex = i;
                }
            }
        }
        this.longestSubstring = str1.substring(longIndex - longSum + 1, longIndex + 1);
        return longSum;
    }
    
    public static void main(String[] args) {
        String str1 = "swidentaj";
        String str2 = "stidentai";
        LongestComSubstringInTwoString longestSubstring = new LongestComSubstringInTwoString();
        System.out.println(longestSubstring.longComSubstring(str1, str2));
        System.out.println(longestSubstring.longestSubstring);
        
    }
}
