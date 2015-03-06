/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Epic;

/**
 *
 * @author Muzhi
 */

/*	let the user enter a decimal number. The range allowed is 0.0001 to 0.9999. 
 *	the output should be an ireducibal fraction.
 *	e.g. input 0.35 output 7/20;
 *
 */

public class DecimalNumber {
    
    public String getDecimalNumber(double num) {
        assert num >= 0.0001 && num <= 0.9999;
        int denominator = 10000;
        int numerator = (int)(num * denominator);
        int testNum = 2;
        int temp = numerator;
        
        while (testNum <= temp / 2) {
            if (numerator % testNum == 0 && denominator % testNum == 0) {
                numerator /= testNum;
                denominator /= testNum;
            } else
                testNum++;
        }
        
        return new String(numerator + "/" + denominator);
    }
    
    public static void main(String... args) {
        DecimalNumber dn = new DecimalNumber();
        System.out.println(dn.getDecimalNumber(0.51));
        
    }
    
}
