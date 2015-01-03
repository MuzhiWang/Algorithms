/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Leetcode;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Muzhi
 */
public class LeetCode_singleNum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //int[] A;
        ArrayList<Integer> array = new ArrayList<Integer>();
        Scanner S = new Scanner(System.in);
        System.out.println("Please input arry A[]:");
        //S.next();
        int result;
        for(int i = 0; i < 5; i++){
            //A[i] = (int)S.next();
            array.add(S.nextInt());
        }
        int[] arrayInt = new int[array.size()];
        for (int i : array) {
            arrayInt[i] = array.get(i);
        }
        
        singleNumber single = new singleNumber();
        result = single.singleNumber(arrayInt);
        System.out.println();
        System.out.println("The single number is: " + result);
        
        
    }
    
public static class singleNumber{
    public int singleNumber(int[] array) {
        /*
        int num = 0;
        int singleNum = 0;
        for(int i = 1; i < A.length; i++){
            if(A[0] != A[i] && i == A.length - 1){
                singleNum = A[0];
            }
        }
        for(int i = 1; i < A.length-1 ; i++){
            num = A[i];
            for(int j = i+1; j < A.length; j++){
            if(num != A[j] && num != A[0]){
                if(j == A.length-1){
                    singleNum = num;
                    break;
                }
            }else if(num == A[j]){
                A[i] = A[0];
                A[j] = A[0];
            }
            }
        }
        if(singleNum != A[0] && singleNum != num){
            singleNum = A[A.length - 1];
        }
        return singleNum;
        */
        
        
        /*
        int num = 0;
        int singleNum = 0;
        int sum = 0;
        
        for(int i = 0; i < A.length; i++){
            //sum += A[i];
            for(int j = i+1; j < A.length-1; j++ ){
                if(A[i] == A[j]){
                    sum = sum - A[i];
                }else{
                    sum = sum + A[i];
                }
            }
        }
        singleNum = sum;
        return singleNum;
        */
        int result = 0;
        for (int i : array) {
            result = result ^ i;
        }
        return result;
    }
}
        
   
}
    


