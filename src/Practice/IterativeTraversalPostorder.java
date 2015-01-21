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
            if (cur != null && cur != stack.peek()) {
                if (cur.left != null) {
                    stack.push(cur);
                    if (cur.right != null)
                        stack.push(cur.right);
                    cur = cur.left;
                } else if (cur.right != null) {
                    stack.push(cur);
                    cur = cur.right;
                } else {
                    res.add(cur.value);
                    cur = stack.peek();
                }
            } else if (cur != null) {
                res.add(stack.poll().value);
                cur = stack.peek();
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
