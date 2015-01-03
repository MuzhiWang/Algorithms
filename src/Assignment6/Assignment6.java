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
public class Assignment6 {
    //CommonNumber

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PrintSubsetOfSet subSet = new PrintSubsetOfSet();
        String set = "abc";
        //subSet.subSet(set);
        subSet.printSubset(set);
        
        PrintValidParentheses validPar = new PrintValidParentheses();
        int k = 3;
        validPar.printValidParentheses(k);
        
        CoinAssignment coin = new CoinAssignment();
        System.out.println("The coin assignment is: ");
        int[] coinCategory = {5, 2, 1};
        int target = 10;
        coin.coinAssignment(coinCategory, target);
        
        TopKFrequent topK = new TopKFrequent();
        String strTopK = "aaajjjdklssaidowpllaskdlafdsajeqiopdsafgddg";
        int intTopK = 4;
        char[] resultTopK = new char[intTopK];
        resultTopK = topK.topKFrequent(strTopK, intTopK);
        System.out.println("The top K frequency charactors are: ");
        for (int i = 0; i < intTopK; ++i) {
            System.out.print(resultTopK[i] + " ");
        }
        System.out.println();
        
        MissingNumber missNum = new MissingNumber();
        int[] missArray = {1,6,4,3,2};
        System.out.println("The missing number is: ");
        System.out.println(missNum.missNumber(missArray));
        
    }
    
}
