/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment9;
import java.util.Stack;
import java.util.List;
import java.util.LinkedList;

/**
 *
 * @author Muzhi
 */
public class ReverseTheString {
    public char[] reverseAWord(String str) {
        assert str != null;
        char[] reverseWord = new char[str.length()];
        int indexOne = 0;
        int indexTwo = str.length() - 1;
        while (!(indexOne > indexTwo)) {
            reverseWord[indexOne] = str.charAt(indexTwo);
            reverseWord[indexTwo] = str.charAt(indexOne);
            indexOne++;
            indexTwo--;
        }
        return reverseWord;
    }
    
    public char[] reverseSentence(String sentence) {
        assert sentence != null;
        LinkedList<StringBuilder> stack = new LinkedList<StringBuilder>();
        char[] reverseResult = new char[sentence.length()];
        
        int indexOne = 0;
        int indexTwo = 0;
        for (indexOne = 0; indexOne < sentence.length(); indexOne++) {
            indexTwo = indexOne;
            StringBuilder word = new StringBuilder();
            if (sentence.charAt(indexOne) == ' ') {
                indexTwo += 1;
                
                while (indexTwo < sentence.length() && sentence.charAt(indexTwo) != ' ') {
                    word.append(sentence.charAt(indexTwo));
                    indexTwo++;
                }
                //stack.push(word);
                indexOne = indexTwo - 1;
            } else {
                while (indexOne < sentence.length() && sentence.charAt(indexOne) != ' ') {
                    word.append(sentence.charAt(indexOne));
                    indexOne++;
                }
                indexOne--;
            }
            stack.push(word);
        }
        StringBuilder strBuilder = new StringBuilder();
        int stackSize = stack.size();
        for (int index = 0; index < stackSize; index++) {
            strBuilder.append(stack.pop());
            strBuilder.append(' ');
        }
        
        reverseResult = strBuilder.toString().toCharArray();
        return reverseResult;
    }
    
}
