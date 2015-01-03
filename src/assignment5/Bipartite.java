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
public class Bipartite {
    
    public boolean ifBipartite(List<GraphNode> graph){
        int graphIndex = 0;
        if (graph == null || graph.get(index) == null){
            return true;
        }
        for (graphIndex = 0; graphIndex < graph.size(); graphIndex++) {
            if (!ifBipartiteHelper(graph.get(graphIndex))) {
                return false;
            }
        }
        return true;
    }
    
    private int index = 0;
    public boolean ifBipartiteHelper(GraphNode nodeOne){
        if (nodeOne == null) {
            return true;
        }
        for (index = 0; index < nodeOne.neighbors.size(); index++) {
            for (int i = index + 1; i < nodeOne.neighbors.size(); i++) {
                if (nodeOne.neighbors.get(index).neighbors.contains(nodeOne.neighbors.get(i))) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
