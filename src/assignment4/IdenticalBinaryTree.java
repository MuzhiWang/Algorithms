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
public class IdenticalBinaryTree {
    public boolean ifIdentical(Tree treeOne, Tree treeTwo){
        if (treeOne == null && treeTwo == null){
            return true;
        } else if (treeOne == null || treeTwo == null){
            return false;
        }
        
        if (treeOne.value != treeTwo.value){
            return false;
        }
        
        return ifIdentical(treeOne.left, treeTwo.left) && ifIdentical(treeOne.right, treeTwo.right);
    }
    
    
}
