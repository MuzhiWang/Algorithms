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
public class ComElementsInTwoArrays {
    public int[] comElements(int[] array1, int[] array2) {
        assert array1 != null && array2 != null && array1.length != 0 && array2.length != 0;
        Arrays.sort(array1);
        Arrays.sort(array2);
        int point1 = 0, point2 = 0, point3 = 0;
        int[] res = new int[Math.max(array1.length, array2.length)];
        while (point1 < array1.length && point2 < array2.length) {
            if (array1[point1] < array2[point2]) {
                point1++;
            } else if (array1[point1] > array2[point2]) {
                point2++;
            } else {
                res[point3] = array1[point1];
                point1++;
                point2++;
                point3++;
            }
        }
        return Arrays.copyOf(res, point3);        
    }
    
    public static void main(String[] args) {
        int[] a1 = {2,0,9,6,11,15};
        int[] a2 = {9,2,15,6,19,27};
        ComElementsInTwoArrays comE = new ComElementsInTwoArrays();
        System.out.println(new String(Arrays.toString(comE.comElements(a1, a2))));
        
    }
    
}
