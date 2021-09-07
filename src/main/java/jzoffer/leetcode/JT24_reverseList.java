package jzoffer.leetcode;

/**
 * @description:
 * @author: suyue
 * @time: 2021/8/29 21:36
 */
public class JT24_reverseList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {

        ListNode cur = head;
        ListNode pre = null;

        while (cur!=null) {
            ListNode post = cur.next;
            cur.next = pre;
            pre = cur;
            cur = post;
        }

        return pre;
    }

}
