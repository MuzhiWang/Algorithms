/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheDataInCubator;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Muzhi
 */
public class SubwaySeats {
    
    public void subway(int N) {
        assert N > 2;
        int maxSeats = N / 2;
        int minSeats = N / 3;
        
        // seat[][]: seat[][0] num of seat occupied, seat[][1] combinations of that num of seats occupied.
        // 1: full seats in N
        double[][] seatOne = seatsCalculate(N);
        // 2: ******* X , with last seat occupied.
        double[][] seatTwo = seatsCalculate(N - 1);
        // 3. O ********, with first seat empty & full seats in N - 1.
        double[][] seatThree = seatsCalculate(N - 1);
        // 4. O ******** X, with first seat empty & last seat occupied.
        double[][] seatFour = seatsCalculate(N - 2);
        
        double mean = 0;
        int num = 0;
        for (int i = 0; i < seatOne.length; ++i) {
            if (seatOne[i][0] > 0) {
                num += seatOne[i][1];
                mean += seatOne[i][0] * seatOne[i][1];
            }
        }
        for (int i = 0; i < seatTwo.length; ++i) {
            if (seatTwo[i][0] > 0) {
                num += seatTwo[i][1];
                mean += (seatTwo[i][0] + 1) * seatTwo[i][1];
            }
        }
        for (int i = 0; i < seatThree.length; ++i) {
            if (seatThree[i][0] > 0) {
                num += seatThree[i][1];
                mean += seatThree[i][0] * seatThree[i][1];
            }
        }
        for (int i = 0; i < seatFour.length; ++i) {
            if (seatFour[i][0] > 0) {
                num += seatFour[i][1];
                mean += (seatFour[i][0] + 1) * seatFour[i][1];
            }
        }
        mean = mean / num;
        meanRes = mean;
        
        double sd = 0;
        for (int i = 0; i < seatOne.length; ++i) {
            if (seatOne[i][0] > 0) {
                sd = (seatOne[i][0] - mean) * (seatOne[i][0] - mean) * seatOne[i][1];
            }
        }
        for (int i = 0; i < seatTwo.length; ++i) {
            if (seatTwo[i][0] > 0) {
                sd = (seatTwo[i][0] + 1 - mean) * (seatTwo[i][0] + 1 - mean) * seatTwo[i][1];
            }
        }
        for (int i = 0; i < seatThree.length; ++i) {
            if (seatThree[i][0] > 0) {
                sd = (seatThree[i][0] - mean) * (seatThree[i][0] - mean) * seatThree[i][1];
            }
        }
        for (int i = 0; i < seatFour.length; ++i) {
            if (seatFour[i][0] > 0) {
                sd = (seatFour[i][0] + 1 - mean) * (seatFour[i][0] + 1 - mean) * seatFour[i][1];
            }
        }
        sd = Math.sqrt(sd / num);
        standardDeviationRes = sd;
        
    }
    
    private double[][] seatsCalculate(int n) {
        int maxSeats = n / 2;
        int minSeats = n / 3;
        //HashMap<Integer, Double> hashMap = new HashMap<>();
        double[][] res = new double[maxSeats - minSeats + 1][2];
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
    public double meanRes = 0;
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
        subwaySeat.subway(25);
        System.out.println("25 seats's mean num: " + subwaySeat.meanRes);
        System.out.println("25 seats's standard deviation: " + subwaySeat.standardDeviationRes);
        
        int num = 500;
        subwaySeat.subway(num);
        System.out.println(num + " seats's mean num: " + subwaySeat.meanRes);
        System.out.println(num + " seats's standard deviation: " + subwaySeat.standardDeviationRes);
        
        double test = subwaySeat.combination(6, 2);
        System.out.println(test);
    }
    
}

