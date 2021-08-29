package jzoffer.leetcode;

import java.util.Stack;

/**
 * @description:
 * @author: suyue
 * @time: 2021/8/15 16:47
 */
public class jt09_CQueue {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack1.empty() && stack2.empty()) {
            return -1;
        }
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

}
