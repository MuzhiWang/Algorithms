/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Epic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Muzhi
 */

/*	You are given a grid of numbers. A snake sequence is
 *	made up of adjacent numbers such that for each number,
 *	the number on the right or the number below it is +1 or -1
 *	its value. For example,
 *	1	3	2	6	8
 *	-9	7	1	-1	2
 *	1	5	0	1	9
 *	In this grid, (3,2,1,0,1) is a snake sequence;
 */

public class Snake {
    
    public void getSnake(int[][] matrix) {
        assert matrix != null && matrix.length != 0;
        int row = 0, column = 0;
        List<Integer> snake = new ArrayList<Integer>();
        getSnakeHelper(matrix, 0, 0, snake);
    }
    
    
    /// There are deplicated sequence occured, you can use boolean[][] flag to mark the path you visited.
    /// just like dp question.
    private void getSnakeHelper(int[][] matrix, int row, int column, List<Integer> snake) {
        if (row == matrix.length - 1 && column == matrix[0].length - 1) {
            if (snake.size() > 1)     
                System.out.print(Arrays.toString(snake.toArray()));
            return;
        } else if (row == matrix.length - 1 && Math.abs(matrix[row][column + 1] - matrix[row][column]) != 1) {
            if (snake.size() > 1) 
                System.out.println(Arrays.toString(snake.toArray()));
            return;
        } else if (column == matrix[0].length - 1 && Math.abs(matrix[row + 1][column] - matrix[row][column]) != 1) {
            if (snake.size() > 1) 
                System.out.println(Arrays.toString(snake.toArray()));
            return;
        }
        
        if (row + 1 < matrix.length && Math.abs(matrix[row + 1][column] - matrix[row][column]) == 1) {
            snake.add(matrix[row + 1][column]);
            getSnakeHelper(matrix, row + 1, column, snake);
            snake.remove(snake.size() - 1);
        } else if (row + 1 < matrix.length) {
            List<Integer> newSnake = new ArrayList<>();
            newSnake.add(matrix[row + 1][column]);
            getSnakeHelper(matrix, row + 1, column, newSnake);
        }
        if (column + 1 < matrix[0].length && Math.abs(matrix[row][column + 1] - matrix[row][column]) == 1) {
            snake.add(matrix[row][column + 1]);
            getSnakeHelper(matrix, row, column + 1, snake);
            snake.remove(snake.size() - 1);
        } else if (column + 1 < matrix[0].length) {
            List<Integer> newSnake = new ArrayList<>();
            newSnake.add(matrix[row][column + 1]);
            getSnakeHelper(matrix, row, column + 1, newSnake);
        }
        if (row + 1 < matrix.length && column + 1 < matrix[0].length && (Math.abs(matrix[row + 1][column] - matrix[row][column]) != 1 &&
                Math.abs(matrix[row][column + 1] - matrix[row][column]) != 1)) {
            if (snake.size() > 1) 
                System.out.println(Arrays.toString(snake.toArray()));
            List<Integer> newSnake = new ArrayList<>();
            newSnake.add(matrix[row + 1][column]);
            getSnakeHelper(matrix, row + 1, column, newSnake);
            newSnake.clear();
            newSnake.add(matrix[row][column + 1]);
            getSnakeHelper(matrix, row, column + 1, newSnake);
        }
    }
    
    public static void main(String[] args) {
        Snake s = new Snake();
        int[][] matrix = {{1, 3, 2, 6, 8}, {-9,	7, 1, -1, 2}, {1, 5, 0, 1, 9}};
        s.getSnake(matrix);
        
    }
    
}
