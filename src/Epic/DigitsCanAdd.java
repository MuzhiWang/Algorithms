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

/*	Given a number, find whether the digits in the number can 
 *	be used to form an equation with + and '='. That is if the
 *	number is 123, we can have a equation of 1+2=3. 
 *	Another example would be 17512, it can form an equation of
 *	12+5=17;
 *
 */

public class DigitsCanAdd {
    
    public boolean ifCanAdd(int num) {
        assert num > 0;
        String numStr = String.valueOf(num);
        int num1 = 0, num2 = 0, num3 = 0;
        for (int i = 1; i < numStr.length() - 1; ++i) {
            num1 = Integer.parseInt(numStr.substring(0, i));
            for (int j = i + 1; j < numStr.length(); ++j) {
                num2 = Integer.parseInt(numStr.substring(i, j));
                num3 = Integer.parseInt(numStr.substring(j));
                if (num1 + num2 == num3) {
                    System.out.println(num1 + " + " + num2 + " = " + num3);
                    return true;
                }
                if (num1 + num3 == num2) {
                    System.out.println(num1 + " + " + num3 + " = " + num2);
                    return true;
                }
                if (num2 + num3 == num1) {
                    System.out.println(num2 + " + " + num3 + " = " + num1);
                    return true;
                }
            }
        }
        return false;
    }
    
    public static void main(String... args) {
        
        DigitsCanAdd dca = new DigitsCanAdd();
        System.out.println(dca.ifCanAdd(1111299));
    }
    
}
