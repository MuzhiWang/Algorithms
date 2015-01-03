/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment23;

import java.util.Arrays;

/**
 *
 * @author Muzhi
 */
public class Coin99cents {
    public int[] centsAssign(int[] coin, int target) {
        int size = coin.length;
        int leftCoin = target;
        int[] coinNum = new int[size];
        centsAssignHelper(target, coin, coinNum, target, 0);
        return coin;
        
    }
    
    public void centsAssignHelper(int target, int[] coin, int[] coinNum, int leftCoin, int layer) {
        //if (leftCoin < 0) return; 
        if (leftCoin == 0) {
            String result = Arrays.toString(coinNum);
            System.out.println(result);
            return;
        }
        if (layer == 3 && leftCoin > 0) {
            coinNum[layer] = leftCoin;
            String result = Arrays.toString(coinNum);
            System.out.println(result);
            return;
        }
        
        for (int i = 0; leftCoin >= 0; ++i) {
            coinNum[layer] = i;
            centsAssignHelper(target, coin, coinNum, leftCoin, layer + 1);
            coinNum[layer + 1] = 0;
            //if (leftCoin == 0) break; 
            leftCoin -= coin[layer];
            //if (leftCoin == 0) coinNum[layer]++; return; 
        }
    }
    
    public static void main(String[] args) {
        int[] coin = {25,10,5,1};
        Coin99cents coinAssign = new Coin99cents();
        coinAssign.centsAssign(coin, 100);
    }
}
