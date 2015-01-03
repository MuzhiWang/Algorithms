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
public class Homework_4 {
    int R_board = 0, L_board = 0;
    public int homework_4(int[] a, int target){
        int left = 0, right = a.length - 1;
        int mid;
        
        if(a == null){                              // if the array is null, return -1
            return -1;
        }
        
        while(left < right - 1){                    //determine the left-board of target if there is
            mid = left + (right - left) / 2;
            if(target < a[mid]){
                right = mid;
            }else if(target > a[mid]){
                left = mid;
            }else{
                right = mid;
            }
        }
        if(a[left] == target){
            L_board = left;
        }
        if(a[right] == target){
            L_board = right;
        }
        
        left = 0;
        right = a.length - 1;
        while(left < right -1){                     // determine the right-board of the target if there is
            mid = left + (right - left) / 2;
            if(target < a[mid]){
                right = mid;
            }else if(target > a[mid]){
                left = mid;
            }else{
                left = mid;
            }
        }
        if(a[right] == target){
            R_board = right;
        }else if(a[left] == target){
            R_board = left;
        }else{
            return -1;
        }
        
        if((R_board - L_board) >= 0){                   // calculate the number of target number if there is
            return R_board - L_board;
        }
        return -1;
    }
    
}
