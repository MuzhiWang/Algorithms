/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assigment2;
import java.util.Vector;

/**
 *
 * @author Muzhi
 */
public class dictionary {
    
    public Vector<Integer> v = new Vector<Integer>(); 
    
    public Vector<Integer> dictionary(int[] a){
        //Vector<Integer> v = new Vector<Integer>(); 
        if(a == null){                          // if the array is null, return a null vector
            return null;
        }
        
        for(int i = 0; i < a.length; i++){      // add the array's elments into the vector with index
            v.add(i, a[i]);
        }
        
        int i = a.length;                       // judge the arrangement of the input array
        int j = 1;
        while(i > j){
            j*=2;
        }
        
        for(int k = 0; k < 2*j; k++){           // add NULL element into the rest of the vector
            v.add(null);
        }
        return v;
    }
}
