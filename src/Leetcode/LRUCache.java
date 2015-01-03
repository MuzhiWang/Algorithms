/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leetcode;

import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author Muzhi
 */
public class LRUCache {
    /********* This solution has not be tested, there is some problem with HashMap<Integer, LRUunit> ***********/
    
    LinkedList<LRUunit> LRU;
    HashMap<Integer ,LRUunit> hashMap = new HashMap<Integer ,LRUunit>();
    int capacity;
    int len;
    public LRUCache(int capacity) {
        this.LRU = new LinkedList<LRUunit>();
        //LRU.ensureCapacity();
        this.capacity = capacity;
        this.len = 0;
    }
    
    public int get(int key) {
        if (hashMap.containsKey(key)) return hashMap.get(key).value;
        return -1;
    }
    
    public void set(int key, int value) {
        if (get(key) != -1) {
            //LRUunit removeUnit = new LRUunit(key, value);
            LRUunit removeUnit = this.LRU.get(key);
            LRU.remove(key);
            LRU.addFirst(removeUnit);
        } else {
            LRUunit addUnit = new LRUunit(key, value);
            if (this.len < this.capacity) {
                LRU.addFirst(addUnit);
                hashMap.put(key, addUnit);
                this.len++;
            } else {
                //LRUunit removeUnit = hashMap.get(LRU.getLast().key);
                LRUunit removeUnit = LRU.getLast();
                LRU.removeLast();
                hashMap.remove(removeUnit.key);
                LRU.addFirst(addUnit);
                hashMap.put(key, addUnit);
            }
        }
    }
    
    public class LRUunit {
        int value;
        int key;
        //int index;
        LRUunit(int key, int value) {
            this.value = value;
            this.key = key;
            //this.index = 0;
        }
    }
    
    public static void main(String[] args) {
        LRUCache LRUcache = new LRUCache(5);
        System.out.println(LRUcache.get(1));
        LRUcache.set(0, 0);
        LRUcache.set(1, 1);
        LRUcache.set(2, 2);
        LRUcache.set(3, 3);
        LRUcache.set(4, 4);
        LRUcache.set(2, 2);
        LRUcache.set(4, 4);
        System.out.println(LRUcache.get(1));
        System.out.println(LRUcache.get(1));
        System.out.println(LRUcache.get(1));
        System.out.println(LRUcache.get(1));
        
        
    }
    
}
