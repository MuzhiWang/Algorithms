/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

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
    
    public static void main(String... args) {
        String str = "abcde";
        EliminateVowels e = new EliminateVowels();
        System.out.println(e.noVowels(str));
        
    }
    
}
