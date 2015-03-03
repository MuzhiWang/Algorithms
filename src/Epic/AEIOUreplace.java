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

/*	Replace a e i o u, with A E I O U.
 *	At most four eligible letters from the rear of this string are
 *	replaced. The first three eligible letters in the string are 
 *	always exempted from replacement;
 *
 */

public class AEIOUreplace {
    public String aeiouReplace(String str) {
        assert str == null || str.length() > 0;
        int count = 0;
        char[] strChar = str.toCharArray();
        for (int i = 0; i < strChar.length; ++i) {
            if (strChar[i] == 'a' || strChar[i] == 'e' || strChar[i] == 'i' || strChar[i] == 'o'
                    || strChar[i] == 'u') {
                count++;
                if (count > 3)
                    strChar[i] = (char)(strChar[i] - 'a' + 'A');
            }
        }
        return new String(strChar);
    }
    
    public static void main(String... args) {
        AEIOUreplace ae = new AEIOUreplace();
        String str = "an apple a morning keeps me yawning";
        System.out.println(ae.aeiouReplace(str));
    }
    
}
