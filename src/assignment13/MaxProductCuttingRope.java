/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment13;

/**
 *
 * @author Muzhi
 */
public class MaxProductCuttingRope {
    
    /******************** Iteration Method *****************/
    public int maxProductCuttingIteration(int target, int cutNum) {
        assert target > 0;
        if (cutNum == 0) {
            return target;
        }
        
        int[][] dp = new int[target][cutNum];
        //dp[][0] = target;
        for (int i = 1; i < target + 1; i++) {
            dp[i - 1][0] = i;
        }
        int newTarget = 1;
        int maxTarget = 0;
        for (int i = 1; i < cutNum; ++i) {
            //dp[newTarget][i] = 0; 
            for (int j = 1; j < target; ++j) {
                maxTarget = 0;
                for (int k = 1; k < j; ++k) {
                    if (dp[j - k][i - 1] * k > dp[j][i]) {
                        dp[j][i] = dp[j - k][i - 1] * k;
                        //maxTarget = newTarget - j;
                    }
                }
            }
        }
        return dp[target - 1][cutNum - 1];
        
    }
    
    
    /******* This Recursion Method's result seems not right, still need to check it **********/
    public int maxProductCuttingMethod(int target, int cutNum) {
        assert target > 0;
        if (cutNum == 0) {
            return target;
        }
        int[][] dp = new int[target][cutNum];
        int result = 0;
        result = maxProductCuttingHelper(target, cutNum);
        return result;
        
    }
    
    private int maxProductCuttingHelper(int target, int cutNum) {
        if (cutNum == 0) {
            return 1;
        }
        int curMax = 0;
        for (int i = 1; i < target; i++) {
             curMax = max(curMax , i * maxProductCuttingHelper((target - i), cutNum - 1));
        }
        return curMax;
        
    }
    
    private int max(int numOne, int numTwo) {
        if (numOne >= numTwo) {
            return numOne;
        }
        return numTwo;
    }
    
}
