package jzoffer.newcode;

/**
 * @description:
 * @author: suyue
 * @time: 2021/2/17 17:50
 */
public class J14_FindKthToTail {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    //通过数组初始化单链表
    public static ListNode initLinkedList(int[] array) {
        if (array.length == 0) return null;

        ListNode head = new ListNode(array[0]);
        ListNode node = head;
        for (int i = 1; i < array.length; i++) {
            node.next = new ListNode(array[i]);
            node = node.next;
        }
        return head;
    }

    public static ListNode FindKthToTail(ListNode head, int k) {
        //方法1：如果链表的节点数为n，那么倒数第K个节点，就是顺数第n-k+1个节点，也即是第n-k个节点的next。
        //时间复杂度：O(n)，具体为2n
        //空间复杂度：O(1)
        /*if (head == null || k <= 0) return null;
        int n = 1;
        ListNode node = head;
        while (node.next != null) {
            n++;
            node = node.next;
        }
        if (n < k) return null;
        node = head;
        for (int i = 0; i < n - k; i++) {
            node = node.next;
        }
        return node;*/

        //方法2：使用双指针，利用相对位置，遍历一遍链表即可找出倒数第K个节点。
        //时间复杂度：O(n)
        //空间复杂度：O(1)
        if (head == null || k <= 0) return null;
        ListNode mNode = head;
        ListNode nNode = head;
        int n = k;
        while (n > 0 && nNode != null) {
            nNode = nNode.next;
            n--;
        }
        if (nNode == null && n>0) return null;
        while (nNode != null) {
            mNode = mNode.next;
            nNode = nNode.next;
        }
        return mNode;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        ListNode head = initLinkedList(array);
        ListNode listNode = FindKthToTail(head, 5);
        System.out.println(listNode.val);

    }

}
