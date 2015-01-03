/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment23;

/**
 *
 * @author Muzhi
 */
public class PrintPrantheses {
    public void printPrantheses(int k) {
        assert k > 0;
        int left = 0, right = 0;
        StringBuilder res = new StringBuilder();
        printHelper(k, 0, 0, res);
        
    }
    
    private void printHelper(int k, int left, int right, StringBuilder res) {
        if (left + right == 2 * k) {
            System.out.println(res);
            return;
        }
        if (left < k) {
            res.append("(");
            printHelper(k, left + 1, right, res);
            res.deleteCharAt(res.length() - 1);
        }
        if (right < k && right < left) {
            res.append(")");
            printHelper(k, left, right + 1, res);
            res.deleteCharAt(res.length() - 1);
        }
    }
    
    public static void main(String[] args) {
        int k = 4;
        PrintPrantheses p = new PrintPrantheses();
        p.printPrantheses(k);
        
    }
    
}
