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
    
}
