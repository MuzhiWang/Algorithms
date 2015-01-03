/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicProgramming;

import java.util.Arrays;

/**
 *
 * @author Muzhi
 */
public class Priyanka_Toys {
    public int priyankaToys(int k, int[] weight) {
        assert k > 0;
        int costs = 1;
        Arrays.sort(weight);
        for (int i = 0; i < weight.length; ++i) {
            int j = i;
            while (j < weight.length && weight[j] <= weight[i] + 4) ++j;
            ++costs;
            i = j;
        }
        return costs;
    }
    
    public static void main(String[] args) {
        int k = 11;
        int[] w = {1, 1, 1, 2, 3, 4, 5, 6, 8, 10, 12};
        Priyanka_Toys pt = new Priyanka_Toys();
        System.out.println(pt.priyankaToys(k, w));
    }
}
