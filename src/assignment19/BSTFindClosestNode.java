/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment19;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Muzhi
 */
public class BSTFindClosestNode {
    public static class TreeNode {
        TreeNode left, right;
        int value;
        public TreeNode(int value) {
            this.value = value;
        }
    
        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public TreeNode() {}
    }
    
    double diff = Double.POSITIVE_INFINITY;
    TreeNode closeTree;
    public TreeNode closestNode(TreeNode root, double target) {
        assert root != null;
        findClosestHelper(root, target);
        return this.closeTree;
    }
    
    private void findClosestHelper(TreeNode cur, double target) {
        if (cur == null) {
            return;
        }
        
        if (target > cur.value) {
            findClosestHelper(cur.right, target);
        }
        if (target < cur.value) {
            findClosestHelper(cur.left, target);
        }
        if (this.diff > Math.abs(cur.value - target)) {
            this.diff = Math.abs(cur.value - target);
            this.closeTree = cur;
        }
    }
    
    public void print(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        TreeNode cur;
        int size;
        while (!queue.isEmpty()) {
            size = queue.size();
            for (int i = 0; i < size; ++i) {
                cur = queue.poll();
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
                System.out.print(cur.value + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        TreeNode tree4 = new TreeNode(1);
        TreeNode tree5 = new TreeNode(8);
        TreeNode tree6 = new TreeNode(12);
        TreeNode tree7 = new TreeNode(20);
        TreeNode tree2 = new TreeNode(4, tree4, tree5);
        TreeNode tree3 = new TreeNode(15, tree6, tree7);
        TreeNode tree1 = new TreeNode(10, tree2, tree3);
        
        BSTFindClosestNode bst = new BSTFindClosestNode();
        bst.print(tree1);
        TreeNode closestNode = bst.closestNode(tree1, 29);
        System.out.println(closestNode.value);
        
    }
    
    
}
