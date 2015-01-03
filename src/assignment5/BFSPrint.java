/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5;
import java.util.Queue;
import java.util.LinkedList;

/**
 *
 * @author Muzhi
 */
public class BFSPrint {
    /*
    public void BFS(Tree root) {
        if (root == null) {
            System.out.println(root);
            return;
        }
        Queue<Tree> queue = new LinkedList<Tree>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int index = 0; index < size; index++) {
                Tree curNode = queue.poll();
                if (curNode.left != null) {                 // Better solution
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
                System.out.print(curNode.value);
            }
            System.out.println();
            
        }
        
    }
    */
    public void treeBFSprint(Tree root){
        assert root != null;
        Queue<Tree> queue = new LinkedList<Tree>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                if (queue.peek().left == null && queue.peek().right == null) {
                    System.out.print(queue.peek().value + " ");
                    queue.poll();
                    break;
                } else if (queue.peek().left == null) {
                    queue.offer(queue.peek().right);
                } else if (queue.peek().right == null) {
                    queue.offer(queue.peek().left);
                } else {
                queue.offer(queue.peek().left);
                queue.offer(queue.peek().right);
                }
                System.out.print(queue.peek().value + " ");
                queue.poll();
            }
            
             
        }
        System.out.println();
        return;
    }
}
