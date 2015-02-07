/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

/**
 *
 * @author Muzhi
 */
public class UniqueInteger {
    
    
    
    
    
    public int[] differentEle(int[] arrayOne, int[] arrayTwo) {
        assert arrayOne != null && arrayTwo != null;
        if (arrayOne.length == 0) {
            return arrayTwo;
        }
        if (arrayTwo.length == 0) {
            return arrayOne;
        }

        HashMap<Integer, Boolean> hashMap = new HashMap<>();    // hashmap key represents the array element, value represents if appears in the other array, true means yes.
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arrayOne.length; ++i) {
            hashMap.put(arrayOne[i], false);
        }
        for (int i = 0; i < arrayTwo.length; ++i) {
            if (hashMap.containsKey(arrayTwo[i])) {
                hashMap.put(arrayTwo[i], true);
            } else {
                result.add(arrayTwo[i]);
            }
        }

        Iterator<Entry<Integer, Boolean>> it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry)it.next();
            if (entry.getValue() == Boolean.FALSE) {
                result.add((int)entry.getKey());
            }
        }
        
        HashSet<Integer> hashSet = new HashSet<>();
        //ArrayList<Integer> test = hashSet.toArray();
        
//        do {
//            
//        } while (true);
        hashSet.addAll(result);
        Object[] red = hashSet.toArray();
        Integer[] res = (Integer[])red;
        
        Arrays.asList(res);
        
        
        for (Entry en : hashMap.entrySet()) {
            
        }
        
        int[] intResult = new int[result.size()];
        for (int i = 0; i < result.size(); ++i) {
            intResult[i] = result.get(i);
        }
        return intResult;
    }
    
    public static void main(String[] args) {
        UniqueInteger di = new UniqueInteger();
        int[] arrayOne = {1, 2, 2, 5};
        int[] arrayTwo = {3, 4, 5, 5, 6, 6, 1};
        int[] res = di.differentEle(arrayOne, arrayTwo);
        System.out.println(Arrays.toString(res));
        
        
    }
    
}
