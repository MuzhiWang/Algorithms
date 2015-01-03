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
public class LongestComSubsquenceInTwoString {
    int subsquenceLen = 0;
    public String longestSubsquence(String str1, String str2) {
        assert str1.length() != 0 || str2.length() != 0;
        int[][] dp = new int[str1.length()][str2.length()];
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str1.length(); ++i) {
            for (int j = 0; j < str2.length(); ++j) {
                if ((i > 0 && j > 0) && str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else if (i > 0 && j > 0) {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                } else if ((i == 0 || j == 0) && str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1]; 
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        this.subsquenceLen = dp[str1.length() - 1][str2.length() - 1];
        return res.toString();
    }
    
    public static void main(String[] args) {
        String str1 = "abcdefgabcdefg";
        String str2 = "acbedgfdcabgef";
        LongestComSubsquenceInTwoString longest = new LongestComSubsquenceInTwoString();
        System.out.println(longest.longestSubsquence(str1, str2));
        System.out.println(longest.subsquenceLen);
        
    }
    
}
