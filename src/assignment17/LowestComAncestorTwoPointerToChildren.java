/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment17;

import assignment17.BreathFistPrintTree.Tree;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Muzhi
 */
public class LowestComAncestorTwoPointerToChildren {
    /******** This should be optimized method ********/
    public Tree LCATwoPointerToChinldrenOptimized(Tree root, Tree nodeOne, Tree nodeTwo) {
        assert root != null;
        if (nodeOne == nodeTwo) {
            return nodeOne;
        }
        
        return LCA2PointerHelper(root, nodeOne, nodeTwo);
    }
    
    private Tree LCA2PointerHelper(Tree cur, Tree nodeOne, Tree nodeTwo) {
        if (cur == null) {
            return null;
        }
        if (cur == nodeOne || cur == nodeTwo) {
            return cur;
        }
        
        Tree left = LCA2PointerHelper(cur.left, nodeOne, nodeTwo);
        Tree right = LCA2PointerHelper(cur.right, nodeOne, nodeTwo);
        if (left != null && right != null) {
            return cur;
        }
        return (left != null)? left : right;
        
    }
    
    
    
    /******* This is the correct method **********/
    public Tree lowestComAcnTwoPointerToChildren(Tree root, Tree nodeOne, Tree nodeTwo) {
        assert root != null;
        if (nodeOne == nodeTwo) {
            return nodeOne;
        }
        int[] nodeFlag = new int[2];
        //public static Tree comAcn = new Tree();
        List<Tree> result = new LinkedList<Tree>();
        LCATwoPointerHeler(root, root, nodeOne, nodeTwo, nodeFlag, result);
        return result.get(result.size() - 1);
    }
    
    private int LCATwoPointerHeler(Tree root, Tree cur, Tree nodeOne, Tree nodeTwo, int[] nodeFlag, List<Tree> result) {
        if (cur == null) {
            return -1;
        }
        if (cur == nodeOne) {
            nodeFlag[0] = 1;
            result.add(cur);
            return 1;
        }
        if (cur == nodeTwo) {
            nodeFlag[1] = 1;
            result.add(cur);
            return 1;
        }
        
        int sub1 = LCATwoPointerHeler(root, cur.left, nodeOne, nodeTwo, nodeFlag, result);
        int sub2 = LCATwoPointerHeler(root, cur.right, nodeOne, nodeTwo, nodeFlag, result);
        if (sub1 == 1 && sub2 == 1) {
            result.add(cur);
            return 0;
        }
        return (sub1 == 1) ? sub1 : sub2;  
    }
    
    

    
    /********* This method has some problem of logic. Still need to be modified ************/
    public Tree lowestComAncestor(Tree root, Tree treeOne, Tree treeTwo) {
        assert root != null;
        Tree target = null;
        HashSet<Tree> hashSet = new HashSet<Tree>();
        target = lowestComAncestorHelper(root, root, treeOne, treeTwo, target, hashSet);
        return target;
    }
    
    private Tree lowestComAncestorHelper(Tree root, Tree cur, Tree treeOne, Tree treeTwo, Tree target, HashSet hashSet) {      
        if (cur == treeOne) {
            hashSet.add(cur);
            return treeOne;
        } else if (cur == treeTwo) {
            hashSet.add(cur);
            return treeTwo;
        }
        if (cur.left == null || cur.right == null) {
            if (!hashSet.contains(treeOne) && !hashSet.contains(treeTwo)) {
                return null;
            } else {
                return target;
            }
        }
        
        target = lowestComAncestorHelper(root, cur.left, treeOne, treeTwo, target, hashSet);
        if (target != null && hashSet.contains(treeOne) && hashSet.contains(treeTwo)) {
            return target;
        }
        
        target = lowestComAncestorHelper(root, cur.right, treeOne, treeTwo, target, hashSet);
        if (hashSet.contains(cur.left) || hashSet.contains(cur.right) && target != null) {
            hashSet.add(cur);
        }
//        if (target == treeOne && hashSet.contains(treeTwo)) {
//            //hashSet.add(cur);
//            return treeTwo;
//        }
//        if (target == treeTwo && hashSet.contains(treeOne)) {
//            //hashSet.add(cur);
//            return treeOne;
//        }
        
        if (hashSet.contains(cur.left) && hashSet.contains(cur.right)) {
            return cur;
        }
        
        return target;
    }
    
    
}
