/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment9;

/**
 *
 * @author Muzhi
 */
public class RemoveDuplicatedLetters {
    public char[] removeDuplicatedLetters(String str) {
        assert str != null;
        
        int indexOne = 0;
        int indexTwo = 0;
        char[] result = new char[str.length()];
        result[0] = str.charAt(0);
        for (indexTwo = 0; indexTwo < str.length(); indexTwo++) {
            if (str.charAt(indexTwo) != result[indexOne]) {
                result[indexOne + 1] = str.charAt(indexTwo);
                indexOne++;
            }
        }
        return result;
    }
    
}
