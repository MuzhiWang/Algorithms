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
public class StringReverse {
    /*******  str = hellow yahoo; output = wolleh oohay  *******/
    public String strReverse(String str) {
        char[] strChar = str.toCharArray();
        int left = 0, right = 0;
        for (int i = 0; i < strChar.length; ++i) {
            if (i == 0 || (strChar[i] != ' ' && strChar[i - 1] == ' ')) 
                left = i;
            if ((strChar[i] == ' ' && strChar[i - 1] != ' '))
                wordReverse(strChar, left, i - 1);
            if (i == strChar.length - 1)
                wordReverse(strChar, left, i);
        }
        return new String(strChar);
    }
    
    /*********  str = hellow yahoo!; output = yahoo hellow! It is wrong with problem **********/
    public String strReverseWithSymbol(String str) {
        char[] strChar = str.toCharArray();
        int left = 0;
        int index = 0;
        while (index < str.length()) {
            if (strChar[index] == '!') {
                wordReverse(strChar, left, index - 1);
                left = index + 1;
            }
            ++index;
        }
        left = 0;
        for (int i = 0; i < strChar.length; ++i) {
            if (i == 0 || (strChar[i] != ' ' && strChar[i - 1] == ' '))
                left = i;
            if (strChar[i] == ' ' && strChar[i - 1] != ' ' || (strChar[i] == '!' && strChar[i - 1] != ' '))
                wordReverse(strChar, left, i - 1);
            if (i == strChar.length - 1 && strChar[i] != '!')
                wordReverse(strChar, left, i);
        }
        return new String(strChar);
    }
    
    /*******  str = hellow yahoo; output = yahoo hellow  *********/
    public String strReverse2(String str) {
        char[] strChar = str.toCharArray();
        int left = 0;
        wordReverse(strChar, 0, strChar.length - 1);
        return strReverse(new String(strChar));
    }
    
    private void wordReverse(char[] strChar, int left, int right) {
        while (left < right) {
            char cur = strChar[left];
            strChar[left] = strChar[right];
            strChar[right] = cur;
            ++left;
            --right;
        }
    }
    
    public static void main(String[] args) {
        StringReverse sr = new StringReverse();
        String str = "Hellow Yahoo";
        String str1 = "Hellow Yahoo! I am coming!";
        System.out.println(sr.strReverse(str));
        System.out.println(sr.strReverse2(str));
        System.out.println(sr.strReverseWithSymbol(str1));
    } 
    
}
