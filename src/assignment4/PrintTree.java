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
public class PrintTree {
    public void preOrderPrintTree(Tree tree){
        if (tree == null){
            //System.out.println("null");
            return;
        }
        
        System.out.print(tree.value + " ");
        preOrderPrintTree(tree.left);
        preOrderPrintTree(tree.right);
    }
    
    public void inOrderPrintTree(Tree tree){
        if (tree == null){
            //System.out.println("null");
            return;
        }
        
        inOrderPrintTree(tree.left);
        System.out.print(tree.value + " ");
        inOrderPrintTree(tree.right);
    }
    
    public void postOrderPrintTree(Tree tree){
        if (tree == null){
            return;
        }
        
        postOrderPrintTree(tree.left);
        postOrderPrintTree(tree.right);
        System.out.print(tree.value + " "); 
    }
    
}
