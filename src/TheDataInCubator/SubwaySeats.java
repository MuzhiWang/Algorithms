/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheDataInCubator;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Muzhi
 */
public class SubwaySeats {
    
    public void subway(int N) {
        assert N > 0;
        int maxSeats = N / 2;
        int minSeats = N / 3;
        
        for (int i = minSeats; i < maxSeats; ++i) {
            
        }
        
    }
    
    private double[][] seatsCalculate(int n) {
        int maxSeats = n / 2;
        int minSeats = n / 3;
        HashMap<Integer, Double> hashMap = new HashMap<>();
        double[][] res = new double[maxSeats - minSeats][2];
        for (int i = minSeats; i <= maxSeats; ++i) {
            for (int j = 0; j <= i; ++j) {
                if (j * 2 + (i - j) * 3 == n) {
                    double comNum = combination(n, j);
                    res[i - minSeats][0] = i;
                    res[i - minSeats][1] = comNum;
                }
            }
        }
        return res;
    }
    
    private double combination(int total, int com) {
        double res = 1;
        while (com > 0) {
            res = res * total / com;
            total--;
            com--;
        }
        return res;
    }
    
    
    
    
    
    /*******  Recursion method, but memory overflowed when N > 50  ********/
    public int meanRes = 0;
    public double standardDeviationRes = 0;
    public void subwaySeats(int N) {
        assert N >= 1;
        meanRes = 0;
        standardDeviationRes = 0;
        List<Integer> seatsRes1 = new LinkedList<>();
        List<Integer> seatsRes2 = new LinkedList<>();
        seatsCalculate(N, 1, seatsRes1);
        seatsCalculate(N - 1, 1, seatsRes2);
        seatsRes1.addAll(seatsRes2);
        meanRes = meanNum(seatsRes1);
        standardDeviationRes = standardDeviation(seatsRes1);
    }
    
    private void seatsCalculate(int n, int seatNum, List<Integer> res) {
        if (n == 1) {
            res.add(seatNum + 1);
            return;
        }
        if (n <= 0) {
            res.add(seatNum);
            return;
        }
        seatsCalculate(n - 2, seatNum + 1, res);
        seatsCalculate(n - 3, seatNum + 1, res);
    }
    
    private int meanNum(List<Integer> res) {
        int num = res.size();
        int meanN = 0;
        for (int i : res) 
            meanN += i;
        return meanN / num;
    }
    
    private double standardDeviation(List<Integer> res) {
        int mean = meanNum(res);
        int SD = 0;
        int num = res.size();
        for (int i : res)
            SD += (i - mean) * (i - mean);
        return Math.sqrt((double)SD / num);
    }
    
    public static void main(String[] args) {
        SubwaySeats subwaySeat = new SubwaySeats();
        subwaySeat.subwaySeats(25);
        System.out.println("25 seats's mean num: " + subwaySeat.meanRes);
        System.out.println("25 seats's standard deviation: " + subwaySeat.standardDeviationRes);
        
        subwaySeat.subwaySeats(50);
        System.out.println("50000 seats's mean num: " + subwaySeat.meanRes);
        System.out.println("50000 seats's standard deviation: " + subwaySeat.standardDeviationRes);
        
    }
    
}

