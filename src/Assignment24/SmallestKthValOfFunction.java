/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment24;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author Muzhi
 */
public class SmallestKthValOfFunction {
    public static class Ele {
        int x, y, z;
        double f;
        Ele(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
            f = Math.pow(3, x) + Math.pow(5, y) + Math.pow(7, z);
        }
    }
    
    public List<Double> smallestKthVal(int k) {
        PriorityQueue<Ele> maxHeap = new PriorityQueue<>(k, new Comparator<Ele>(){
            @Override
            public int compare(Ele a, Ele b) {
                return (int)(a.f - b.f);
            }
        });
        
        
    }
    
}
