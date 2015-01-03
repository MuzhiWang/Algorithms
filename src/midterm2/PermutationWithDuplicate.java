/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midterm2;

import java.util.Arrays;
import java.util.HashSet;

/**
 *
 * @author Muzhi
 */
public class PermutationWithDuplicate {
    
    public void permutationWithDu(String str) {
        assert str.length() != 0;
        if (str.length() == 1) {
            System.out.println(str);
        }
        
        char[] charStr = str.toCharArray();
        Arrays.sort(charStr);
        int index = 0;
        //HashSet<Character> hashSet = new HashSet<Character>();
        permutationHelper(charStr, 0);
    }
    
    private void permutationHelper(char[] str, int index) {
        if (index == str.length - 1) {
            //String out = Arrays.toString(str);
            String out = new String(str);
            System.out.println(out);
            return;
        }
        
        HashSet<Character> hashSetInside = new HashSet<Character>();
        //hashSetInside.add(str[index]);
        for (int i = index; i < str.length; ++i) {
            //hashSetInside.add(str[index]);
            //str = swap(str, index, i);
            //HashSet<Character> hashSetInside = new HashSet<Character>();
            if (!hashSetInside.contains(str[i])) {
                hashSetInside.add(str[i]);
                str = swap(str, index, i);
                permutationHelper(str, index + 1);
                str = swap(str, index, i);
            } 
        }
        //hashSetInside.clear();
        //hashSetInside.remove(str[index]);
    }
    
    private char[] swap(char[] str, int left, int right) {
        char temp = str[left];
        str[left] = str[right];
        str[right] = temp;
        return str;
    }
    
    public static void main(String[] args) {
        String str = "abbc";
        PermutationWithDuplicate permutationWithDu = new PermutationWithDuplicate();
        permutationWithDu.permutationWithDu(str);
    }
}
