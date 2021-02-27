package jzoffer;

import java.util.Stack;

/**
 * @description:
 * @author: suyue
 * @time: 2021/2/22 20:12
 */
public class J20_Solution {

    Stack<Integer> stack = new Stack<>();

    Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        if (minStack.empty()) {
            minStack.push(node);
        } else {
            minStack.push(Math.min(stack.peek(),node));
        }
        stack.push(node);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }

}
