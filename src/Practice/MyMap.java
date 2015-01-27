/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

/**
 *
 * @author Muzhi
 */
public interface MyMap<K, V> {
    //int num = 0;
    int size();
    
    boolean isEmpty();
    
    void clear();
    
    boolean containsKey(K key);
    
    boolean containsValue(V value);
    
    void put(K key, V value);
    
    V get(K key);
    
    void remove(K key);
    
    interface Entry<K, V> {
        
        K getKey();
        
        V getValue();
        
        V setValue(V value);
    }
    
}
