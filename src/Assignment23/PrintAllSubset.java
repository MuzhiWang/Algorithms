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
public class PrintAllSubset {
    /******* String without duplication  *******/
    public void subsetWithoutDuplication(String str) {
        assert str.length() != 0;
        char[] strChar = str.toCharArray();
        StringBuilder res = new StringBuilder();
        subsetWithoutDupHelper(strChar, 0, res);
        System.out.println();
    }
    
    private void subsetWithoutDupHelper(char[] strChar, int layer, StringBuilder res) {
        if (layer == strChar.length) {
            System.out.println(res);
            return;
        }
        res.append(strChar[layer]);
        subsetWithoutDupHelper(strChar, layer + 1, res);
        res.deleteCharAt(res.length() - 1);
        subsetWithoutDupHelper(strChar, layer + 1, res);
    }
    
    /********** String with duplication ************/
    public void subsetWithDuplication(String str) {
        assert str.length() != 0;
        char[] strChar = str.toCharArray();
        HashSet<String> hashSet = new HashSet<String>();
        StringBuilder res = new StringBuilder();
        subsetWithDupHelper(strChar, 0, res, hashSet);
        System.out.println();
    }
    
    private void subsetWithDupHelper(char[] strChar, int layer, StringBuilder res, HashSet<String> hashSet) {
        if (layer == strChar.length && !hashSet.contains(res.toString())) {
            System.out.println(res);
            hashSet.add(res.toString());
            return;
        } else if (layer == strChar.length) {
            return;
        }
        
        res.append(strChar[layer]);
        subsetWithDupHelper(strChar, layer + 1, res, hashSet);
        res.deleteCharAt(res.length() - 1);
        subsetWithDupHelper(strChar, layer + 1, res, hashSet);
    }
    
    
    
    public static void main(String[] args) {
        String str = "abc";
        PrintAllSubset subset = new PrintAllSubset();
        subset.subsetWithoutDuplication(str);
        str = "abbc";
        subset.subsetWithDuplication(str);
    }
}
