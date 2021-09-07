package jzoffer.leetcode;

import java.util.Stack;

/**
 * @description:
 * @author: suyue
 * @time: 2021/8/29 21:12
 */
public class JT06_reversePrint {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {

        Stack<Integer> stack = new Stack<>();
        ListNode node = head;
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }

        int size = stack.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = stack.pop();
        }

        return result;

    }

}
