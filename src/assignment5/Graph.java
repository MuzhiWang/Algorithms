/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5;
import java.util.*;

/**
 *
 * @author Muzhi
 */
public class Graph {
    
        public List<GraphNode> graphOne() {
            
        GraphNode nodeOne = new GraphNode();
        GraphNode nodeTwo = new GraphNode();
        GraphNode nodeThree = new GraphNode();
        
        nodeOne.neighbors.add(nodeTwo);
        nodeOne.neighbors.add(nodeThree);
        nodeTwo.neighbors.add(nodeOne);
        nodeTwo.neighbors.add(nodeThree);
        nodeThree.neighbors.add(nodeTwo);
        nodeThree.neighbors.add(nodeOne);
        
        return Arrays.asList(new GraphNode[] {nodeOne, nodeTwo, nodeThree});
        }
        
        public List<GraphNode> graphTwo() {
            GraphNode nodeOne = new GraphNode();
            GraphNode nodeTwo = new GraphNode();
            GraphNode nodeThree = new GraphNode();
            
            nodeOne.neighbors.add(nodeTwo);
            nodeTwo.neighbors.add(nodeOne);
            nodeThree.neighbors.add(nodeOne);
            nodeOne.neighbors.add(nodeThree);
            
            return Arrays.asList(new GraphNode[] {nodeOne, nodeTwo, nodeThree});
            
            
        }
        
        public List<GraphNode> graphThree() {
            GraphNode nodeOne = new GraphNode();
            GraphNode nodeTwo = new GraphNode();
            GraphNode nodeThree = new GraphNode();
            GraphNode nodeFour = new GraphNode();
            
            nodeOne.neighbors.add(nodeTwo);            
            nodeOne.neighbors.add(nodeThree);
            nodeOne.neighbors.add(nodeFour);
            nodeTwo.neighbors.add(nodeOne);
            nodeTwo.neighbors.add(nodeFour);
            nodeThree.neighbors.add(nodeOne);
            nodeFour.neighbors.add(nodeOne);
            nodeFour.neighbors.add(nodeTwo);
            
            return Arrays.asList(new GraphNode[] {nodeOne, nodeTwo, nodeThree, nodeFour});
            
            
        }
    
}
