/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment6;
import java.util.HashSet;

/**
 *
 * @author Muzhi
 */
public class MissingNumber {
    
    public int missNumber(int[] array) {
        assert array != null || array.length != 0;
        
        int missNum = 0;
        int length = array.length + 1;
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int i : array) {
            hashSet.add(i);
        }
        
        for (int index = 1; index < length; ++index) {
            if (!hashSet.contains(index)) {
                missNum = index;
                break;
            }
        }
        return missNum;
    }
    
    
    
    /****** This is standard method from Teacher Yan ********************
    public int findMissingHashMap(int n, int[] array) {
        assert array != null && n >= 1 && n == array.length + 1;
        HashSet<Integer> set = new HashSet<Integer>();
        for (int number : array) {
            set.add(number);
        }
        for (int number = 1; number < n; number++) {
            if (!set.contains(number)) {
                return number;
            }
        }
        return n;
    }
    */
}
