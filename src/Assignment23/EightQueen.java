/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment23;
import myTools.PrintMatrix;

/**
 *
 * @author Muzhi
 */
public class EightQueen {
    private PrintMatrix p = new PrintMatrix();
    public int counter = 0, counter2 = 0;
    public void eightQueue(int[][] matrix) {
        assert matrix.length > 1;
        eightQueueHelper(matrix, 0, 0);
    }
    
    private void eightQueueHelper(int[][] matrix, int layer, int index) {
        if (layer == matrix.length) {
            this.p.print(matrix);
            ++counter;
            return;
        }
        
        if (layer == 0) {
            for (int i = 0; i < matrix.length; ++i) {
                matrix[0][i] = 1;
                eightQueueHelper(matrix, layer + 1, i);
                matrix[0][i] = 0;
            }
        } else {
            for (int i = 0; i < matrix.length; ++i) {
                if (check(layer, i, matrix)) {
                    matrix[layer][i] = 1;
                    eightQueueHelper(matrix, layer + 1, i);
                    matrix[layer][i] = 0;
                }
            }
        }
    }
    
    private boolean check(int layer, int index, int[][] matrix) {
        for (int i = 0; i < layer; ++i) {
            for (int j = 0; j < matrix.length; ++j) {
                if (matrix[i][j] == 1) {
                    if (j == index) {
                        return false;
                    } else {
                        int left = j, right = j, botton = i;
                        while (left >= 0 && botton < layer) {
                            --left;
                            ++botton;
                        }
                        if (left == index) return false;
                        botton = i;
                        while (right < matrix.length && botton < layer) {
                            ++right;
                            ++botton;
                        }
                        if (right == index) return false; 
                    }
                } 
            } 
        }
        return true;
    }
    
    
    /*********** Method two, use shift and DFS *************/
    private void dfs(int d, int[] ans, int dl, int row, int dr) {
        if (d == ans.length) {
            for (int i = 0; i < ans.length; ++i) {
                for (int j = 0; j < ans.length; ++j)
                    System.out.print(((j == ans[i]) ? "1 " : "0 "));
                System.out.println();
            }
            ++counter2;
            System.out.println();
            return;
        }
        int now = dl | row | dr;
        for (int i = 0; i < ans.length; ++i) {
            if ((now & (1 << i)) == 0) {
                ans[d] = i;
                dfs(d + 1, ans, (dl | (1 << i)) >> 1, row | (1 << i), (dr | (1 << i)) << 1);
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] matrix = new int[8][8];
        EightQueen queen = new EightQueen();
        queen.eightQueue(matrix);
        int[] ans = new int[8];
        queen.dfs(0, ans, 0, 0, 0);
        System.out.println();
        System.out.println(queen.counter + " " + queen.counter2);
    }
    
}
