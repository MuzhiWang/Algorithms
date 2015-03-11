/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Epic;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Muzhi
 */

/*	There is a game they termed as mingo. 
A random generator generates out any number from 1 to 1000.
 *	There is a 10 by 10 matrix, a random generator assigns values
 *	to each block of this matrix (within 1 to 1000 obviously).
 *	Whenever, a row or a column or a diagonal is fully filled in 
 *	in this 10 by 10 matrix from the number called out by the speaker
 *	it is called a mingo.
 *	Write a program that will find first mingo, second mingo, then 
 *	third mingo, and so forth. 
 *
 *	Strategy:
 *	Use two arrays one for row, the other for column and two variables
 *	to keep track of diagonals.
 *
 *	Increase the row or column counter by one, increase the diagonal 
 *	count if i==j;
 *
 *	Keep track of repeated random numbers and we can always find the
 *	index of the number which is generated and check if it already in
 *	the matrix, index: row = num/n, col = num%n;
 */

public class Mingo {
    
    public void getMingo(int[][] matrix) {
        assert matrix != null && matrix.length == 10 && matrix[0].length == 10;
        int count = 1;
        for (int i = 0; i < 100; ++i) {
            if (checkMingo(matrix, i / 10, i % 10)) {
                System.out.println("The " + count + " mingo is row " + (i / 10 + 1) + " , column " + (i % 10 + 1));
                System.out.println();
                count++;
            }
        }
    }
    
    private boolean checkMingo(int[][] matrix, int row, int column) {
        boolean[] isMingo = new boolean[4];
        Arrays.fill(isMingo, true);
        for (int i = 0; i < 10; ++i) {
            if (matrix[row][i] == 0) {
                isMingo[0] = false;
                break;
            }
        }
        if (isMingo[0] == true) {
            System.out.println("The row is mingo.");
            return true;
        }
        
        for (int i = 0; i < 10; ++i) {
            if (matrix[i][column] == 0) { 
                isMingo[1] = false;
                break;
            }
        }
        if (isMingo[1] == true) {
            System.out.println("The column is mingo");
            return true;
        }
        
        /// diagonals check. four derections.
        int r = row, c = column;
        while (r < 10 && c < 10) {
            if (matrix[r][c] == 0) {
                isMingo[2] = false;
                break;
            }
            r++;
            c++;
        }
        r = row; 
        c = column;
        while (r >= 0 && c >= 0) {
            if (matrix[r][c] == 0) {
                isMingo[2] = false;
                break;
            }
            r--;
            c--;
        }
        if (isMingo[2]) {
            System.out.println("The diagonal is mingo.");
            return true;
        }
        
        r = row;
        c = column;
        while (r < 10 && c >= 0) {
            if (matrix[r][c] == 0) {
                isMingo[3] = false;
                break;
            }
            r++;
            c--;
        }
        r = row; 
        c = column;
        while (r >= 0 && c < 10) {
            if (matrix[r][c] == 0) {
                isMingo[3] = false;
                break;
            }
            r--;
            c++;
        }
        if (isMingo[3]) {
            System.out.println("The anti-diagonal is mingo.");
            return true;
        }
        return false;
    }
    
    private void generateMatrix(int[][] matrix, int countNumber) {
        for (int i = 0; i < countNumber; ++i) {
            Random rand = new Random();
            //int rand = (int)(Math.random() * 1000);
            int row = rand.nextInt(10);
            int col = rand.nextInt(10);
            matrix[row][col] = rand.nextInt(1000);
        }
    }
    
    private void printMatrix(int[][] matrix) {
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 10; ++j) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static void main(String... args) {
        Mingo m = new Mingo();
        int[][] matrix = new int[10][10];
        m.generateMatrix(matrix, 100);
        m.printMatrix(matrix);
        m.getMingo(matrix);
    }
}
