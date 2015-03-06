/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Epic;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

/**
 *
 * @author Muzhi
 */

/*	Write a program that will print out all of the possible combinations of keypad
 *	letters depending on the input.
 *
 *	Leetcode problem.
 *      Given a digit string, return all possible letter combinations that the number could represent.
 *      A mapping of digit to letters (just like on the telephone buttons) is given below.
 */

public class KeypadLettersCombinations {
    
    public List<String> combinations(int num) {
        Scanner scan = new Scanner(System.in);
        int[] input = new int[num];
        for(int i = 0; i < num; ++i) {
            System.out.println("You can input " + num + " numbers from Keypad, "
                    + "Please input the " + (i + 1) + "th number: ");
            input[i] = scan.nextInt();
            //System.out.println(input[i]);
        }
        
        HashMap<Integer, char[]> hash = new HashMap<>();
        hash.put(2, new char[]{'a', 'b', 'c'});
        hash.put(3, new char[]{'d', 'e', 'f'});
        hash.put(4, new char[]{'g', 'h', 'i'});
        hash.put(5, new char[]{'j', 'k', 'l'});
        hash.put(6, new char[]{'m', 'n', 'o'});
        hash.put(7, new char[]{'p', 'q', 'r', 's'});
        hash.put(8, new char[]{'t', 'u', 'v'});
        hash.put(9, new char[]{'w', 'x', 'y', 'z'});
        /// consider the 1 & 0 keypad as null
        hash.put(1, new char[]{});
        hash.put(0, new char[]{});
        
        List<String> res = new ArrayList<>();
        StringBuilder curCom = new StringBuilder();
        comHelper(input, res, curCom, 0, hash);
        
        return res;
    }
    
    private void comHelper(int[] input, List<String> res, StringBuilder curCom, int index, HashMap<Integer, char[]> hash) {
        if (index == input.length) {
            res.add(curCom.toString());
            return;
        }
        int charNum = hash.get(input[index]).length;
        /// check the charNum, based on that to do recursion.
        if (charNum > 0) {
            for (int i = 0; i < charNum; ++i) {
                if (hash.get(input[index]) != null) {
                    curCom.append(hash.get(input[index])[i]);
                    comHelper(input, res, curCom, index + 1, hash);
                    curCom.deleteCharAt(curCom.length() - 1);
                }
            }
        } else {
            comHelper(input, res, curCom, index + 1, hash);
        }
    }
    
    public static void main(String... args) {
        KeypadLettersCombinations key = new KeypadLettersCombinations();
        List<String> res = key.combinations(4);
        
        for (String s : res) {
            System.out.print(s + " ");
        }
    }
    
}
