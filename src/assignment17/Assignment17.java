/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment17;

import assignment17.BreathFistPrintTree.Tree;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Muzhi
 */
public class Assignment17 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayDuplicateOnlyOneLeft arrayOne = new ArrayDuplicateOnlyOneLeft();
        int[] array = {1,2,2,2,3,3,3,6,6,7,7,7,8};
        System.out.println("Only one left element of array duplication: ");
        int[] result1 = arrayOne.arrayDuplicateOneLeft(array);
        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i] + " ");
        }
        System.out.println();
        
        ArrayDuplicateOnlyTwoLeft arrayTwo = new ArrayDuplicateOnlyTwoLeft();
        int[] array2 = {0,0,0,1,2,2,2,3,3,3,6,6,7,7,7,8};
        System.out.println("Only two left element of array duplication: ");
        int[] result2 = arrayTwo.arrayDupicateTwoLeft(array2);
        for (int i = 0; i < result2.length; ++i) {
            System.out.print(result2[i] + " ");
        }
        System.out.println();
        
        ArrayDuplicateNoneLeft arrayNone = new ArrayDuplicateNoneLeft();
        int[] array3 = {1,2,2,2,3,4,4,5,6,6,6,6};
        System.out.println("None duplicate element of this array: ");
        int[] result3 = arrayNone.arrayDeplicateNone(array3);
        int[] result4 = arrayNone.arrayDeplicateNoneMethodTwo(array3);
        for (int i = 0; i < result3.length; ++i) {
            System.out.print(result3[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < result4.length; ++i) {
            System.out.print(result4[i] + " ");
        }
        System.out.println();
        
        UnsortedArrayDuplicateRepeatedly unsortedArray =  new UnsortedArrayDuplicateRepeatedly();
        int[] array4 = {5,6,6,6,7,8,8,7,9,9,5,4};
        System.out.println("The unsorted array, after deduplication repeatedly are: ");
        int[] result5 = unsortedArray.unsortedArrayDuplicateRepeatedly(array4);
        for (int i = 0; i < result5.length; ++i) {
            System.out.print(result5[i] + " ");
        }
        System.out.println();
        
        ArrayNumberComLarSma arrayComLarSma = new ArrayNumberComLarSma();
        int[] array5 = {5,6,8,9,3,4,2,7};
        int[] result6 = arrayComLarSma.arrayNumberComLarSma(array5);
        System.out.println("The lagest and smallest number of array are: ");
        System.out.print("Largest number is: " + result6[0] + "  ");
        System.out.println("Smallest number is: " + result6[1]);
        
        ArrayCompareTopTwoLargestNum topTwoLarNum = new ArrayCompareTopTwoLargestNum();
        int[] array6 = {2,3,9,7,5,6,1,8,4,11};
        int[] result7 = topTwoLarNum.arrayComTopTwoLarNum(array6);
        System.out.println("The top two largest num of array is: ");
        System.out.print("Largest number is: " + result7[0] + "   ");
        System.out.println("Second largest number is: " + result7[1]);
        
        TwoDArrayPrintInSpiral twoDSpiral = new TwoDArrayPrintInSpiral();
        int[][] array7 = {{1,2,3,4,5},{16,17,18,19,6},{15,24,25,20,7},{14,23,22,21,8},{13,12,11,10,9}};
        int[][] array8 = {{1,2,3,4}, {12,13,14,5}, {11,16,15,6}, {10,9,8,7}};
        twoDSpiral.twoDPrintInSpiral(array7);
        twoDSpiral.twoDPrintInSpiral(array8);
        //System.out.println();
        
        RotateMatrix rotateMatrix = new RotateMatrix();
        int[][] matrix2 = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        int[][] matrix3 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] result9 = rotateMatrix.rotateMatrix(matrix3);
        int[][] result8 = rotateMatrix.rotateMatrix(matrix2);
        System.out.println("After rotation the matrix is: ");
        for (int i = 0; i < result8.length; ++i ) {
            for (int j = 0; j < result8.length; ++j) {
                System.out.print(result8[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < result9.length; ++i ) {
            for (int j = 0; j < result9.length; ++j) {
                System.out.print(result9[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        
        BreathFistPrintTree BFSPrint = new BreathFistPrintTree();
        Tree tree15 = new Tree(null, null, 15, null);
        Tree tree14 = new Tree(null, null, 14, null);
        Tree tree13 = new Tree(null, null, 13, null);
        Tree tree12 = new Tree(null, null, 12, null);
        Tree tree11 = new Tree(null, null, 11, null);
        Tree tree10 = new Tree(null, null, 10, null);
        Tree tree9 = new Tree(null, null, 9, null);
        Tree tree8 = new Tree(null, null, 8, null);
        Tree tree7 = new Tree(tree14, tree15, 7, null);
        Tree tree6 = new Tree(tree12, tree13, 6, null);
        Tree tree5 = new Tree(tree10, tree11, 5, null);
        Tree tree4 = new Tree(tree8, tree9, 4, null);
        Tree tree3 = new Tree(tree6, tree7, 3, null);
        Tree tree2 = new Tree(tree4, tree5, 2, null);
        Tree tree1 = new Tree(tree2, tree3, 1, null);
        BFSPrint.BFSTree(tree1);
        
        ZigZagPrintTree zigZagPrint = new ZigZagPrintTree();
        zigZagPrint.zigZagPrint(tree1);
        
        LowestComAncestorTwoPointerToChildren lowestComAncTwoPoint = new LowestComAncestorTwoPointerToChildren();
        Tree result10 = lowestComAncTwoPoint.LCATwoPointerToChinldrenOptimized(tree1, tree14, tree15);
        System.out.println("The tree14 & tree15 lowset common ancestor tree's value is: " + result10.value);
        Tree result11 = lowestComAncTwoPoint.LCATwoPointerToChinldrenOptimized(tree1, tree7, tree11);
        System.out.println("The tree7 & tree11 lowset common ancestor tree's value is: " + result11.value);
        Tree result12 = lowestComAncTwoPoint.LCATwoPointerToChinldrenOptimized(tree1, tree7, tree13);
        System.out.println("The tree7 & tree13 lowset common ancestor tree's value is: " + result12.value);
        Tree result13 = lowestComAncTwoPoint.LCATwoPointerToChinldrenOptimized(tree1, tree10, tree11);
        System.out.println("The tree10 & tree11 lowset common ancestor tree's value is: " + result13.value);
        Tree result14 = lowestComAncTwoPoint.LCATwoPointerToChinldrenOptimized(tree1, tree6, tree13);
        System.out.println("The tree6 & tree13 lowset common ancestor tree's value is: " + result14.value);
        Tree result17 = lowestComAncTwoPoint.LCATwoPointerToChinldrenOptimized(tree1, tree5, tree6);
        System.out.println("The tree5 & tree6 lowset common ancestor tree's value is: " + result17.value);
        
        LowestComAncestorOnePointerToRoot lowestComAncOnePoint = new LowestComAncestorOnePointerToRoot();
        tree2.root = tree1; tree3.root = tree1; tree4.root = tree2; tree5.root = tree2;
        tree6.root = tree3; tree7.root = tree3; tree8.root = tree4; tree9.root = tree4; tree10.root = tree5; 
        tree11.root = tree5; tree12.root = tree6; tree13.root = tree6; tree14.root = tree7; tree15.root = tree7;
        Tree result15 = lowestComAncOnePoint.lowestComAndOnePoint(tree1, tree15, tree7);
        System.out.println("The lowest common ancestor tree's value by one pointer to root is: " + result15.value);
        
        LowestComAncestorOfVectorNodes LCAVectorNodes = new LowestComAncestorOfVectorNodes();
        List<Tree> vectorNodes = new LinkedList<Tree>();
        vectorNodes.add(tree6);
        vectorNodes.add(tree13);
        vectorNodes.add(tree5);
        vectorNodes.add(tree7);
        vectorNodes.add(tree15);
        Tree result16 = LCAVectorNodes.lowestComAncOfVectorNodes(tree1, vectorNodes);
        System.out.println("The lowest common ancestor tree's value by vector nodes is: " + result16.value);
  
    }
}
