/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment25;

/**
 *
 * @author Muzhi
 */
public class HexadecimalRepresent {
    
    public String hexadecimalRep(int num) {
        String hex = "0123456789ABCDEF";
        boolean isPositive = (num >= 0);
        if (Math.abs(num) < 16)
            return isPositive ? new String("0X" + hex.charAt(num)) : new String("-OX" + hex.charAt(-num));
        String res = "";
        num = Math.abs(num);
        while (num > 0) {
            res = hex.charAt(num % 16) + res;
            num /= 16;
        }
        res = "OX" + res;
        return isPositive ? res : "-" + res;
    }
    
    public static void main(String... args) {
        HexadecimalRepresent h = new HexadecimalRepresent();
        String res = h.hexadecimalRep(-29);
        System.out.println(res);
    }
}
