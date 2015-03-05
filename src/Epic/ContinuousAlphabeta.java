/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Epic;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Muzhi
 */

/*	Print continuous alphabets from a sequence of arbitary
 *	alphabets.
 *	For example, 
 *	Input: abcdefljkflsjflmnopflsjfasjftuvwxyz;
 *	output: abcdef; mnop; tuvwxyz; 
 *	Input: AbcDefljkflsjflmnopflsjfasjftuvWxYz;
 */

public class ContinuousAlphabeta {
    
    public List<String> getContinuous(String str) {
        assert str != null && str.length() > 0;
        int left = 0, right = 0;
        List<String> res = new ArrayList<>();
        for (int i = 1; i < str.length(); ++i) {
            /// detect capital and low-case
            if (str.charAt(i) - str.charAt(i - 1) == 1 || str.charAt(i) - str.charAt(i - 1) == (65 - 97 + 1) || 
                    str.charAt(i) - str.charAt(i - 1) == (97 - 65 + 1)) {
                left = i - 1;
                right = left + 1;
                /// detect capital and low-case
                while (right < str.length() && (str.charAt(right) - str.charAt(right - 1) == 1 || str.charAt(right) - str.charAt(right - 1) == (65 - 97 + 1) || 
                    str.charAt(right) - str.charAt(right - 1) == (97 - 65 + 1))) {
                    right++;
                }
                res.add(str.substring(left, right));
                i = right - 1;
            }
        }
        return res;
    }
    
    public static void main(String... args) {
        ContinuousAlphabeta con = new ContinuousAlphabeta();
        List<String> res = con.getContinuous("cjklAbclmNopqrs");
         
        for (String s : res) {
            System.out.print(s + "; ");
        }
        
        System.out.println("\n" + ('a' - 'A'));
    }
    
}
