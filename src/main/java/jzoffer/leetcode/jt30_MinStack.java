package jzoffer.leetcode;

import java.util.Stack;

/**
 * @description:
 * @author: suyue
 * @time: 2021/8/15 17:35
 */
public class jt30_MinStack {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }

    public void push(int x) {
        stack1.push(x);
        if (stack2.empty()) {
            stack2.push(x);
        } else {
            stack2.push(Math.min(x,stack2.peek()));
        }
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }

}
