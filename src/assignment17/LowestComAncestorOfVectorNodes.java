/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment17;
import assignment17.BreathFistPrintTree.Tree;
import assignment17.LowestComAncestorTwoPointerToChildren;
import java.util.List;

/**
 *
 * @author Muzhi
 */
public class LowestComAncestorOfVectorNodes {
    public Tree lowestComAncOfVectorNodes(Tree root, List<Tree> vectorNodes) {
        assert root != null;
        int size = vectorNodes.size();
        
        Tree comNodeResult = vectorNodes.get(0);
        for (int num = 0; num < size - 1; ++num) {
            LowestComAncestorTwoPointerToChildren comNode = new LowestComAncestorTwoPointerToChildren();
            comNodeResult = comNode.lowestComAcnTwoPointerToChildren(root, comNodeResult, vectorNodes.get(num + 1));
        }
        return comNodeResult;
    }
}
