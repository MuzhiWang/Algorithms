/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment6;

/**
 *
 * @author Muzhi
 */
public class CoinAssignment {
    
    private int targetNum;
    public void coinAssignment(int[] coinCategory, int target) {
        assert coinCategory != null && target > 0;
        
        this.targetNum = target;
        int size = coinCategory.length;
        int[] coinNumber = new int[size];
        for (int i : coinNumber) {
            coinNumber[i] = 0;
        } 
        int coinIndex = 0;
        coinAssignmentHelper(coinCategory, target, coinNumber, 0);
        
        
    }

    private void coinAssignmentHelper(int[] coinCategory, int target, int[] coinNumber, int coinIndex) {
        int sum = 0;
        for (int i = 0; i < coinCategory.length; i++) {
            sum += coinCategory[i] * coinNumber[i];
        }
        if (sum == this.targetNum) {
            printCoinResult(coinCategory, coinNumber);
            System.out.println();
            return;
        }
        
        if (target / coinCategory[coinIndex]> 0) {                              // in this methodOne i just use target to pass the left value of target
            target -= coinCategory[coinIndex];
            coinNumber[coinIndex]++;
            coinAssignmentHelper(coinCategory, target, coinNumber, coinIndex);
            target = target + coinCategory[coinIndex];
            coinNumber[coinIndex]--;
        } 
        if (coinIndex < coinCategory.length - 1) {
            coinAssignmentHelper(coinCategory, target, coinNumber, coinIndex + 1);
        }
        
        
        /*
        int targetNow = this.targetNum;                                         // in this methodTwo i directrly calculate the left value of target
        for (int i = 0; i < coinCategory.length; i++) {                         // i am confused that the target value in methodOne seems to be different form methodTwo?
            targetNow -= coinCategory[i] * coinNumber[i];
        }
        if (targetNow / coinCategory[coinIndex]> 0) {
            //target -= coinCategory[coinIndex];
            coinNumber[coinIndex]++;
            coinAssignmentHelper(coinCategory, target, coinNumber, coinIndex);
            //target = target + coinNumber[coinIndex];
            coinNumber[coinIndex]--;
        } 
        if (coinIndex < coinCategory.length - 1) {
            coinAssignmentHelper(coinCategory, target, coinNumber, coinIndex + 1);
        }
        */        
        
    }
    
    private void printCoinResult(int[] coinCategory, int[] coinNumber) {
        for (int index = 0; index < coinCategory.length; index++) {
            System.out.println("The coin " + coinCategory[index] + " 's number is " + coinNumber[index]);
        }
    }
    
}
