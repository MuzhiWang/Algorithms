/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Epic;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * @author Muzhi
 */

/*	Given a array, construct a triangle;
*
*	Example:
*	input {4,7,3,6,7};
*	output
*	{81}
*	{40,41}
*	{21,19,22}
*	{11,10,9,13}
*	{4,7,3,6,7}
*/

public class ArrayIntoTriangle {
    public void triangle(int[] array) {
        assert array == null && array.length > 0;
        int[] out = array;
        Deque<int[]> stack = new LinkedList<>();
        while (out.length > 0) {
            //System.out.println(Arrays.toString(out));
            stack.offerFirst(out);
            int[] temp = new int[out.length - 1];
            for (int i = 0; i < temp.length; ++i) {
                temp[i] = out[i] + out[i + 1];
            }
            out = temp;
        }
        while (!stack.isEmpty()) {
            System.out.println(Arrays.toString(stack.poll()));
        }
    }
    
    public static void main(String... args) {
        ArrayIntoTriangle triangle = new ArrayIntoTriangle();
        triangle.triangle(new int[]{4, 7, 3, 6, 7});
    }
    
}
