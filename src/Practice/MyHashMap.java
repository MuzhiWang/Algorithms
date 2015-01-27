/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.util.Arrays;

/**
 *
 * @author Muzhi
 */
public class MyHashMap<K, V> implements MyMap<K, V> {
    
    static class Node<K, V> implements Entry<K, V> {
        
        final K key;
        
        V value;
        
        Node<K, V> next;
        
        Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
        
        @Override
        public K getKey() {
            return key;
        }
        
        @Override
        public V getValue() {
            return value;
        }
        
        @Override
        public V setValue(V value) {
            V old = this.value;
            this.value = value;
            return old;
        }
        
        @Override 
        public String toString() {
            return String.valueOf(key) + ":" + String.valueOf(value);
        }
    }
    
    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    
    private int size;
    private Node<K, V>[] table;
    private final float loadFactor;
    
    public MyHashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }
    
    public MyHashMap(int capacity) {
        this(capacity, DEFAULT_LOAD_FACTOR);                // mark... grasp it
    }
    
    public MyHashMap(int capacity, float factor) {
        assert capacity > 0;
        assert factor > 0 && factor < 1f;
        this.table = (Node<K, V>[]) new Node[capacity];     // mark... grasp it.
        this.loadFactor = factor;
    }
    
    @Override
    public int size() {
        return this.size;
    }
    
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    @Override
    public void clear() {
        Arrays.fill(this.table, null);      //mark, grasp it.
    }
    
    //@Override
    private int hash(K key) {
        if (key == null) 
            return 0;
        return key.hashCode();
    }
    
    private int getBucketIndex(K key) {
        return hash(key) % table.length;
    }
    
    private boolean equalsKey(K key1, K key2) {
        return key1 == key2 || key1 != null && key1.equals(key2);
    }
    
    private Node<K, V> findNode(K key, Node<K, V> node) {
        while (node != null) {
            if (equalsKey(key, node.key))
                return node;
            node = node.next;
        }
        return null;
        
    }
    
    private Node<K, V> getNode(K key) {
        if (isEmpty())
            return null;
        int bucketIndex = getBucketIndex(key);
        return findNode(key, table[bucketIndex]);
    }
    
    @Override 
    public boolean containsKey(K key) {
        return getNode(key) != null;
    }
    
    private boolean equalsValue(V value1, V value2) {
        return value1 == value2 || value1 != null && value1.equals(value2);
    }
    
    @Override 
    public boolean containsValue(V value) {
        if (isEmpty())
            return false;
        
        for (Node<K, V> node : table) {
            while (node != null) {
                if (equalsValue(value, node.value))
                    return true;
                node = node.next;
            }
        }
        return false;
    }
    
    @Override
    public void put(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        Node<K, V> node = findNode(key, table[bucketIndex]);
        
        if (node == null) {
            table[bucketIndex] = new Node<K, V>(key, value, null);
            ++size;
            // expand the table if necessary
            rehash();
            return;
        } else {
            node.setValue(value);
        }
    }
    
    private void rehash() {
        if (size > table.length * loadFactor) {
            Node<K, V>[] oldTable = this.table;
            this.table = (Node<K, V>[]) new Node[table.length << 1];
            for (Node<K, V> node : oldTable) {
                while (node != null) {
                    Node<K, V> next = node.next;
                    int bucketIndex = getBucketIndex(node.key);
                    node.next = table[bucketIndex];
                    table[bucketIndex] = node;
                    node = next;
                }
            }
        }
    }
    
    @Override
    public V get(K key) {
        if (getNode(key) != null) 
            return getNode(key).value;
        else
            return null;
    } 
    
    @Override
    public void remove(K key) {
        if (isEmpty())
            return;
        int bucketIndex = getBucketIndex(key);
        Node<K, V> node = table[bucketIndex];
        if (node == null)
            return;
        if (equalsKey(key, node.key)) {
            table[bucketIndex] = node.next;
            --size;
            return;
        }
        while (node.next != null) {
            if (equalsKey(key, node.next.key)) {        // mark... grasp it.
                node.next = node.next.next;
                --size;
                return;
            }
        }
    }
}
