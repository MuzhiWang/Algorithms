/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment22;

import java.util.Arrays;

/**
 *
 * @author Muzhi
 */
public class StringDecompression {
    public String strDecompress(char[] str) {
        assert str.length != 0;
        int counter = 0;
        for (int i = 1; i < str.length;) {
            counter += ((str[i] - '0') > 1) ? str[i] - '0' : 2;
            i += 2;
        }
        char[] newStr;
        newStr = (counter > str.length) ? new char[counter] : str;
        for (int i = 1, index = 0; i < str.length;) {
            if (str[i] - '0' > 1) {
                for (int j = 0; j < str[i] - '0'; ++j) {
                    newStr[index++] = str[i - 1];
                }
            } else {
                newStr[index++] = str[i - 1];
                newStr[index++] = str[i];
            }
            i += 2;
        }
        int slow = 0, len = 0;
        for (int i = 0; i < counter;) {
            if (newStr[i] - '0' == 0) {
                ++i;
                slow--;
                len--;
            } else if (newStr[i] - '0' == 1) {
                ++i;
            } else {
                newStr[slow++] = newStr[i++];
                ++len;
            }
        }
        return new String(Arrays.copyOf(newStr, len));
    }
    
    public static void main(String[] args) {
        String str = "a3b4e0f1g0c1d1";
        char[] strChar = str.toCharArray();
        StringDecompression strDecom = new StringDecompression();
        System.out.println(strDecom.strDecompress(strChar));
        
    } 
    
}
