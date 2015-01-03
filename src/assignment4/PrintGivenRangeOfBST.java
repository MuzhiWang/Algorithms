/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

/**
 *
 * @author Muzhi
 */
public class PrintGivenRangeOfBST {
    public void printGivenRange(Tree tree, int min, int max){
        if (tree == null){
            return;
        }
        
        if (tree.value < min || tree.value > max){
            return;
        }
        
        System.out.print(tree.value + " ");
        printGivenRange(tree.left, min, max);
        printGivenRange(tree.right, min, max);
        return;
    }
    
    /*
    public void printGivenRangeHelper(Tree left, Tree right, int min, int max){
        if (left == null && right == null){
            return;
        } else if (left == null){
            printGivenRangeHelper(right.left, right.right, min, max);
        } else if (right == null){
            printGivenRangeHelper(left.left, left.right, min, max);
        }
        
        if (left.value < min){
            printGivenRangeHelper(right.left, right.right, min, max);
        } else if (right.value > max){
            printGivenRangeHelper(left.left, left.right, min, max);
        }
      */  
        
        
    }

