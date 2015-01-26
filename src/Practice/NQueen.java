/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.util.Arrays;

/**
 *
 * @author Muzhi
 */
public class NQueen {
    public void nQueen(int n) {
        if (n < 1) 
            return;
        int[] mat = new int[n];
        nQueen(mat, 0);
    }
    
    private void nQueen(int[] matrix, int index) {
        if (index == matrix.length) {
            //System.out.println(Arrays.toString(matrix));
            print(matrix);
            return;
        }
        for (int i = 0; i < matrix.length; ++i) {
            matrix[index] = i;
            if (valid(matrix, index)) {
                nQueen(matrix, index + 1);
            }
        }
    }
    
    private boolean valid(int[] matrix, int index) {
        for (int i = 0; i < index; ++i) {
            if (matrix[i] == matrix[index] || Math.abs(matrix[i] - matrix[index]) == Math.abs(i - index))
                return false;
        }
        return true;
    }
    
    private void print(int[] matrix) {
        //int[][] mat = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix.length; ++j) {
                if (j == matrix[i])
                    System.out.print("X ");
                else
                    System.out.print("O ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        NQueen nQ = new NQueen();
        nQ.nQueen(8);
    }
}
