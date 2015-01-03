/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midterm2;

/**
 *
 * @author Muzhi
 */
public class MinCutsOfSubstring {
    /******* Be aware of this dp represents, and m[i] represents *******/
    public int minCuts(String str) {
        if (str.length() == 0 || str.length() == 1) return 0;
        int len = str.length();
        char[] charStr = str.toCharArray();
        int[][] dp = new int[len][len];
        int[] cuts = new int[len + 1];
        for (int i = 0; i < len - 1; ++i) {
            dp[i + 1][i + 1] = 1;
            dp[i][i + 1] = (charStr[i] == charStr[i + 1]) ? 1 : 0;
            cuts[i + 2] = i + 1; 
        }
        int min;
        for (int i = 0; i < len; ++i) {
            for (int j = i; j >= 0; --j) {
                min = Integer.MAX_VALUE;
                if ((i - j > 1) && charStr[i] == charStr[j] && dp[j + 1][i - 1] == 1) {
                    dp[j][i] = 1;
                    cuts[i + 1] = Math.min(cuts[i + 1], cuts[j] + 1);
                } else if ((i - j) < 2 && dp[j][i] == 1) {
                    cuts[i + 1] = Math.min(cuts[i + 1], cuts[j] + 1);
                }
            }
        }
        return cuts[len];
    }
    
    /******   Teacher's Method two  **********/
    public int minCuts2(String input) {
		assert input != null;
		if (input.isEmpty()) {
			return 0;
		}
		char[] array = input.toCharArray();
		boolean[][] isPa = new boolean[array.length + 1][array.length + 1];
		int[] minCut = new int[array.length + 1];
		for (int i = 0; i < minCut.length; i++) {
			minCut[i] = i;
		}
		for (int end = 1; end <= array.length; end++) {
			for (int start = end; start >= 1; start--) {
				if (start == end || start + 1 == end) {
					isPa[start][end] = array[start - 1] == array[end - 1];
				} else if (array[start - 1] == array[end - 1]) {
					isPa[start][end] = isPa[start + 1][end - 1];
				}
				if (isPa[start][end]) {
					minCut[end] = Math.min(minCut[end], 1 + minCut[start - 1]);
				}
			}
		}
		return minCut[array.length] - 1;
    }
    
    public static void main(String[] args) {
        String str = "aabbaccaababba";
        MinCutsOfSubstring minCuts = new MinCutsOfSubstring();
        System.out.println(minCuts.minCuts(str));
        System.out.println(minCuts.minCuts2(str));
        
    }
    
}
