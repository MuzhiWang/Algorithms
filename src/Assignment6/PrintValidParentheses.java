/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment6;

/**
 *
 * @author Muzhi
 */
public class PrintValidParentheses {
    /*
    public void validParentheses(int k) {
        char[] solution = new char[2 * k];
        validParentheses(k, 0, 0, solution);
    }
    
    private void validParentheses(int k, int left, int right, char[] solution) {
        if (left + right == 2 * k) {
            System.out.println(new String(solution));
            return;
        }
        
        if (left < k) {
            solution[left + right] = '(';
            validParentheses(k, left + 1, right, solution);
        }
        
        if (right < left) {
            solution[left + right] = ')';
            validParentheses(k, left, right + 1, solution);
        }
        
    }
    */
    
    public void printValidParentheses(int k) {
        StringBuilder printResult = new StringBuilder();
        if (k == 0) {
            return;
        }
        int left = 0;
        int right = 0;
        printResult.append('(');
        printParenthesesHelper(k, 1, 0, printResult);
        
    }
    
    private void printParenthesesHelper(int k, int left, int right, StringBuilder printResult) {
        if (left + right == k * 2) {
            System.out.println(printResult.toString());
            return;
        }
        
        if (left < k && left >= right) {
            printResult.append('(');
            printParenthesesHelper(k, left + 1, right, printResult);
            printResult.deleteCharAt(printResult.length() - 1);
        }
        //printResult.deleteCharAt(printResult.length() - 1);
        if (right < k && right < left) {
            printResult.append(')');
            printParenthesesHelper(k, left, right + 1, printResult);
            printResult.deleteCharAt(printResult.length() - 1);
        }
    }
    
}
