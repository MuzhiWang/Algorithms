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
public class Classic_binary {
    int Classic_binary(int[] a, int left, int right, int target){
        int mid = 0;
        while(left < right){
            mid = left + (right - left)/2;
            if(a[mid] < target){
                left = mid + 1;
            }else if(a[mid] > target){
                right = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
