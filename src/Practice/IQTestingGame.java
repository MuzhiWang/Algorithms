/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.util.Scanner;

/**
 *
 * @author Muzhi
 */
public class IQTestingGame {
    public static void main(String... args) throws InterruptedException {
        
        Scanner scan = new Scanner(System.in);
        String strNum = new String();
        strNum = String.valueOf((int)(Math.random() * 1000000));
//        while (strNum.length() != 6) {
//            System.out.println("Please enter the first 6 numbers: ");
//            strNum = String.valueOf(scan.nextInt());
//        }
        System.out.println("The first input numbers is: " + strNum);
        Thread.sleep(5000);
        String newNum = new String();
        String inputNum = strNum;
        int count = 6;
        while (inputNum.equals(strNum)) {
            count++;
            newNum = String.valueOf((int)(Math.random() * 10));
            strNum = strNum + newNum;
            //-System.out.println(inputNum + " : " + strNum);
            System.out.println("The " + count + "th input numbers is: " + strNum);
            Thread.sleep(5000);
            for (int i = 0; i < 30; ++i) {
                System.out.println();
            }
            int testNum = 0, testRes = 1;
            while (testNum != testRes) {
                System.out.println("Please calculate the following equation: ");
                int num1 = (int)(Math.random() * 10) + 10;
                int num2 = (int)(Math.random() * 10);
                System.out.println(num1 + " * " + num2 + "=");
                testRes = num1 * num2;
                testNum = scan.nextInt();
            }
            
            System.out.println("Please input your numbers: ");
            inputNum = String.valueOf(scan.nextLong());
        }
        System.out.println(inputNum + " : " + strNum);
        System.out.println("Your final score is: " + count);
    }
    
}
