package jzoffer.newcode;

import java.util.Stack;

/**
 * @description: 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * @author: suyue
 * @time: 2021/1/9 20:21
 */
public class J05_pushAndPop {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.size() == 0) {
            while (stack1.size()>0) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

}
