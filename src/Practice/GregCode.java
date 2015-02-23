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
public class GregCode {
    
    public int isGregCode(byte element1, byte element2) {
        byte res = (byte)(element1 ^ element2);
        for (int i = 0; i <= 7; ++i) {
            byte temp = (byte)(1 << i);
            if (temp == res) {
                return 1;
            }
        }
        return 0;
    }
    
    public static void main(String... args) {
        byte ele1 = 0;
        byte ele2 = 3;
        GregCode greg = new GregCode();
        System.out.println(greg.isGregCode(ele1, ele2));
        
    }
    
}
