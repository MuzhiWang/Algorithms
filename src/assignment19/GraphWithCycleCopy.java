/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment19;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Muzhi
 */
public class GraphWithCycleCopy {
    
    public static class GraphNode {
    public List<GraphNode> neighbors;
    int value;
        public GraphNode(int value){
            neighbors = new ArrayList<GraphNode>();
            this.neighbors = neighbors;
            this.value = value;
        }
    }
    
    public GraphNode graphCopy(GraphNode root) {
        if (root == null || root.neighbors == null) {
            return root;
        }
        
        HashMap<GraphNode, GraphNode> hashMap = new HashMap<GraphNode, GraphNode>();
        LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
        //LinkedList<GraphNode> queue2 = new LinkedList<GraphNode>();
        queue.offer(root);
        int size = queue.size();
        
        GraphNode newRoot = new GraphNode(root.value);
        //newRoot.neighbors = root.neighbors;
        //queue2.offer(newRoot);
        hashMap.put(root, newRoot);
        while (!queue.isEmpty()) {
            size = queue.size();
            for (int i = 0; i < size; ++i) {
                GraphNode popNode = queue.poll();
                //GraphNode popNode2 = queue2.poll();
                int neighborSize = popNode.neighbors.size();
                for (int j = 0; j < neighborSize; ++j) {
                    
                    if (!hashMap.containsKey(popNode.neighbors.get(j))) {
                        queue.offer(popNode.neighbors.get(j));
                        GraphNode newNode = new GraphNode(popNode.neighbors.get(j).value);
                        hashMap.put(popNode.neighbors.get(j), newNode);
                        hashMap.get(popNode).neighbors.add(newNode);
                    } else {
                        hashMap.get(popNode).neighbors.add(hashMap.get(popNode.neighbors.get(j)));
                    }
                }
            }  
        }
        
        return newRoot;
    }   
    
    public static void main(String[] args) {
        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node3);
        node2.neighbors.add(node3);
        node2.neighbors.add(node1);
        node3.neighbors.add(node1);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        
        GraphWithCycleCopy graphCopy = new GraphWithCycleCopy();
        GraphNode newRoot = graphCopy.graphCopy(node1);
        HashSet hashSet = new HashSet();
        hashSet.add(newRoot);
        LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
        queue.add(newRoot);
        int size;
        GraphNode cur;
        while (!queue.isEmpty()) {
            size = queue.size();       
            for (int i = 0; i < size; ++i) {
                cur = queue.poll();
                System.out.print(cur.value + " ");
                //GraphNode neighbor;
                int neighborSize = cur.neighbors.size();
                for (int j = 0; j < neighborSize; ++j) {
                    if (!hashSet.contains(cur.neighbors.get(j))) {
                        queue.offer(cur.neighbors.get(j));
                        hashSet.add(cur.neighbors.get(j));
                        System.out.print(cur.neighbors.get(j).value + " ");
                    }
                }
                System.out.println();
            }
        }
    }
}
