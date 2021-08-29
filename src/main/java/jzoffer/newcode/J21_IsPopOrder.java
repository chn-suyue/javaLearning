package jzoffer.newcode;

import java.util.Stack;

/**
 * @description:
 * @author: suyue
 * @time: 2021/2/23 20:52
 */
public class J21_IsPopOrder {

    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        // 模拟入栈出栈操作。
        // 时间复杂度：O(n), 2n
        // 空间复杂度：O(n)
        if (pushA == null || pushA.length == 0 || popA == null || popA.length == 0) return false;
        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;
        while (i < pushA.length) {
            if (pushA[i] != popA[j]) {
                stack.push(pushA[i]);
                i++;
            } else {
                i++;
                j++;
                while (!stack.empty() && stack.peek() == popA[j]) {
                    stack.pop();
                    j++;
                }
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4, 3, 5, 2, 1};
        boolean result = IsPopOrder(pushA, popA);
        if (result) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

}
