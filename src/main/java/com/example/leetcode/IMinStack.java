package com.example.leetcode;

import java.util.List;

public interface IMinStack {
    void push(int x);
    void pop();
    int top();
    int getMin();
}
