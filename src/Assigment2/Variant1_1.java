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
public class Variant1_1 {
    int Variant1_1(int[] a, int left, int right, int target){
        int mid;
        while(left < right -1){
            mid = left + (right - left)/2;
            if(a[mid] < target){
                left = mid;
            }else if(a[mid] >= target){
                right = mid;
            }
        }
        if(a[left] == target){
            return left;
        }
        if(a[right] == target){
            return right;
        }
        return -1;
    }
}
