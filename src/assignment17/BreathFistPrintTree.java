/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment17;

import java.util.LinkedList;

/**
 *
 * @author Muzhi
 */
public class BreathFistPrintTree {
    public static class Tree{
        Tree left, right, root;
        int value;
        public Tree(Tree left, Tree right, int value, Tree root) {
            this.left = left;
            this.right = right;
            this.value = value;
            this.root = root;
        }
        public Tree(){
        };
    }
    
    public void BFSTree(Tree root) {
        if (root == null || (root.left == null && root.right == null)) {
            System.out.println(root.value);
            return;
        }
        
        LinkedList<Tree> queue = new LinkedList<Tree>();
        queue.offer(root);
        int size = queue.size();
        while (queue.size() != 0) {
            size = queue.size();
            for (int i = 0; i < size; ++i) {
                Tree firstTree = queue.poll();
                if (firstTree.left != null) {
                    queue.offer(firstTree.left);
                }
                if (firstTree.right != null) {
                    queue.offer(firstTree.right);
                }
                System.out.print(firstTree.value);
            }
            System.out.println();
        }
        
    }
    
}
