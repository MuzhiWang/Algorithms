/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment9;
import java.util.LinkedList;
import java.util.List;
import java.util.Deque;

/**
 *
 * @author Muzhi
 */
public class DeDuplicateAdjacentLetter {
    public char[] deDuplicate(String str) {
        assert str != null;
        if (str.isEmpty()) {                            // check null and empty corner case
            return null;
        }
        Deque<Character> stack = new LinkedList<Character>();
        stack.push(str.charAt(0));
        /*
        for (int index = 1; index < str.length(); index++) {
            if (!stack.isEmpty()) {
                if (str.charAt(index) != stack.peek()) {
                    stack.push(str.charAt(index));
                } else {
                    if (index < str.length() - 1) {                             // when detect there are duplicated adjacent letter, pop the stack
                        while (str.charAt(index) == stack.peek()) {
                            index++;
                        }
                        stack.pop();
                    } else {
                        if (str.charAt(index) == stack.peek()) {                //this is what I am confused about. 
                            stack.pop();                                        //I did the extra work to make up the corner case when the index point to the last letter of str.
                        } else {
                            stack.push(str.charAt(index));
                        }
                        break;
                    }
                    index--;
                }
            } else {
                stack.push(str.charAt(index));
            }
        }
        */
        for (int index = 1; index < str.length(); index++) {
            if (stack.isEmpty() || str.charAt(index) != stack.peek()) {
                stack.push(str.charAt(index));
            } else {
                while (index < str.length() - 1 && str.charAt(index + 1) == stack.peek()) {
                    index++;
                }
                stack.pop();
            }
        }
        char[] result = new char[stack.size()];
        if (stack.isEmpty()) {
            return null;
        } else {
            for (int i = 0; i < stack.size(); i++) {
                result[i] = stack.pop();
            }
        }
        return result;
    }
    
}
