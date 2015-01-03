/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
//import myTools.TreeNode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

/**
 *
 * @author Muzhi
 */
public class ReconstructTreeByPairs {
    public static class Pair<PTree, CTree> {
        private final PTree parent;
        private final CTree child;
                
        public Pair(PTree parent, CTree child) {
            this.parent = parent;
            this.child = child;
        }
        
        public PTree getParent() {
            return parent;
        }
        
        public CTree getChild() {
            return child;
        }
        
        @Override
        public int hashCode() {
            return parent.hashCode() ^ child.hashCode();
        }
        
        @Override
        public boolean equals(Object o) {
            if (o == null) 
                return false;
            if (!(o instanceof Pair)) 
                return false;
            Pair p = (Pair)o;
            //return p.parent == this.parent && p.child == this.child;
            return this.parent.equals(p.getParent()) && this.child.equals(p.getChild());
        }
    }
    
    public static class TreeNode {
        public TreeNode left, right;
        public int value;
        
        public TreeNode(int value) {
            this.value = value;
        }

        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
        
        public TreeNode() {
            this.left = null;
            this.right = null;
            this.value = Integer.MAX_VALUE;
        }

        public void printTree(TreeNode root) {
            if (root == null) 
                return;
            Deque<TreeNode> deque = new LinkedList<TreeNode>();
            int size = deque.size();
            deque.push(root);
            while (!deque.isEmpty()) {
                size = deque.size();
                for (int i = 0; i < size; ++i) {
                    TreeNode pop = deque.pollFirst();
                    if (pop.value < Integer.MAX_VALUE) {
                        System.out.print(pop.value + " ");
                        if (pop.left != null && pop.left.value < Integer.MAX_VALUE) {
                            deque.offerLast(pop.left);
                        } else {
                            deque.offerLast(new TreeNode());
                        }
                        if (pop.right != null && pop.right.value < Integer.MAX_VALUE) {
                            deque.offerFirst(pop.right);
                        } else { 
                            deque.offerLast(new TreeNode());
                        }
                    } else {
                        System.out.print("* ");
                    }
                }
                System.out.println();
            }
        }
    
    }
    
    public TreeNode reconstruct(List<Pair<TreeNode, TreeNode>> dictionary) {
        HashMap<TreeNode, List<TreeNode>> hashMap = new HashMap<TreeNode, List<TreeNode>>();
        for (int i = 0; i < dictionary.size(); ++i) {
            if (!hashMap.containsKey(dictionary.get(i).getParent())) {
                List<TreeNode> child = new LinkedList<TreeNode>();
                child.add(dictionary.get(i).getChild());
                hashMap.put(dictionary.get(i).getParent(), child);
            } else {
                List<TreeNode> child = hashMap.get(dictionary.get(i).getParent());
                child.add(dictionary.get(i).getChild());
                hashMap.put(dictionary.get(i).getParent(), child);
            }
        }
        
        HashSet<TreeNode> hashSet = new HashSet<TreeNode>();
        for (Entry pair : hashMap.entrySet()) {
            TreeNode tree = (TreeNode)pair.getKey();
            LinkedList<TreeNode> subTree = (LinkedList<TreeNode>)(pair.getValue());
            if (!hashSet.contains(tree))
                hashSet.add(tree);
            if (subTree.size() > 0 && subTree.get(0) != null) {
                tree.left = subTree.get(0);
                hashSet.add(tree.left);
            }
            if (subTree.size() > 1 && subTree.get(1) != null) {
                tree.right = subTree.get(1);
                hashSet.add(tree.right);
            }
        }
        
        for (int i = 0; i < dictionary.size(); ++i) {
            hashSet.remove(dictionary.get(i).getChild());
        }
        return hashSet.iterator().next();
    }
    
    public static void main(String[] args) {
        ReconstructTreeByPairs r = new ReconstructTreeByPairs();
        TreeNode tree15 = new TreeNode(15, null, null);
        TreeNode tree14 = new TreeNode(14, null, null);
        TreeNode tree13 = new TreeNode(13, null, null);
        TreeNode tree12 = new TreeNode(12, null, null);
        TreeNode tree11 = new TreeNode(11, null, null);
        TreeNode tree10 = new TreeNode(10, null, null);
        TreeNode tree9 = new TreeNode(9, null, null);
        TreeNode tree8 = new TreeNode(8, null, null);
        Pair<TreeNode, TreeNode> p1 = new Pair<>(tree8, tree9);
        Pair<TreeNode, TreeNode> p2 = new Pair<>(tree9, tree10);
        Pair<TreeNode, TreeNode> p3 = new Pair<>(tree9, tree11);
        Pair<TreeNode, TreeNode> p4 = new Pair<>(tree11, tree12);
        Pair<TreeNode, TreeNode> p5 = new Pair<>(tree11, tree13);
        Pair<TreeNode, TreeNode> p6 = new Pair<>(tree13, tree14);
        Pair<TreeNode, TreeNode> p7 = new Pair<>(tree14, tree15);
        List<Pair<TreeNode, TreeNode>> dic = new LinkedList<>();
        dic.add(p4);
        dic.add(p3);
        dic.add(p2);
        dic.add(p1);
        dic.add(p5);
        dic.add(p6);
        dic.add(p7);
        TreeNode head = r.reconstruct(dic);
        head.printTree(head);
    }
}
