/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leetcode;

import java.util.LinkedList;

/**
 *
 * @author Muzhi
 */
public class MinStack {
    
    /**********  Use LinkedList<Integer> space complexity larger than use Node(int) structed by yourself  ************/
    LinkedList<Integer> mainStack;
    LinkedList<Integer> minNum;
    
    public MinStack() {
        mainStack = new LinkedList<Integer>();
        minNum = new LinkedList<Integer>();
    }
    
    public int pop() {
        if (mainStack == null || mainStack.isEmpty()) 
            return Integer.MAX_VALUE;
        int popInt = mainStack.pollFirst();
        if (popInt == minNum.peek()) 
            minNum.pollFirst();
        return popInt;
    }
    
    public void push(int x) {
        if ((mainStack == null || mainStack.isEmpty()) || (x <= minNum.peek())) 
            minNum.offerFirst(x);
        mainStack.offerFirst(x);
    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public int min() {
        return minNum.peek();
    }
    
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(5);
        minStack.push(1);
        minStack.push(7);
        System.out.println(minStack.min() + " " + minStack.top());
        minStack.pop();
        minStack.pop();
        System.out.println(minStack.min() + " " + minStack.top());
        
    }
    
}
