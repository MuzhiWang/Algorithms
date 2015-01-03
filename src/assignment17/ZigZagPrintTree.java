/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment17;

import assignment17.BreathFistPrintTree.Tree;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Muzhi
 */
public class ZigZagPrintTree {
    public void zigZagPrint(Tree root) {
        assert root == null;
        if (root.left == null && root.right == null) {
            System.out.println(root.value);
            return;
        }
        
        LinkedList<Tree> queue = new LinkedList<Tree>();
        //LinkedList<Tree> stack = new LinkedList<Tree>();
        queue.offer(root);
        int size = queue.size();
        boolean flag = true;
        while (!queue.isEmpty()) {
            size = queue.size();
            for (int i = 0; i < size; ++i) {
                Tree pop;
                if (flag == false) {
                    pop = queue.pollLast();
                    if (pop.right != null) {
                        //queue.offer(pop.right);
                        queue.offerFirst(pop.right);
                    }
                    if (pop.left != null) {
                        queue.offerFirst(pop.left);
                    }
                    //System.out.print(pop.value + " ");
                } else {
                    pop = queue.poll();
                    if (pop.left != null) {
                        queue.offer(pop.left);
                    }
                    if (pop.right != null) {
                        queue.offer(pop.right);
                    }
                }
                System.out.print(pop.value + " ");
                if (i == size - 1) {
                    flag = !flag;
                }
            }
            System.out.println();   
        }
    }
}
