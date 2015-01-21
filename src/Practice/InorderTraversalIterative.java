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
public class InorderTraversalIterative {
    public ArrayList<Integer> iterativeInorder(TreeNode root) {
        if (root == null)
            return null;
        ArrayList<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                res.add(stack.poll().value);
                cur = cur.right;
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        InorderTraversalIterative in = new InorderTraversalIterative();
        TreeNode root = new TreeNode();
        ArrayList res = in.iterativeInorder(root.treeExample1());
        System.out.println(Objects.toString(res));
    }
    
}
