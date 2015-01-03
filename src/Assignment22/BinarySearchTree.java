/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment22;

import myTools.TreeNode;

/**
 *
 * @author Muzhi
 */
public class BinarySearchTree {
    
    /*******  nlog(n) time complexity. Not so good  *******/
    public boolean isBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) return false;
        return isBST(root.left) && isBST(root.right);
    }
    
    private int getHeight(TreeNode cur) {
        if (cur == null) return 0;
        return Math.max(getHeight(cur.left), getHeight(cur.right)) + 1;
    }
    
    /************  n time complexity. Optimization  ************/
    public boolean isBSTTwo(TreeNode root) {
        return getHeightTwo(root) != -1;
    }
    
    public int getHeightTwo(TreeNode cur) {
        if (cur == null) return 0;
        int left = getHeightTwo(cur.left);
        int right = getHeightTwo(cur.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
    
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        BinarySearchTree bst = new BinarySearchTree();
        System.out.println(bst.isBST(root.treeExample1()));
        System.out.println(bst.isBST(root.treeExample2()));
        System.out.println(bst.isBST(root.treeExample3()));

        System.out.println(bst.isBSTTwo(root.treeExample1()));
        System.out.println(bst.isBSTTwo(root.treeExample2()));
        System.out.println(bst.isBSTTwo(root.treeExample3()));
                
    }
    
}
