/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5;
import java.util.Vector;

/**
 *
 * @author Muzhi
 */
public class Tree {
    int value;
    Tree left;
    Tree right;
    public Tree(int value){
        this.value = value;
        //this.left = left;
        //this.right = right;
    }
    public Tree(Tree leftTree, Tree rightTree){
        this.left = leftTree;
        this.right = rightTree;
    }
    
    /*
    int index;
    //Vector<Tree> trees = new Vector<Tree>();
    public void inputTree(int[] array){
        if (index == array.length){
            return;
        }
        if (index ){
            
        }
        Tree newTree = new Tree(array[]); 
        
        
    }
    
    private void inputOneTree(Tree tree, int value){
        tree.value = value;
    }
    */
}
