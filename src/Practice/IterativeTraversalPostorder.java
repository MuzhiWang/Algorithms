/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import myTools.TreeNode;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

/**
 *
 * @author Muzhi
 */
public class IterativeTraversalPostorder {
    public ArrayList<Integer> iterativePostorder(TreeNode root) {
        if (root == null)
            return null;
        ArrayList<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode next = stack.peek();
            if (next.right == cur || next.left == cur || 
                (next.left == null && next.right == null)) {
                stack.pop();
                res.add(next.value);
                cur = next;
            } else {
                if (next.right != null)
                    stack.push(next.right);
                if (next.left != null)
                    stack.push(next.left);
            }
        }
        return res;
    } 
    
    public static void main(String[] args) {
        IterativeTraversalPostorder it = new IterativeTraversalPostorder();
        TreeNode root = new TreeNode().treeExample1();
        ArrayList<Integer> res = it.iterativePostorder(root);
        System.out.println(Objects.toString(res));
        
    }
    
}
