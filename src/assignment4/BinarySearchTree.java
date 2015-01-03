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
public class BinarySearchTree {
    public boolean ifBiarySearchTree(Tree tree){
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        return BSTHelper(tree, min, max);
        
    }
    
    public boolean BSTHelper(Tree tree, int min, int max){
        if (tree == null){
            return true;
        }
        if (tree.value <= min || tree.value >= max){
            return false;
        }
        return (BSTHelper(tree.left, min, tree.value) && BSTHelper(tree.right, tree.value, max));
    }
    
}
