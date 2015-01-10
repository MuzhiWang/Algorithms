/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment24;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
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
        PriorityQueue<Ele> minHeap = new PriorityQueue<>(new Comparator<Ele>(){
            @Override
            public int compare(Ele a, Ele b) {
                return (int)(a.f - b.f);
            }
        });
        HashSet<Ele> hashSet = new HashSet<>();
        hashSet.add(new Ele(1, 1, 1));
        List<Double> res = new LinkedList<>();
        while (res.size() < k) {
            Ele cur = minHeap.poll();
            res.add(cur.f);
            Ele extand1 = new Ele(cur.x + 1, cur.y, cur.z);
            Ele extand2 = new Ele(cur.x, cur.y + 1, cur.z);
            Ele extand3 = new Ele(cur.x, cur.y, cur.z + 1);
            if (!hashSet.contains(extand1))
                hashSet.add(extand1);
            if (!hashSet.contains(extand2))
                hashSet.add(extand2);
            if (!hashSet.contains(extand3))
                hashSet.add(extand3);
        }
        return res;
    }
    
    public static void main(String[] args) {
        SmallestKthValOfFunction s = new SmallestKthValOfFunction();
        for (double b : s.smallestKthVal(5))
            System.out.print(b + "  ");
        
    }
    
}
