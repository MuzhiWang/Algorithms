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
public class TwoDArrayPrintInSpiral {
    
    public void twoDPrintInSpiral(int[][] array) {
        assert array != null;
        if (array.length == 1 || array.length == 0) {
            return;
        }
        int offset = 0;
        int length = array.length;
        twoDPringInSpiralHelper(array, offset, length);
        
    }

    private void twoDPringInSpiralHelper(int[][] array, int offset, int length) {
        if (length <= 0) {
            System.out.println();
            return;
        }
        
        for (int i = offset; i < offset + length; ++i) {
            System.out.print(array[offset][i] + " ");
        }
        for (int i = offset + 1; i < offset + length; ++i) {
            System.out.print(array[i][offset + length - 1] + " ");
        }
        for (int i = offset + length - 2; i > offset - 1; --i) {
            System.out.print(array[offset + length - 1][i] + " ");
        }
        for (int i = offset + length - 2; i > offset; --i) {
            System.out.print(array[i][offset] + " ");
        }
        
        twoDPringInSpiralHelper(array, offset + 1, length - 2);
        
    }
    
}
