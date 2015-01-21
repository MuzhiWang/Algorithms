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
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                if (cur.left != null && cur.right != null && cur.right != stack.peek()) {
                    stack.push(cur.right);
                    stack.push(cur);
                    cur = cur.left;
                } else if (cur.left == null && cur.right != stack.peek()) {
                    //stack.push(cur.right);
                    stack.push(cur);
                    cur = cur.right;
                } else if (cur.left == null && cur.right == stack.peek()) {
                    
                }
                else if (cur.right == null) {
                    stack.push(cur);
                    cur = cur.left;
                } else if (cur.right == stack.peek()) {
                    stack.poll();
                    stack.push(cur);
                    cur = cur.right;
                } else {
                    res.add(cur.value);
                    cur = stack.poll();
                }
            }
        }
        return res;
    } 
    
    public static void main(String[] args) {
        IterativeTraversalPostorder it = new IterativeTraversalPostorder();
        TreeNode root = new TreeNode().treeExample1();
        ArrayList<Integer> res = it.iterativePostorder(root);
        System.out.println(Objects.toString(res, null));
        
    }
    
}
