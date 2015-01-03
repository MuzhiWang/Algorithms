/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment19;

/**
 *
 * @author Muzhi
 */
public class CutTimber {
    
    public int cutTimber(int timber, int[] cuts) {
        assert timber > 0;
        int num = cuts.length;
        if (timber == 1) return 1;
        if (num == 1) return timber;
        
        int[] cutsHelper = new int[num + 2];
        int[][] dp = new int[num + 2][num + 2];
        cutsHelper[0] = 0;
        cutsHelper[num + 1] = timber;
        for (int i = 0; i < num; ++i) {
            cutsHelper[i + 1] = cuts[i];
        }
        int min, temp;
        for(int i = 1; i < num + 2; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                min = Integer.MAX_VALUE;
                for (int k = j + 1; k < i; ++k) {
                    min = Math.min(min, dp[j][k] + dp[k][i] + cutsHelper[i] - cutsHelper[j]);
                }
                dp[j][i] = (min == Integer.MAX_VALUE) ? 0 : min;
            }
        }
        return dp[0][num + 1];
    }
    
    public static void main(String[] args) {
        int timberLen = 10;
        CutTimber cutTimber = new CutTimber();
        int[] cuts = {3, 5, 7, 8};
        System.out.println(cutTimber.cutTimber(timberLen, cuts));   
    }
}
