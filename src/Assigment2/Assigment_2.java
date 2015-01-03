/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assigment2;

/**
 *
 * @author Muzhi
 */
public class Assigment_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int work1[] = null;
        int work2[] = {8,9,10,1,2,3,4,5,6,7};
        int work3[] = {1,2,5,5,5,5,5,5,7,8,9,100};

        Homework_2 A = new Homework_2();
        int result1 = A.homework_2(work1, 1);
        //System.out.println(A.right);
        //System.out.println(d.v.elementAt(26));
        System.out.println("Q2: result1 is " + result1);
        
        Homework_3 B = new Homework_3();
        int result2 = B.homework_3(work2, 10);
        //System.out.println("the shifted array's board is " + B.board);
        System.out.println("Q3: result2 is " + result2);
        
        Homework_4 C = new Homework_4();
        int result3 = C.homework_4(work3, 5);
        //System.out.println(C.L_board + "   " + C.R_board);
        System.out.println("Q4: the number of duplicated target is " + result3);
    }
    
}
