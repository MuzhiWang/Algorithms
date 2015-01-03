/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment6;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Muzhi
 */
public class CommonNumber {
    
    public List<Integer> commonNumberHashSet(int[] array1, int[] array2) {
        assert array1 != null && array2 != null;
        
        HashSet<Integer> set = new HashSet<Integer>();
        for (int number : array1) {
            set.add(number);
        }
        List<Integer> result = new ArrayList<Integer>();
        for (int number : array2) {
            if (set.contains(number)) {
                result.add(number);
            }
        }
        return result;
        
    }
    
}
