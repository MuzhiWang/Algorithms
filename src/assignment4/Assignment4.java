/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;
import java.util.Vector;

/**
 *
 * @author Muzhi
 */
public class Assignment4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vector<Tree> tree = new Vector<Tree>();
        Tree tree4 = new Tree(null, null);
        Tree tree5 = new Tree(null, null);
        Tree tree6 = new Tree(null, null);
        Tree tree7 = new Tree(null, null);
        Tree tree2 = new Tree(tree4, tree5);
        Tree tree3 = new Tree(tree6, tree7);
        Tree tree1 = new Tree(tree2, tree3);
        tree1.value = 5;
        tree2.value = 3;
        tree3.value = 7;
        tree4.value = 2;
        tree5.value = 4;
        tree6.value = 6;
        tree7.value = 9;
        
        
        PrintTree printTree = new PrintTree();
        System.out.println("The tree's pre-order print is ");
        printTree.preOrderPrintTree(tree1);
        System.out.println();
        System.out.println("The tree's in-order print is ");
        printTree.inOrderPrintTree(tree1);
        System.out.println();
        System.out.println("The tree's post-order print is ");
        printTree.postOrderPrintTree(tree1);
        System.out.println();
        
        BinarySearchTree bst = new BinarySearchTree();
        System.out.print("The tree is Binary Search Tree or not: ");
        System.out.println(bst.ifBiarySearchTree(tree1));
        
        Tree tree_4 = new Tree(null, null);
        Tree tree_5 = new Tree(null, null);
        Tree tree_6 = new Tree(null, null);
        Tree tree_7 = new Tree(null, null);
        Tree tree_2 = new Tree(tree_4, tree_5);
        Tree tree_3 = new Tree(tree_6, tree_7);
        Tree tree_1 = new Tree(tree_2, tree_3);
        tree_1.value = 5;
        tree_2.value = 7;
        tree_3.value = 7;
        tree_4.value = 5;
        tree_5.value = 4;
        tree_6.value = 4;
        tree_7.value = 5;
        
        IdenticalBinaryTree identicalBT = new IdenticalBinaryTree();
        System.out.print("The tree1 and tree_1 is identical? True or false: ");
        System.out.println(identicalBT.ifIdentical(tree1, tree_1));
        
        SymmetricBinaryTree symmetricBT = new SymmetricBinaryTree();
        System.out.print("The tree is symmetric or not: ");
        System.out.println(symmetricBT.ifSymmetricBT(tree_1));
        
        AfterTweakIdentical identicalAfterTweak = new AfterTweakIdentical();
        System.out.print("After tweak the two tree is identical or not: ");
        System.out.println(identicalAfterTweak.ifIdentical(tree1, tree_1));
        
        PrintGivenRangeOfBST givenRange = new PrintGivenRangeOfBST();
        System.out.print("Print the given range of BST: ");
        givenRange.printGivenRange(tree1, 4, 8);
        
    }
    
}
