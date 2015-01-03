/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment6;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

//import java.util.Comparator;

/**
 *
 * @author Muzhi
 */
public class TopKFrequent {
    /*
    private static class WordFreq implements Comparable<WordFreq> {
        String word;
        long frequency;
        
        public WordFreq(String word, long frequency) {
            this.word = word;
            this.frequency = frequency;
        }
        
        @Override
        public String toString() {
            return word + ":" + frequency;
        }
        
        @Override
        public int compareTo(WordFreq another) {
            long diff = this.frequency - another.frequency;
            if (diff == 0) {
                return 0;
            } else if (diff < 0) {
                return -1;
            } else {
                return 1;
            }
        }
    }
    
    public List<WordFreq> topK(int k, List<String> words) {
        assert words != null;
        
        Map<String, Long> freqMap = frequencyMap(words);
        
        PriorityQueue<WordFreq> freqHeap = frequencyHeap(k, freqMap);
        return topList(freqHeap);
    }
    
    private List<WordFreq> topList(PriorityQueue<WordFreq> freqHeap) {
        List<WordFreq> result = new ArrayList<WordFreq>();
        while (!freqHeap.isEmpty()) {
            result.add(freqHeap.poll());
        }
        return result;
    }
    
    private PriorityQueue<WordFreq> frequencyHeap(int k, Map<String, Long> freqMap) {
        ArrayList<WordFreq> heapifyCandidate = new ArrayList<WordFreq>();
        PriorityQueue<WordFreq> minHeap = null;
        int count = 0;
        for (Entry<String, Long> entry : freqMap.entrySet()) {
            if (count < k - 1) {
                heapifyCandidate.add(new WordFreq(entry.getValue()));
                minHeap = new PriorityQueue<WordFreq>(heapifyCandidate);
            } else if (entry.getValue().longValue() > minHeap.peek().frequency) {
                minHeap.poll();
                minHeap.offer(new WordFreq(entry.getKey(), entry.getValue()));
            }
            count++;
        }
        if (freqMap.size() <= k) {
            minHeap = new PriorityQueue<WordFreq>(heapifyCandidate);
        }
        return minHeap;
    }
    
    private Map<String, Long> frequencyMap(List<String> words) {
        Map<String, Long> freqMap = new HashMap<String, Long>();
        for (String word : words) {
            if (!freqMap.containsKey(word)) {
                freqMap.put(word, 1L);
            } else {
                freqMap.put(word, freqMap.get(word) + 1L);
            }
        }
        return freqMap;
    }
    */
    public char[] topKFrequent(String str, int k) {
        assert str != null;
        char[] result = new char[k];
        if (k > str.length()) {
            result = str.toCharArray();
            return result;
        }
        
        Map<Character, Integer> hashMap = new HashMap<Character, Integer>();
        PriorityQueue<charEntry> minHeap = new PriorityQueue<charEntry>(k, new charComparator());
        List<charEntry> entry = new ArrayList<charEntry>();
        
        /*
        for (int i = 0; i < str.length(); i++) { 
            entry.add(new charEntry(str.charAt(i), 1));
        }
        */
        
        for (int i =0; i < str.length(); ++i) {
            if (hashMap.containsKey(str.charAt(i))) {
                hashMap.put(str.charAt(i), hashMap.get(str.charAt(i)) + 1);
            } else {
                hashMap.put(str.charAt(i), 1);
            }
        }
        
/*****************  the part below is important **********************/
        int index = 0;
        char strKey;
        for (Iterator testEntry = hashMap.entrySet().iterator(); testEntry.hasNext();) {        // This part transfer the hashMap to 
            Map.Entry entryTemp = (Map.Entry)testEntry.next();
            entry.add(new charEntry((char)entryTemp.getKey(), (int)entryTemp.getValue()));      //the Entry so that it could be put into the minHeap;
        }
/************************************************************************/        
        
        for (Iterator<Character> iter = hashMap.keySet().iterator(); iter.hasNext();) {          
            strKey = iter.next();
            //entry.add(new charEntry(strKey, hashMap.get(strKey)));
            if (minHeap.size() < k) {
                minHeap.add(entry.get(index));
            } else if (minHeap.size() == k && hashMap.get(minHeap.peek().strKey) < hashMap.get(strKey)) {
                minHeap.poll();
                minHeap.offer(entry.get(index));
            }
            index++;
        }
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll().strKey;
        }
        return result;
    }
    
    private class charEntry {
        char strKey;
        int strValue;
        private charEntry(char strKey, int strValue) {
            this.strKey = strKey;
            this.strValue = strValue;
        } 
    }
    
    public class charComparator implements Comparator<charEntry>{
        @Override
        public int compare(charEntry one, charEntry two) {
            return one.strValue - two.strValue;
        }
    }
    
}
