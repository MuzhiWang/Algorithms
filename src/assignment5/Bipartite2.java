/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Muzhi
 */
public class Bipartite2 {
    public boolean isBipartite(List<GraphNode> graph) {
        assert graph != null;
        HashMap<GraphNode, Integer> map = new HashMap<GraphNode, Integer>();
        for (GraphNode node : graph) {
            if (!searchAndMark(node, map)) {
                return false;
            }
        }
        return true;
    }

    private boolean searchAndMark(GraphNode node, HashMap<GraphNode, Integer> map) {
        if (map.containsKey(node)) {
            return true;
        }
        
        Queue<GraphNode> queue = new LinkedList<GraphNode>();
        queue.offer(node);
        map.put(node, 0);
        while (!queue.isEmpty()) {
            GraphNode cur = queue.poll();
            int group = map.get(cur);
            int neighborGroup = group == 0 ? 1 : 0;
            for(GraphNode neighbor : cur.neighbors) {
                if (!map.containsKey(node)) {
                    queue.offer(node);
                    map.put(node, neighborGroup);
                } else if (neighborGroup != map.get(neighbor).intValue()) {
                    return false;
                }
            }
        }
        return true;
    }
    

}