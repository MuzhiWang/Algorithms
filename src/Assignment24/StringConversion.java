/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment24;

/**
 *
 * @author Muzhi
 */
public class StringConversion {
    // input string "A1B2C3D4" ----> "ABCD1234"
    public String strConversion1(String str) {
        if (str == null || str.length() == 0) 
            return null;
        char[] charStr = str.toCharArray();
        char[] res = divide(charStr, 0, charStr.length - 1);
        return new String(res);
    }
    
    private char[] divide(char[] charStr, int left, int right) {
        if (left >= right) 
            return charStr;
        int mid = left + (right - left) / 2;
        char[] leftChar = divide(charStr, left, mid);
        char[] rightChar = divide(charStr, mid + 1, right);
        int indexL = left, indexR = mid + 1;
        int cur = left;
        char[] res = new char[charStr.length];
        while (indexL <= mid && leftChar[indexL] - '0' > 9) {
            res[cur++] = leftChar[indexL++];
            res[cur++] = rightChar[indexR++];
        }
        if (indexL < leftChar.length && leftChar[indexL] - '0' > 9) {
            while (indexL < leftChar.length && indexL < res.length) 
                res[cur++] = leftChar[indexL++];
        }
        if (indexR < rightChar.length && rightChar[indexR] - '0' > 9) {
            while (indexR < rightChar.length && indexR < res.length)
                res[cur++] = leftChar[indexR++];
        }
        return res;
    }
    
    public static void main(String[] args) {
        StringConversion s = new StringConversion();
        String res = s.strConversion1("A1B2C3D4");
        System.out.println(res);
    }
    
}
