/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Epic;

import java.util.Arrays;

/**
 *
 * @author Muzhi
 */

/*	Write a program to display the advised average for the list of 
 *	numbers omitting the largest three number in the series.
 *	e.g. 3,6,12,55,289, 600, 534, 900, 172, 
 *	avg = (3+6+12+55+289+172)/6 and eliminating 534, 900, 600;
 */

public class AdvisedAverage {
    public float average(int[] array) {
        assert array != null && array.length > 0;
        if (array.length <= 3)
            return 0;
        Arrays.sort(array);
        int sum = 0;
        for (int i = 0; i < array.length - 3; ++i) {
            sum += array[i];
        }
        return (float)sum / (array.length - 3);
    }
    
    public static void main(String... args) {
        AdvisedAverage aa = new AdvisedAverage();
        int[] input = {1, 2, 3, 4, 5, 6, 9, 10, 11};
        System.out.println(aa.average(input));
    }
} 
