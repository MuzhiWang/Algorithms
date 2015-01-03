/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assigment2;
import java.util.Arrays;
import java.util.Vector;
//
/**
 *
 * @author Muzhi
 */
public class Homework_2 {
    //public int right;
    int homework_2(int[] a, int target){
        int mid, left = 0, right = 1;;
        //Variant1_1 V = new Variant1_1();
        dictionary D = new dictionary();
        D.dictionary(a);
        
        if(a == null){                      //when the array is null, return -1
            return -1;
        }
        
        while(D.v.elementAt(right) != null){    //judge the arrangement of the right board
            right = right * 2;
            //left = right / 2;
        }
        
        if(D.v.elementAt(right) == null){       // determine the right board, which equals to the NULL's left board
            while(left < right - 1){
                mid = left + (right - left)/2;
                if(D.v.elementAt(mid) != null){
                    left = mid;
                }else if(D.v.elementAt(mid) == null){
                    right = mid;
                }
            }
            if(D.v.elementAt(left) == null){
                right = left - 1;
            }else if(D.v.elementAt(right) == null){
                right = left;
            }
        }
        
        left = 0;
        if(a[right] < target){
            return -1;
        }
        while(left <= right){                           //judge whether the target is on the dictionary or not 
            mid = left + (right - left) / 2;
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
