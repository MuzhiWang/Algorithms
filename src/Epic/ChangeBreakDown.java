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

/*	Something cost $10.25, and the customer pays with a $20 bill
 *	The program will print out the most efficient "change-break down"
 *	which is 1 five, 4 ones, and 3 quarters. Find the minimum number
 *	of coins required to make change for a given sum.
 *
 */

public class ChangeBreakDown {
    public void changePrint(double input, double bill) {
        assert input > 0;
        double money = bill - input;
        double[] changes = {0.01, 0.05, 0.1, 0.25, 1.0, 5.0, 10.0, 20.0, 50.0, 100.0};
        int type = changes.length;
        int[] typeIndex = new int[type];
        
        for (int i = type - 1; i >= 0; --i) {
            while (money - changes[i] >= 0) {
                money -= changes[i];
                typeIndex[i]++;
            }
        }
        
        for(int i = 0; i < type; ++i) {
            System.out.println(String.valueOf(changes[i]) + " 's number is: " + typeIndex[i]);
        }
    }
    
    public static void main(String... args) {
        ChangeBreakDown ch = new ChangeBreakDown();
        ch.changePrint(10.01, 20);
    }
    
}
