/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leetcode;

/**
 *
 * @author Muzhi
 */
public class StockTransactions {
    /********  Wrong solution, DP solution. dp[k][d] = max{max{dp[k - 1][i] - price[i] + price[d]}, dp[k][d - 1]} **************/
    public int transactionWithKthTime(int[] price, int k) {
        if (price == null || price.length == 0 || k == 0) return 0;
        int dp[][] = new int[k + 1][price.length];
        int max = Integer.MIN_VALUE, profit = Integer.MIN_VALUE;
        for (int kth = 1; kth < k + 1; ++kth) {
            for (int day = 1; day < price.length; ++day) {
                max = Integer.MIN_VALUE;
                for (int i = 1; i < day; ++i) {
                    max = Math.max(max, dp[kth - 1][i] + price[day] - price[i]);
                }
                dp[kth][day] = Math.max(max, dp[kth][day - 1]);
                profit = Math.max(profit, dp[kth][day]);
            }
        }
        return profit;
    }
    
    public static void main(String[] args) {
        int[] p = {1,4,2,9};
        int k = 3;
        StockTransactions s = new StockTransactions();
        System.out.println(s.transactionWithKthTime(p, k));
//        String t = "2001/20/20";
//        System.out.println(t.split("/")[0] );
//        t = "";
//        System.out.println(t.isEmpty() + " " + t.length());
    }
}
