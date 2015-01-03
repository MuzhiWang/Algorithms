/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment23;

import java.util.LinkedList;

/**
 *
 * @author Muzhi
 */
public class PrintMixedPrantheses {
    int counter = 0;
    public void printMixed(int x, int y, int z) {
        char[] p = {'x', 'y', 'z'};
        LinkedList<Character> stack = new LinkedList<Character>();
        StringBuilder res = new StringBuilder();
        printMixedHelper(x, y, z, new int[] {0,0}, new int[] {0, 0}, new int[] {0, 0}, res, stack);
        
    }
    
    private void printMixedHelper(int x, int y, int z, int[] p1, int[] p2, int[] p3, StringBuilder res, LinkedList<Character> stack) {
        if (p1[0] + p1[1] + p2[0] + p2[1] + p3[0] + p3[1] == 2 * (x + y + z)) {
            System.out.println(res);
            ++this.counter;
            return;
        }
        
        if (p1[0] < x && (stack.isEmpty() || stack.peek() == '{')) {
            res.append("{");
            stack.push('{');
            ++p1[0];
            printMixedHelper(x, y, z, p1, p2, p3, res, stack);
            --p1[0];
            stack.pop();
            res.deleteCharAt(res.length() - 1);
        }
        if (p1[1] < x && p1[1] < p1[0] && !stack.isEmpty() && stack.peek() == '{') {
            res.append("}");
            ++p1[1];
            stack.pop();
            printMixedHelper(x, y, z, p1, p2, p3, res, stack);
            --p1[1];
            stack.push('{');
            res.deleteCharAt(res.length() - 1);
        }
        
        if (p2[0] < y && (stack.isEmpty() || stack.peek() == '{')) {
            res.append("[");
            stack.push('[');
            ++p2[0];
            printMixedHelper(x, y, z, p1, p2, p3, res, stack);
            --p2[0];
            stack.pop();
            res.deleteCharAt(res.length() - 1);
        }
        if (p2[1] < y && p2[1] < p2[0] && !stack.isEmpty() && stack.peek() == '[') {
            res.append("]");
            stack.pop();
            ++p2[1];
            printMixedHelper(x, y, z, p1, p2, p3, res, stack);
            --p2[1];
            stack.push('[');
            res.deleteCharAt(res.length() - 1);
        }
        
        if (p3[0] < z && (stack.isEmpty() || stack.peek() == '[')) {
            res.append("(");
            stack.push('(');
            ++p3[0];
            printMixedHelper(x, y, z, p1, p2, p3, res, stack);
            --p3[0];
            stack.pop();
            res.deleteCharAt(res.length() - 1);
        }
        if (p3[1] < z && p3[1] < p3[0] && !stack.isEmpty() && stack.peek() == '(') {
            res.append(")");
            stack.pop();
            ++p3[1];
            printMixedHelper(x, y, z, p1, p2, p3, res, stack);
            --p3[1];
            stack.push('(');
            res.deleteCharAt(res.length() - 1);
        }
    }
    
    public static void main(String[] args) {
        PrintMixedPrantheses p = new PrintMixedPrantheses();
        p.printMixed(4,3,2);
        System.out.println(p.counter);
    }
}
