/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment17;

/**
 *
 * @author Muzhi
 */
public class RotateMatrix {
    
    private int length;
    public int[][] rotateMatrix(int[][] matrix) {
        assert matrix != null;
        if (matrix.length == 1) {
            return matrix;
        }
        
        this.length = matrix.length;
        int[][] outMatrix = new int[matrix.length][matrix.length]; 
        rotateHelper(matrix, outMatrix, matrix.length, 0);
        return outMatrix;
        
    }
    
    private void rotateHelper(int[][] matrix, int[][] outMatrix, int length, int offset) {
        if (length == 0) {
            return;
        } else if (length == 1) {
            outMatrix[offset][offset] = matrix[offset][offset];
            return;
        }
        
        for (int i = offset; i < offset + length; ++i) {
            outMatrix[i][this.length - 1 - offset] = matrix[offset][i];
        }
        for (int i = offset + 1; i < offset + length; ++i) {
            outMatrix[this.length - 1 - offset][this.length - 1 - i] = matrix[i][this.length - 1 - offset];
        }
        for (int i = offset + 1; i < offset + length; ++i) {
            outMatrix[this.length - 1 - i][offset] = matrix[this.length - 1 - offset][this.length - 1 - i];
        }
        for (int i = offset + 1; i < offset + length - 1; ++i) {
            outMatrix[offset][i] = matrix[this.length - 1 - i][offset];
        }
        
        rotateHelper(matrix, outMatrix, length - 2, offset + 1);
        
    }
    
}
