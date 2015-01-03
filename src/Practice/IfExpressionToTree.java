/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * @author Muzhi
 */
public class IfExpressionToTree {
    public Node expression(String str) {
        char[] charStr = str.toCharArray();
        Node root = new Node(charStr[0]);
        generateNode(root, charStr, 0);
        return root;
    }
    
    private void generateNode(Node cur, char[] charStr, int index) {
        if (index == charStr.length - 1)
            return;
        if (charStr[index + 1] == ':') 
            return;
        
        Deque<Character> stack = new LinkedList<>();
        if (charStr[index + 1] == '?') {
            stack.offer('?');
            cur.left = new Node(charStr[index + 2]);
            generateNode(cur.left, charStr, index + 2);
            int rightIndex = rightIndex(charStr, index + 2, stack);
            cur.right = new Node(charStr[rightIndex]);
            if (rightIndex < charStr.length - 1 && charStr[rightIndex + 1] == '?') {
                generateNode(cur.right, charStr, rightIndex);
            }
        }
    }
    
    private int rightIndex(char[] charStr, int index, Deque<Character> stack) {
        if (index == charStr.length - 1) 
            return index;
        while (index < charStr.length && !stack.isEmpty()) {
            if (charStr[index] == ':' && stack.size() == 1)
                return index + 1;
            else if (charStr[index] == ':')
                stack.poll();
            else if (charStr[index] == '?') 
                stack.offer('?');
            ++index;
        }
        return index - 1;
    }
    
    public static class Node {
        Node left, right;
        char variableName;
        
        public Node(char var) {
            this.variableName = var;
        }
        
        public void print(Node root) {
            assert root != null;
            Deque<Node> queue = new LinkedList<Node>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; ++i) {
                    Node cur = queue.poll();
                    if (cur.left != null)
                        queue.offer(cur.left);
                    if (cur.right != null)
                        queue.offer(cur.right);
                    System.out.print(cur.variableName + " ");    
                }
                System.out.println();
            }
        }
    }
    
    public static void main(String[] args) {
        String str = "a?b?d:e:c?f:g";
        IfExpressionToTree i = new IfExpressionToTree();
        Node n = i.expression(str);
        n.print(n);
        
    }
}
