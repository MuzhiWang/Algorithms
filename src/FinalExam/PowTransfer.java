/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalExam;

/**
 *
 * @author Muzhi
 */
public class PowTransfer {
    
    private long pow(int x, int n) {
        if (n == 1) return x;
        if (n == 0) return 1;
        long half = pow(x, n / 2);
        if (n % 2 == 0) {
            return (long)Math.pow(half, half);
        } else {
            return (long)Math.pow(Math.pow(half, half), x);
        }
    }

    public static void main(String[] args) {
        int x = 2, n = 5;
        PowTransfer t = new PowTransfer();
        System.out.println(t.pow(x, n));
        
    }
}
