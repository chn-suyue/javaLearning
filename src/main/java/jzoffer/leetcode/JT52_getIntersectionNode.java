package jzoffer.leetcode;

/**
 * @description:
 * @author: suyue
 * @time: 2021/9/19 16:46
 */
public class JT52_getIntersectionNode {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //思路：链表1和链表2可以拼接为一个链表，链表2和链表1也可以拼接为一个链表。这两个链表同时遍历，当两个链表节点相等时，即是要找的目标节点。
        //时间复杂度：O(n)
        //空间复杂度：O(1)
        if (headA == null || headB == null) return null;

        ListNode node1 = headA;
        ListNode node2 = headB;
        int num1 = 0;
        int num2 = 0;

        while (num1 <= 1 && num2 <= 1) {
            if (node1 == null) {
                node1 = headB;
                num1++;
            }
            if (node2 == null) {
                node2 = headA;
                num2++;
            }
            if (node1 == node2) {
                return node1;
            }
            node1 = node1.next;
            node2 = node2.next;
        }

        return null;
    }

}
