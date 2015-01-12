/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment24;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

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
                    for (int k = 0; k < gym.length; ++k)
                        Arrays.fill(cost[k], Integer.MAX_VALUE);
                    cost[i][j] = 0;
                    dijkstraCost(gym, cost, i, j);
                    costList.add(cost);
                }
            }
        }
        int[][] sumCost = new int[gym.length][gym[0].length];
        for (int[][] cost : costList) {
            for (int i = 0; i < cost.length; i++) {
                for (int j = 0; j < cost[0].length; j++) {
                    sumCost[i][j] += cost[i][j];
                }
            }
        }
        int minCost = Integer.MAX_VALUE;
        List<Integer> res = new LinkedList<>();
        res.add(-1);
        res.add(-1);
        for (int i = 0; i < gym.length; ++i) {
            for (int j = 0; j < gym[0].length; ++j) {
                if (gym[i][j] != 'E' && gym[i][j] != 'O' && minCost > sumCost[i][j]) {
                    minCost = sumCost[i][j];
                    res.set(0, i);
                    res.set(1, j);
                }
            }
        }
        return res;
    }
    
    
    private void dijkstraCost(char[][] gym, int[][] cost, int row, int column) {
        Deque<Pair> queue = new LinkedList<>();
        boolean[][] visited = new boolean[gym.length][gym[0].length];
        queue.add(new Pair(row, column, gym[row][column])); 
        visited[row][column] = true;
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            if (cur.row + 1 < gym.length && gym[cur.row + 1][cur.column] != 'O' && gym[cur.row + 1][cur.column] != 'E' && !visited[cur.row + 1][cur.column]) {
                queue.add(new Pair(cur.row + 1, cur.column, gym[cur.row + 1][cur.column]));
                visited[cur.row + 1][cur.column] = true;
                cost[cur.row + 1][cur.column] = cost[cur.row][cur.column] + 1;
            } else if (cur.row + 1 < gym.length && gym[cur.row + 1][cur.column] != 'O' && gym[cur.row + 1][cur.column] != 'E' && cost[cur.row + 1][cur.column] > cost[cur.row][cur.column] + 1) {
                cost[cur.row + 1][cur.column] = cost[cur.row][cur.column] + 1;
            }
            if (cur.row - 1 >= 0 && gym[cur.row - 1][cur.column] != 'O' && gym[cur.row - 1][cur.column] != 'E' && !visited[cur.row - 1][cur.column]) {
                queue.add(new Pair(cur.row - 1, cur.column, gym[cur.row - 1][cur.column]));
                visited[cur.row - 1][cur.column] = true;
                cost[cur.row - 1][cur.column] = cost[cur.row][cur.column] + 1;
            } else if (cur.row - 1 >= 0 && gym[cur.row - 1][cur.column] != 'O' && gym[cur.row - 1][cur.column] != 'E' && cost[cur.row - 1][cur.column] > cost[cur.row][cur.column] + 1) {
                cost[cur.row - 1][cur.column] = cost[cur.row][cur.column] + 1;
            }
            if (cur.column + 1 < gym[0].length && gym[cur.row][cur.column + 1] != 'O' && gym[cur.row][cur.column + 1] != 'E' && visited[cur.row][cur.column + 1]) {
                queue.add(new Pair(cur.row, cur.column + 1, gym[cur.row][cur.column + 1]));
                visited[cur.row][cur.column + 1] = true;
                cost[cur.row][cur.column + 1] = cost[cur.row][cur.column] + 1;
            } else if (cur.column + 1 < gym[0].length && gym[cur.row][cur.column + 1] != 'O' && gym[cur.row][cur.column + 1] != 'E' && cost[cur.row][cur.column + 1] > cost[cur.row][cur.column] + 1) {
                cost[cur.row][cur.column + 1] = cost[cur.row][cur.column] + 1;
            }
            if (cur.column - 1 >= 0 && gym[cur.row][cur.column - 1] != 'O' && gym[cur.row][cur.column - 1] != 'E' && !visited[cur.row][cur.column - 1]) {
                queue.add(new Pair(cur.row, cur.column - 1, gym[cur.row][cur.column - 1]));
                visited[cur.row][cur.column - 1] = true;
                cost[cur.row][cur.column - 1] = cost[cur.row][cur.column] + 1;
            } else if (cur.column - 1 >= 0 && gym[cur.row][cur.column - 1] != 'O' && gym[cur.row][cur.column - 1] != 'E' && cost[cur.row][cur.column - 1] > cost[cur.row][cur.column] + 1) {
                cost[cur.row][cur.column - 1] = cost[cur.row][cur.column] + 1;
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
    
    public static void main(String[] args) {
        ShortestPathCostToKEquipments s = new ShortestPathCostToKEquipments();
        char[][] gym = {{'X', 'X', 'O', 'E'}, {'X', 'X', 'X', 'X'}, {'X', 'O', 'E', 'X'}, {'E', 'O', 'X', 'X'}};
        for (int i = 0; i < gym.length; ++i) {
            for (int j = 0; j < gym[0].length; ++j) {
                System.out.print(gym[i][j] + " ");
            }
            System.out.println();
        }
        List<Integer> res = s.shortestPath(gym);
        System.out.println(Objects.toString(res));
        
    }
    
}
