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
public class Assignment13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LongestAscendingSubsquence longAscSubsqu = new LongestAscendingSubsquence();
        int[] array = {1,2,4,3,7,6,4,5};
        int result1 = longAscSubsqu.longestAscSubsqen(array);
        //int result1 = longAscSubsqu.longestAscSubsquence(array);
        int result2 = longAscSubsqu.longestAscSubsquenceTwo(array);
        System.out.print("The longest Ascending Subsquence number result One is: ");
        System.out.println(result1);
        System.out.print("The longest Ascending Subsquence number result One is: ");
        System.out.println(result2);
        
        MaxProductCuttingRope maxCut = new MaxProductCuttingRope();
        int target = 12;
        int cutNum = 5;
        int result3 = maxCut.maxProductCuttingMethod(target, cutNum);
        int result4 = maxCut.maxProductCuttingIteration(target, cutNum);
        System.out.print("The max product of cutting rope by Resurion is: ");
        System.out.println(result3);
        System.out.print("The max product of cutting rope by iteration is: ");
        System.out.println(result4);
        
        
    }
    
}
