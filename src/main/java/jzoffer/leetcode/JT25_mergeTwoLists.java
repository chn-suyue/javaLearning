package jzoffer.leetcode;

/**
 * @description:
 * @author: suyue
 * @time: 2021/9/19 16:44
 */
public class JT25_mergeTwoLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //思路：新建一个头结点，分别遍历两个链表，比较大小逐一添加到新建头结点后面
        //时间复杂度：O(n)
        //空间复杂度：O(1)
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head = new ListNode(0);
        ListNode node = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        if (l1 != null) {
            node.next = l1;
        }
        if (l2 != null) {
            node.next = l2;
        }

        return head.next;

    }

}
