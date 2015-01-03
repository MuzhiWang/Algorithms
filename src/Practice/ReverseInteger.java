/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

/**
 *
 * @author Muzhi
 */
public class ReverseInteger {
    public int reverse(int input) {
        if (Math.abs(input) < 10) return input;
        int res = 0, temp = input;
        while (temp > 0) {
            res = res * 10 + temp % 10;
            temp /= 10;
        }
        return res;
    }
    
    public String reverseWithStr(int input) {
        Integer intRes = reverse(input);
        String res;
        if (input % 10 == 0) {
            res = "0" + intRes.toString();
        } else {
            res = intRes.toString();
        }
        return res;
    }
    
    public static void main(String[] args) {
        int input = 1089370;
        ReverseInteger r = new ReverseInteger();
        System.out.println(r.reverse(input));
        System.out.println(r.reverseWithStr(input));
    }
}
