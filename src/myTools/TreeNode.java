/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myTools;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * @author Muzhi
 */
public class TreeNode {
    public TreeNode left, right;
    public int value;
    public TreeNode(int value) {
        this.value = value;
    }
    
    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
    
    public TreeNode() {
        left = null;
        right = null;
        value = Integer.MAX_VALUE;
    }
    
    public TreeNode treeExample1() {
        TreeNode tree4 = new TreeNode(4, null, null);
        TreeNode tree5 = new TreeNode(5, null, null);
        TreeNode tree6 = new TreeNode(6, null, null);
        TreeNode tree7 = new TreeNode(7, null, null);
        TreeNode tree3 = new TreeNode(3, tree6, tree7);
        TreeNode tree2 = new TreeNode(2, tree4, tree5);
        TreeNode tree1 = new TreeNode(1, tree2, tree3);
        return tree1;
    }
    
    public TreeNode treeExample2() {
        TreeNode tree15 = new TreeNode(15, null, null);
        TreeNode tree14 = new TreeNode(14, null, null);
        TreeNode tree13 = new TreeNode(13, null, null);
        TreeNode tree12 = new TreeNode(12, null, null);
        TreeNode tree11 = new TreeNode(11, null, null);
        TreeNode tree10 = new TreeNode(10, null, null);
        TreeNode tree9 = new TreeNode(9, null, null);
        TreeNode tree8 = new TreeNode(8, null, null);
        TreeNode tree4 = new TreeNode(4, tree8, tree9);
        TreeNode tree5 = new TreeNode(5, tree10, tree11);
        TreeNode tree6 = new TreeNode(6, tree12, tree13);
        TreeNode tree7 = new TreeNode(7, tree14, tree15);
        TreeNode tree3 = new TreeNode(3, tree6, tree7);
        TreeNode tree2 = new TreeNode(2, tree4, tree5);
        TreeNode tree1 = new TreeNode(1, tree2, tree3);
        return tree1;
    }
    
    public TreeNode treeExample3() {
        TreeNode tree15 = new TreeNode(15, null, null);
        TreeNode tree14 = new TreeNode(14, null, null);
        TreeNode tree13 = new TreeNode(13, null, null);
        TreeNode tree12 = null;
        TreeNode tree11 = new TreeNode(11, null, null);
        TreeNode tree10 = new TreeNode(10, null, null);
        //TreeNode tree9 = null;
        TreeNode tree8 = new TreeNode(8, null, null);
        TreeNode tree4 = null;
        TreeNode tree5 = new TreeNode(5, tree10, tree11);
        TreeNode tree6 = new TreeNode(6, tree12, tree13);
        TreeNode tree7 = new TreeNode(7, tree14, tree15);
        TreeNode tree3 = new TreeNode(3, tree6, tree7);
        TreeNode tree2 = new TreeNode(2, tree4, tree5);
        TreeNode tree1 = new TreeNode(1, tree2, tree3);
        return tree1;
    }
    
    public TreeNode treeExample4() {
        TreeNode tree15 = new TreeNode(-15, null, null);
        TreeNode tree14 = new TreeNode(14, null, null);
        TreeNode tree13 = new TreeNode(13, null, null);
        TreeNode tree12 = new TreeNode(12, null, null);
        TreeNode tree11 = new TreeNode(11, null, null);
        TreeNode tree10 = new TreeNode(10, null, null);
        TreeNode tree9 = new TreeNode(9, null, null);
        TreeNode tree8 = new TreeNode(8, null, null);
        TreeNode tree4 = new TreeNode(4, tree8, tree9);
        TreeNode tree5 = new TreeNode(-5, tree10, tree11);
        TreeNode tree6 = new TreeNode(6, tree12, tree13);
        TreeNode tree7 = new TreeNode(-7, tree14, tree15);
        TreeNode tree3 = new TreeNode(3, tree6, tree7);
        TreeNode tree2 = new TreeNode(2, tree4, tree5);
        TreeNode tree1 = new TreeNode(1, tree2, tree3);
        return tree1;
    }

        public void printTree(TreeNode root) {
            if (root == null) 
                return;
            Deque<TreeNode> deque = new LinkedList<TreeNode>();
            int size = deque.size();
            deque.push(root);
            while (!deque.isEmpty()) {
                size = deque.size();
                for (int i = 0; i < size; ++i) {
                    TreeNode pop = deque.pollFirst();
                    if (pop.value < Integer.MAX_VALUE) {
                        System.out.print(pop.value + " ");
                        if (pop.left != null && pop.left.value < Integer.MAX_VALUE) {
                            deque.offerLast(pop.left);
                        } else {
                            deque.offerLast(new TreeNode());
                        }
                        if (pop.right != null && pop.right.value < Integer.MAX_VALUE) {
                            deque.offerFirst(pop.right);
                        } else { 
                            deque.offerLast(new TreeNode());
                        }
                    } else {
                        System.out.print("* ");
                    }
                    
                }
                System.out.println();
            }
        }
    
}
