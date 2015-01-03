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
public class ReplaceSubstringWithString {
    /**********  Still need to think about how to get the least space complexity, how to modify the array in original one  ***********/
    public String replaceSubstr(String str, String s1, String s2) {
        assert str.length() != 0;
        int len1 = s1.length();
        int len2 = s2.length();
        char[] charStr;
        int index = 0;
        int counter = 0;
        for (int i = 0; i < str.length() - s1.length() + 1; ++i) {
            if (str.charAt(i) == s1.charAt(0) && isS1(str, s1, i)) ++counter; 
        }
        charStr = new char[str.length() + counter * (len2 - len1)];
        
        for (int i = 0; i < str.length(); ++i) {
            if ((i < str.length() - s1.length() + 1) && str.charAt(i) == s1.charAt(0) && isS1(str, s1, i)) {
                for (int j = 0; j < s2.length(); ++j) {
                    charStr[index++] = s2.charAt(j);
                }
                i += s1.length() - 1;
            } else {
                charStr[index++] = str.charAt(i);
            }
        }
       return new String(charStr);
    }
    
    private boolean isS1(String str, String s1, int start) {
        if (start > str.length() - s1.length() + 1) {
            return false;
        }
        for (int i = 0; i < s1.length(); ++i) {
            if (str.charAt(start + i) != s1.charAt(i)) return false;
        }
        return true;
    } 
    
    public static void main(String[] args) {
        String str = "abcabaabb";
        String s1 = "ab";
        String s2 = "TTT";
        ReplaceSubstringWithString replace = new ReplaceSubstringWithString();
        System.out.println(replace.replaceSubstr(str, s1, s2));
        
    }
    
}
