/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Amazon;

/**
 *
 * @author Muzhi
 */
public class GreyCode {
    
    public int isGreyCode(byte element1, byte element2) {
        byte res = (byte)(element1 ^ element2);
        for (int i = 0; i <= 7; ++i) {
            byte temp = (byte)(1 << i);
            if (temp == res) {
                return 1;
            }
        }
        return 0;
    }
    
    public int isGreyCode2(byte ele1, byte ele2) {
        byte temp = (byte)(ele1 ^ ele2);
        System.out.println(temp & (temp - ((byte)1)));
        System.out.println(((Object)(temp  - (1))).getClass().getName());
        if (temp != 0 && (byte)(temp & (byte)(temp - 1)) == 0) {
            return 1;
        }
        
        System.out.println((byte)temp);
        System.out.println((byte)(temp - 1));
        return 0;
    }
    
    public static void main(String... args) {
        byte ele1 = 0;
        byte ele2 = -128;
        GreyCode greg = new GreyCode();
        System.out.println(greg.isGreyCode(ele1, ele2));
        System.out.println(greg.isGreyCode2(ele1, ele2));
        System.out.println((byte)((byte)(-128) - 1));
        byte temp = -128;
        //byte temp = (byte));
        System.out.println();
    }
    
}
