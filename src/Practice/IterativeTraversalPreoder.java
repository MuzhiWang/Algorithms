/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import myTools.TreeNode;

/**
 *
 * @author Muzhi
 */
public class IterativeTraversalPreoder {
    public ArrayList<Integer> iterativePreoder(TreeNode root) {
        if (root == null) 
            return null;
        ArrayList<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                res.add(cur.value);
                if (cur.right != null)
                    stack.push(cur.right);
                cur = cur.left;
            } else {
                cur = stack.poll();
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        IterativeTraversalPreoder it = new IterativeTraversalPreoder();
        TreeNode root = new TreeNode().treeExample1();
        ArrayList<Integer> res = it.iterativePreoder(root);
        System.out.println(Objects.toString(res));
    } 
    
}
