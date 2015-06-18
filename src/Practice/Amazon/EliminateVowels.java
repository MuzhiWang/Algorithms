/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Amazon;

/**
 *
 * @author Muzhi
 */
public class EliminateVowels {
    
    public String noVowels(String str) {
        StringBuilder res = new StringBuilder();
        int fast = 0, slow = 0;
        while (fast < str.length()) {
            if (str.charAt(fast) == 'a' || str.charAt(fast) == 'e' || str.charAt(fast) == 'i' || str.charAt(fast) == 'o'
                    || str.charAt(fast) == 'u');    
            else {
                res.append(str.charAt(fast));
            }
            fast++;
        }
        return res.toString();
    }
    
    public String noVowels2(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String vowels = "AEIOUaeiou";
        for (int i = 0; i < str.length(); ++i) {
            char cur = str.charAt(i);
            if (vowels.indexOf(cur) == -1) 
                sb.append(cur);
        }
        return sb.toString();
    }
    
    public String noVowels3(String str) {
        if (str == null)
            return null;
        return str.replaceAll("[AEIOUaeiou]", "");
    }
    
    private int myIndexOf(String str, String sub) {
        if (str == null || sub == null || str.length() == 0 || sub.length() == 0)
            return -1;
        int strLen = str.length();
        int subLen = sub.length();
        if (strLen < subLen)
            return -1;
        for (int i = 0; i < strLen - subLen + 1; ++i) {
            if (str.charAt(i) == sub.charAt(0)) {
                int j = i;
                for (j = i; j < i + subLen; ++j) {
                    if (str.charAt(j) != sub.charAt(j - i))
                        break;
                }
                if (j == i + subLen && str.charAt(j - 1) == sub.charAt(j - i - 1))
                    return i;
            }
        }
        return -1;
    }
    
    public static void main(String... args) {
        String str = "abcde";
        EliminateVowels e = new EliminateVowels();
        System.out.println(e.noVowels(str));
        System.out.println(e.noVowels2(str));
        System.out.println(e.noVowels3(str));
        System.out.println(e.myIndexOf(str, "bc"));
        str.contains(" ");
    }
    
}
