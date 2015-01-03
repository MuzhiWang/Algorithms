/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment17;

import assignment17.BreathFistPrintTree.Tree;
import java.util.HashSet;

/**
 *
 * @author Muzhi
 */
public class LowestComAncestorOnePointerToRoot {
    public Tree lowestComAndOnePoint(Tree root, Tree treeOne, Tree treeTwo) {
        assert root == null;
        if (root.left == null && root.right == null) {
            return null;
        } else if (root.left == null || root.right == null) {
            return root;
        }
        
        HashSet hashSet = new HashSet();
        hashSet.add(root);
        while (treeOne.root != null) {
            hashSet.add(treeOne);
            treeOne = treeOne.root;
        } 
        while (treeTwo != null && !hashSet.contains(treeTwo)) {
            treeTwo = treeTwo.root;
        }
        return treeTwo;
       
    }
    
}
