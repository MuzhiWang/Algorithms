/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment22;

import java.util.Arrays;

/**
 *
 * @author Muzhi
 */
public class ComElementsInThreeArrays {
    /********* If the arrays are not sorted, maybe use hash could save time complexity ********/
    public int[] comElement(int[] array1, int[] array2, int[] array3) {
        assert array1 != null && array2 != null && array3 != null;
        Arrays.sort(array1);
        Arrays.sort(array2);
        Arrays.sort(array3);
        int index1 = 0, index2 = 0, index3 = 0, index4 = 0;
        int[] res = new int[Math.max((Math.max(array1.length, array2.length)), array3.length)];
        while (index1 < array1.length && index2 < array2.length && index3 < array3.length) {
            if (array1[index1] == array2[index2] && array2[index2] == array3[index3] ) {
                res[index4++] = array1[index1];
                ++index1;
                ++index2;
                ++index3;
            } else if (array1[index1] <= array2[index2] && array1[index1] <= array3[index3]) {
                ++index1;
            } else if (array2[index2] <= array3[index3] && array2[index2] <= array1[index1]) {
                ++index2;
            } else {
                ++index3;
            }
        }
        return Arrays.copyOf(res, index4);
        
    }
    
    public static void main(String[] args) {
        int[] a1 = {2,3,9,5,7,6,1,58};
        int[] a2 = {3,6,4,5,8,1,2,45,7};
        int[] a3 = {9,11,2,33,6,88,4,7,55,6};
        ComElementsInThreeArrays com = new ComElementsInThreeArrays();
        System.out.println(new String(Arrays.toString(com.comElement(a1, a2, a3))));
        
    }
    
}
