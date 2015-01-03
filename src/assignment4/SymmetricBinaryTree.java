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
public class SymmetricBinaryTree {
    public boolean ifSymmetricBT(Tree tree){
        if (tree == null){
            return true;
        }
        
        return SymmetricBTHelper(tree.left, tree.right);
    }
    
    public boolean SymmetricBTHelper(Tree treeOne, Tree treeTwo){
        if (treeOne == null && treeTwo == null){
            return true;
        } else if (treeOne == null || treeTwo == null){
            return false;
        }
        
        if (treeOne.value != treeTwo.value){
            return false;
        }
        
        return SymmetricBTHelper(treeOne.left, treeTwo.right) && SymmetricBTHelper(treeOne.right, treeTwo.left);
    }
    
    
}
