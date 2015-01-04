/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment24;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;

/**
 *
 * @author Muzhi
 */
public class NoComCharStringsWithMaxProduct {
    
    public int noComChar(List<String> dictionary) {
        if (dictionary == null || dictionary.size() < 2) 
            return -1;
        List<ele> eleDic = new LinkedList<>();
        for (String str : dictionary) 
            eleDic.add(new ele(str));
        Collections.sort(eleDic, new Comparator<ele>() {
            @Override
            public int compare(ele one, ele two) {
                return two.len - one.len;
            }
        });
        int maxProduct = 0;
        for (int i = 0; i < eleDic.size(); ++i) {
            for (int j = 0; j < i; ++j) {
                int curLen = eleDic.get(i).len * eleDic.get(j).len;
                if (i != j && ((eleDic.get(i).bitMap & eleDic.get(j).bitMap) != 0) && (curLen > maxProduct)) {
                    maxProduct = curLen;
                }
            }
        }
        return maxProduct;
    }
    
    private class ele {
        String str;
        int bitMap;
        int len;
        
        ele(String str) {
            this.str = str; 
            len = str.length();
            bitMap = 0;
            for (int i = 0; i < len; ++i) {
                bitMap |= 1 << (str.charAt(i) - 'a');
            }
        }
    }
    
    public static void main(String[] args) {
        NoComCharStringsWithMaxProduct n = new NoComCharStringsWithMaxProduct();
        List<String> l = new LinkedList<>();
        l.add("abcd");
        l.add("defg");
        l.add("eyz");
        l.add("abx");
        l.add("hg");
        l.add("hutie");
        int res = n.noComChar(l);
        System.out.println(res);
    }
}
