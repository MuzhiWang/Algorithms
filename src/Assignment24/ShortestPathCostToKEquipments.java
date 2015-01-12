/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment24;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Muzhi
 */
public class ShortestPathCostToKEquipments {
    public List<Integer> shortestPath(char[][] gym) {
        if (gym == null) return null;
        //int[][] cost = new int[gym.length][gym[0].length];
        List<int[][]> costList = new LinkedList<>();
        for (int i = 0; i < gym.length; i++) {
            for (int j = 0; j < gym[0].length; j++) {
                if (gym[i][j] == 'E') {
                    int[][] cost = new int[gym.length][gym[0].length];
                    
                }
                
            }
            
        }
    }
    
    private void dijkstraCost(char[][] gym, int[][] cost, int row, int column) {
        Deque<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row, column, gym[row][column])); 
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            if (cur.row + 1 < gym.length) {
                queue.add(new Pair(cur.row + 1, cur.column, gym[cur.row + 1][cur.column]));
            }
            if (cur.row - 1 >= 0) {
                queue.add(new Pair(cur.row - 1, cur.column, gym[cur.row - 1][cur.column]));
            }
            if (cur.column + 1 < gym[0].length) {
                queue.add(new Pair(cur.row, cur.column + 1, gym[cur.row][cur.column + 1]));
            }
            
        }
        
    }
    
    public static class Pair {
        int row, column;
        char chair;
        public Pair(int row, int column, char chair) {
            this.row = row;
            this.column = column;
            this.chair = chair;
        }
    }
    
}
