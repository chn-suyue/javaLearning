package jzoffer.newcode;

/**
 * @description:
 * @author: suyue
 * @time: 2021/2/18 14:03
 */
public class J15_ReverseList {

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

    public static ListNode ReverseList(ListNode head) {
        //方法1：开辟一个list存放遍历出来的链表，在用尾插法把list中的元素构造新的倒序链表
        //时间复杂度：O(n+n)
        //空间复杂度：O(n)
        /*if (head == null) return null;
        List<ListNode> nodes = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            nodes.add(node);
            node = node.next;
        }
        Collections.reverse(nodes);
        ListNode newHead = nodes.get(0);
        ListNode newNode = newHead;
        for (int i = 1; i < nodes.size(); i++) {
            newNode.next = nodes.get(i);
            newNode = newNode.next;
            if (i == nodes.size() - 1) {
                newNode.next = null;
            }
        }
        return newHead;*/

        //方法2：使用三个指针保存当前节点、前节点、后节点的引用，然后赋值并循环处理
        //时间复杂度：O(n)
        //空间复杂度：O(1)
        if (head == null) return null;
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;

    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        ListNode head = initLinkedList(array);
        ListNode listNode = ReverseList(head);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

}
