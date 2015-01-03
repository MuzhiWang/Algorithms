/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment23;

/**
 *
 * @author Muzhi
 */
public class ReverseTreeUpsideDown {
    
    public static class Tree{
        Tree left, right;
        int value;
//        public Tree() {
//            
//        }
        public Tree(int value) {
            this.value = value;
//            this.left = new Tree();
//            this.right = new Tree();
        }
    }
    
    /****  Recursion method  *****/
    public Tree reverseTree(Tree root, Tree newHead) {
        if (root == null || root.left == null) {
            newHead = root;
            return root;
        }
        newHead = reverseTree(root.left, newHead);
        root.left.right = root.right;
        root.left.left = root;
        root.left = null;
        root.right = null;
        return newHead;
    }
    
    /*******  Iteration method  ********/
    public Tree recursionReverseTree(Tree root) {
        if (root == null) return null;
        Tree cur = root;
        Tree left, curRight, preRight = null;
        Tree pre = new Tree(0);
        pre.right = null;
        while (cur != null) {
            left = cur.left;
            curRight = cur.right;
            cur.left = pre;
            cur.right = preRight;
            pre = cur;
            cur = left;
            preRight = curRight;
        }
        Tree temp = pre;
        while (temp.left.left != null) {
            temp = temp.left;
        }
        temp.left = null;
        return pre;
    }
    
    
    public void print(Tree root) {
        while (root != null) {
            System.out.print(root.value + " -> ");
            if (root.left != null) {
                System.out.print(" \\ " + root.left.value);
            }
            if (root.right != null) {
                System.out.print(" \\ " + root.right.value);
            }
            root = root.left;
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        Tree tree7 = new Tree(7);
        Tree tree6 = new Tree(6);
        Tree tree5 = new Tree(5);
        Tree tree4 = new Tree(4);
        Tree tree3 = new Tree(3);
        Tree tree2 = new Tree(2);
        Tree tree1 = new Tree(1);
        tree1.left = tree2; tree1.right = tree3; tree2.left = tree4; tree2.right = tree5;
        tree4.left = tree6; tree4.right = tree7;
        ReverseTreeUpsideDown reverse = new ReverseTreeUpsideDown();
        reverse.print(tree1);
        Tree newHead = null;
        newHead = reverse.reverseTree(tree1, newHead);
        reverse.print(newHead);
        System.out.println();
        
        tree7 = new Tree(7);
        tree6 = new Tree(6);
        tree5 = new Tree(5);
        tree4 = new Tree(4);
        tree3 = new Tree(3);
        tree2 = new Tree(2);
        tree1 = new Tree(1);
        tree1.left = tree2; tree1.right = tree3; tree2.left = tree4; tree2.right = tree5;
        tree4.left = tree6; tree4.right = tree7;
        reverse.print(tree1);
        newHead = reverse.recursionReverseTree(tree1);
        reverse.print(newHead);
    }
    
}
