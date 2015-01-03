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
public class MaxSumFromTwoLeafNode {
    private int maxSum = Integer.MIN_VALUE;
    
    public int maxSum(TreeNode root) {
        assert root != null;
        maxSumHelper(root);
        return this.maxSum;
    }
    
    private int maxSumHelper(TreeNode root) {
        if (root == null) return 0;
        int left = maxSumHelper(root.left);
        int right = maxSumHelper(root.right);
        this.maxSum = (this.maxSum < left + right + root.value) ? left + right + root.value : this.maxSum;
        return (left > right) ? left + root.value : right + root.value;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        MaxSumFromTwoLeafNode maxSum = new MaxSumFromTwoLeafNode();
        System.out.println(maxSum.maxSum(root.treeExample1()));
        maxSum.maxSum = Integer.MIN_VALUE;
        System.out.println(maxSum.maxSum(root.treeExample2()));
        maxSum.maxSum = Integer.MIN_VALUE;
        System.out.println(maxSum.maxSum(root.treeExample3()));
        maxSum.maxSum = Integer.MIN_VALUE;
        System.out.println(maxSum.maxSum(root.treeExample4()));
    }
    
}
