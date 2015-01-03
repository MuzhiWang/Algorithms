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
public class ReverseStringInSentence {
    public String reverse(String sentence) {
        if (sentence == null || sentence.isEmpty()) return null;
        char[] charStr = sentence.toCharArray();
        int left = 0, right = 1, i = 0;
        while (i < charStr.length) {
            if (i == 0 || (charStr[i] != ' ' && charStr[i - 1] == ' '))
                left = i;
            if (i == charStr.length - 1 || (charStr[i + 1] == ' ')) {
                right = i;
                reverseWord(charStr, left, right);
            }
            ++i;
        }
        reverseWord(charStr, 0, charStr.length - 1);
        return new String(charStr);
    }
    
    private void reverseWord(char[] word, int left, int right) {
        char temp;
        while (left < right) {
            temp = word[left];
            word[left++] = word[right];
            word[right--] = temp;
        }
    }
    
    public static void main(String[] args) {
        String sentence = "Hellow Bloomberg I love yahoo";
        ReverseStringInSentence r = new ReverseStringInSentence();
        String res = r.reverse(sentence);
        System.out.println(res);   
    }
}
