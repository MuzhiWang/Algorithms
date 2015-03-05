/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Epic;

import java.util.HashSet;

/**
 *
 * @author Muzhi
 */

/*	A number can be broken into different subsequence parts. 
 *	Suppose a number 3245 can be broken into parts like 3,2,4,5,32,24,45,
 *	324,245. And this number is a colorful number, since product of every
 *	digit of a sub-sequence are different. But 326 is not a colorful number.
 *	Write a function that tells if the given number is a colorful number
 *	or not.
 *
 *	Strategy:
 */

public class ColorfulNumber {
    
    public boolean isColorful(int num) {
        assert num > 0;
        String numStr = String.valueOf(num);
        int bit = String.valueOf(num).length();
        int bits = (int) Math.log10(num) + 1;       // another bit calculation
        HashSet<Integer> hash = new HashSet<Integer>();
        int[] digitNum = new int[bit];
        
        for (int i = 0; i < bit; ++i) {
            int temp = Integer.parseInt(numStr.substring(i, i + 1));
            if (hash.contains(temp))
                return false;
            else 
                hash.add(temp);
            digitNum[i] = temp;
        }
        
        for (int i = 0; i < bit; ++i) {
            int temp = digitNum[i];
            for (int j = i + 1; j < bit; ++j) {
                temp *= digitNum[j];
                if (hash.contains(temp)) {
                    System.out.println(temp);
                    return false;
                }
                else
                    hash.add(temp);
            }
        }
        
        return true;
    }
    
    public static void main(String... args) {
        ColorfulNumber cn = new ColorfulNumber();
        System.out.println(cn.isColorful(3245));
        
    }
    
}
