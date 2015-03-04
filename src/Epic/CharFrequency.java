/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Epic;

/**
 *
 * @author Muzhi
 */

/*	given a string, count the occurance of each letter and output
 *	them by alphabeta order.
 *
 */

public class CharFrequency {
    
    /// assume that the input only contain low-case letter. 
    /// also we do not count the sigh letter like "?" "!"
    public void charFreq(String str) {
        assert str != null && str.length() > 0;
        int[] charFreq = new int[26];
        for (int i = 0; i < str.length(); ++i) {
            int index = str.charAt(i) - 'a';
            if (index < 26 && index >= 0)
                charFreq[index]++;
        }
        
        for (int i = 0; i < 26; ++i) {
            if (charFreq[i] != 0) {
                char cur = (char)('a' + i);
                System.out.println(cur + " 's counts is: " + charFreq[i]);
            }
        }
    }
    
    public static void main(String... args) {
        CharFrequency chQ = new CharFrequency();
        chQ.charFreq("what is the hell? hellow epic, i am coming!");
        
    }
}
