/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment19;
import assignment19.BSTFindClosestNode.*;

/**
 *
 * @author Muzhi
 */
public class LargestNodeSmallerThanTarget {
    private double diff = Double.MAX_VALUE;
    private TreeNode node;
    
    public TreeNode findTheNode(TreeNode root, double target) {
        assert root != null;
        findTheNodeHelper(root, target);
        return this.node;
        
    }

    private void findTheNodeHelper(TreeNode cur, double target) {
        if (cur == null) {
            return;
        }
        if (target > cur.value) findTheNodeHelper(cur.right, target);
        if (target < cur.value) findTheNodeHelper(cur.left, target);
        if (cur.value - target > 0 && this.diff > (cur.value - target)) {
            this.diff = cur.value - target;
            this.node = cur;
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
        
        LargestNodeSmallerThanTarget node = new LargestNodeSmallerThanTarget();
        TreeNode res = node.findTheNode(tree1, -5);
        System.out.println(res.value);
    }
}
