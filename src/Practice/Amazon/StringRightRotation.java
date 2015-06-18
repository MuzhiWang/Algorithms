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
public class StringRightRotation {
    
    public int strIsRotation(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0 || 
                str1.length() != str2.length())
            return -1;
        String str = str1 + str1;
        return str.indexOf(str2) != -1 ? 1 : -1;
        //str.contains(str);
    }
    
    public static void main(String... args) {
        String str1 = "aba";
        String str2 = "baa";
        StringRightRotation st = new StringRightRotation();
        System.out.println(st.strIsRotation(str1, str2));
    }
    
}
