/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Epic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Muzhi
 */

/*	Two dimensional array representation of an image can also be
 *	represented by a one-dimensional array of W*H size, where
 *	W represent row and H represent column size and each cell 
 *	represent pixel value of that image. You are also given a 
 *	threshold value X. For edge detection, you have to compute
 *	difference of a pixel value with each of its adjacent pixel
 *	and find maximum of all differences. And finally compare if
 *	that maximum difference greater than threshold X. If so, then
 *	that pixel is a edge pixel and have to display it. 
 */


public class EdgeDetection {
    
    public void detectEdgePixel(int[][] matrix, int X) {
        assert matrix == null && matrix.length != 0;
        int W = matrix.length;
        int H = matrix[0].length;
        
        for (int i = 0; i < W; ++i) {
            for (int j = 0; j < H; ++j) {
                List<Integer> pixels = new ArrayList<>();
                if (i - 1 > 0)
                    pixels.add(matrix[i - 1][j]);
                if (i + 1 < W)
                    pixels.add(matrix[i + 1][j]);
                if (j - 1 > 0) 
                    pixels.add(matrix[i][j - 1]);
                if (j + 1 < H)
                    pixels.add(matrix[i][j + 1]);
                
                if (maxDiff(pixels, matrix[i][j]) > X)
                    System.out.println("Row: " + (i + 1) + " Colume: " + (j + 1) + " is: " + matrix[i][j]);
            }
        }
    }
    
    private int maxDiff(List<Integer> pixels, int detectPixel) {
        Collections.sort(pixels);
        return Math.max(Math.abs(detectPixel - pixels.get(0)), Math.abs(detectPixel - pixels.get(pixels.size() - 1)));
    }
    
    private void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; ++i) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
    
    public static void main(String... args) {
        EdgeDetection ed = new EdgeDetection();
        int[][] matrix = {{1, 5, 2, 6}, {2, 3, 8, 4}, {5, 3, 1, 2}};
        ed.printMatrix(matrix);
        System.out.println();
        ed.detectEdgePixel(matrix, 5);
    
    }
    
}
