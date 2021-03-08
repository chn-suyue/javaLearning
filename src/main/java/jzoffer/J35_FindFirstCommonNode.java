package jzoffer;

/**
 * @description:
 * @author: suyue
 * @time: 2021/3/8 20:00
 */
public class J35_FindFirstCommonNode {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        //方法1：分别遍历链表1和链表2，将节点存在两个list，遍历其中一个list判断另一个list是否包含该节点
        /*if (pHead1 == null || pHead2 == null) return null;
        ListNode result = null;
        ArrayList<ListNode> list1 = new ArrayList<>();
        ArrayList<ListNode> list2 = new ArrayList<>();
        ListNode node1 = pHead1;
        ListNode node2 = pHead2;

        while (node1 != null) {
            list1.add(node1);
            node1 = node1.next;
        }
        while (node2 != null) {
            list2.add(node2);
            node2 = node2.next;
        }

        for (ListNode n : list1) {
            if (list2.contains(n)) {
                result = n;
            }
        }
        return result;*/

        //方法2：如果两个链表有公共节点，那么如果链表1拼接链表2，链表2拼接链表1，得到的这两个新的链表最后几个节点必然相等，且两个新链表长度相等。
        if (pHead1 == null || pHead2 == null) return null;
        ListNode node1 = pHead1;
        ListNode node2 = pHead2;
        while (node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
            if (node1!=node2) {//防止无公共节点时陷入死循环
                if (node1 == null) node1 = pHead2;
                if (node2 == null) node2 = pHead1;
            }
        }
        return node1;
    }

}
