/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Muzhi
 */
public class ParseTernary {
    public class BinaryTreeNode<E> {
        BinaryTreeNode left, right;
        E e;
        
        public BinaryTreeNode(E e) {
            this.e = e;
        }
        
        public void print(BinaryTreeNode root) {
            assert root != null;
            Deque<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; ++i) {
                    BinaryTreeNode cur = queue.poll();
                    if (cur.left != null)
                        queue.offer(cur.left);
                    if (cur.right != null)
                        queue.offer(cur.right);
                    System.out.print(cur.e + " ");    
                }
                System.out.println();
            }
        }
    }
    
    
    public BinaryTreeNode<String> parseWhole(String s) {
        String st = s.trim();
        int i = 0;
        while (i < st.length() && st.charAt(i) != '?') {
            i++;
        }
        //System.out.println(i);
        if (i == st.length())
            return new BinaryTreeNode<String>(st.substring(0, i));
        else {
            BinaryTreeNode<String> res = new BinaryTreeNode<String>(st.substring(0, i));
            List<BinaryTreeNode<String>> LR = parseLR(st.substring(i + 1, st.length()));
            res.left = LR.get(0);
            res.right = LR.get(1);
            return res;
        }
    }
    public List<BinaryTreeNode<String>> parseLR(String s) {
        List<BinaryTreeNode<String>> res = new ArrayList<>();
        String st = s.trim();
        int counter  = 0;
        int i = 0;
        for (; i < st.length() && counter != 1; i++) {
            if (st.charAt(i) == ':') counter++;
            if (st.charAt(i) == '?') counter--;
        }
        System.out.println(i);
        BinaryTreeNode<String> right = parseWhole(st.substring(i));
        BinaryTreeNode<String> left = parseWhole(st.substring(0, i - 1));
        res.add(left);
        res.add(right);
        return res;
    }
    public static void main(String... args) {
        ParseTernary p = new ParseTernary();
        BinaryTreeNode<String> res = p.parseWhole("a?b?d:e:c?f:g");
        res.print(res);
    }
}    
    

