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
public class Homework_3 {
    int board;
    public int homework_3(int[] a, int target){
        int left = 0;
        int right = a.length - 1;
        
        if(a == null){                              // if the array is null, return -1
            return -1;
        }

        int mid = 0, temp = 0;
        while(left < right - 1){                    // judge the shifted board
            mid = left + (right - left) / 2;
            if(a[left] > a[mid]){
                //temp = mid;
                right = mid;
            }else if(a[left] < a[mid]){
                //right = temp;
                left = mid;
            }else{
                return -1;
            }
        }
        board = left;
    
        left = 0;
        right = board;                          // judge whether the target is on the left part of the shifted sort
        if(target > a[right]){
            return -1;
        }
        if(target == a[0]){
            return 0;
        }
        if(target < a[0]){
            left = board;
            right = a.length - 1;
            while(left <= right){
                mid = left + (right - left) / 2;
                if(target < a[mid]){
                    right = mid - 1;
                }else if(target > a[mid]){
                    left = mid + 1;
                }else{
                    return mid;
                }
            }
        }
        left = 1;
        right = board;                              // judge whether the target is on the right part of the shifted sort
        while(left <= right){
            mid = left + (right - left) / 2;
            if(target < a[mid]){
                right = mid - 1;
            }else if(target > a[mid]){
                left = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
