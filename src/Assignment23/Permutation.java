/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment23;

import java.util.HashSet;

/**
 *
 * @author Muzhi
 */
public class Permutation {
    
    /********  permutation without duplication *********/
    public void permutationWithoutDuplication(String str) {
        assert str.length() != 0;
        char[] strChar = str.toCharArray();
        permutaionWithoutDupHeler(strChar, 0);
        System.out.println();
    }
    
    private void permutaionWithoutDupHeler(char[] strChar, int layer) {
        if (layer == strChar.length - 1) {
            System.out.println(strChar);
            return;
        } 
        for (int i = layer; i < strChar.length; ++i) {
            swap(strChar, layer, i);
            permutaionWithoutDupHeler(strChar, layer + 1);
            swap(strChar, layer, i);
        }
        
    }
    
    /*********** permutation with duplication ***********/
    public void permutationWithDup(String str) {
        assert str.length() != 0;
        char[] strChar = str.toCharArray();
        permutationWithDupHelper(strChar, 0);
        System.out.println();
    }
    
    private void permutationWithDupHelper(char[] strChar, int layer) {
        if (layer == strChar.length) {
            System.out.println(strChar);
            return;
        }
        HashSet<Character> hashSet = new HashSet<Character>();
        for (int i = layer; i < strChar.length; ++i) {
            if (!hashSet.contains(strChar[i])) {
                hashSet.add(strChar[i]);
                swap(strChar, layer, i);
                permutationWithDupHelper(strChar, layer + 1);
                swap(strChar, layer, i);
            }
        }
    }
    
    
    private void swap(char[] strChar, int left, int right) {
        char temp = strChar[left];
        strChar[left] = strChar[right];
        strChar[right] = temp;
    }
    
    /********** next permutation method **************/
    private boolean next_permutation(char [] str) {
        int j = str.length - 1;
        while (j > 0 && str[j] <= str[j - 1]) j--;
        if (j == 0) {
            return false;
        }
        for (int i = str.length - 1; i >= j; --i) {
            if (str[j - 1] < str[i]) {
                swap(str, j - 1, i);
                break;
            }
        }
        for (int i = str.length - 1; i >= j; --i, ++j) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
        return true;
    }
    private void permuations(char[]str) {
        do {
            System.out.println(new String(str));
        } while (next_permutation(str));
    }
    
    
    public static void main(String[] args) {
        String str = "abcd";
        Permutation permu = new Permutation();
        permu.permutationWithoutDuplication(str);
        str = "abcb";
        permu.permutationWithDup(str);
        permu.permuations(str.toCharArray());
    }
    
}
