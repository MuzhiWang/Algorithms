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

/* every char+3*/

public class ConvertToNewString {
    public String getNewString(String str) {
        assert str != null && str.length() > 0;
        char[] strChar = str.toCharArray();
        for (int i = 0; i < str.length(); ++i) {
            if ((strChar[i] - 'a' >= 0 && 'z' - strChar[i] >= 0)) {
                int index = (strChar[i] + 3) > 'z' ? (strChar[i] + 3 - 26) : (strChar[i] + 3); 
                strChar[i] = (char)index;
            }
            if ((strChar[i] - 'A' >= 0 && 'Z' - strChar[i] >= 0)) {
                int index = (strChar[i] + 3) > 'Z' ? (strChar[i] + 3 - 26) : (strChar[i] + 3);
                strChar[i] = (char)index;
            }
        }
        return new String(strChar);
    }
    
    public static void main(String... args) {
        ConvertToNewString cn = new ConvertToNewString();
        System.out.println(cn.getNewString("abC;XYz"));
        
    }
}
