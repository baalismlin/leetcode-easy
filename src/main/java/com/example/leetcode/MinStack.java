package com.example.leetcode;

import java.util.Stack;

public class MinStack implements IMinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack(){
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    @Override
    public void push(int x) {
        stack.push(x);
        if(minStack.size() == 0 || minStack.peek() >= x){
            minStack.push(x);
        }
    }

    @Override
    public void pop() {
        int top = stack.pop();
        if(top == minStack.peek()){
            minStack.pop();
        }
    }

    @Override
    public int top() {
        return stack.peek();
    }

    @Override
    public int getMin() {
        return minStack.peek();
    }
}
