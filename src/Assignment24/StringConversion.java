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
    /******  The test case is not right when "A1B2C3D4E5" or "A1B2C3D4E5F6", just fit for 2^n elements *********/
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
        while (indexL <= mid && cur < res.length && leftChar[indexL] - '0' < 10) 
            res[cur++] = leftChar[indexL++];
        while (indexR < res.length && cur < res.length && rightChar[indexR] - '0' < 10) 
            res[cur++] = rightChar[indexR++];
        
        return res;
    }
    
    public static void main(String[] args) {
        StringConversion s = new StringConversion();
        String res = s.strConversion1("A1B2C3D4E5F6G7H8");
        System.out.println(res);
    }
    
}
