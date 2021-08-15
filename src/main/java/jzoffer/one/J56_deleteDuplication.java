package jzoffer.one;

/**
 * @description:
 * @author: suyue
 * @time: 2021/3/28 1:07
 */
public class J56_deleteDuplication {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    //通过数组初始化单链表
    public static ListNode initLinkedList(int[] array) {
        if (array == null || array.length == 0) return null;

        ListNode head = new ListNode(array[0]);
        ListNode node = head;
        for (int i = 1; i < array.length; i++) {
            node.next = new ListNode(array[i]);
            node = node.next;
        }
        return head;

    }

    public static ListNode deleteDuplication(ListNode pHead) {
        //自己的思路：先遍历一遍，把重复节点都给找出来，再遍历第二遍，把重复节点删除
        //时间复杂度：O(n)，2n
        //空间复杂度：O(n)
        /*if (pHead == null) return null;
        Set<ListNode> set = new HashSet<>();
        ListNode node1 = pHead;
        ListNode node2 = pHead.next;
        while (node2 != null) {//遍历第一遍将重复节点找出来
            if (node1.val == node2.val) {
                set.add(node1);
                set.add(node2);
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        node1 = pHead;
        node2 = pHead.next;
        while (node2 != null) {//遍历第二遍将重复节点删除
            if (set.contains(node2)) {
                node1.next = node2.next;
                node2 = node2.next;
            } else {
                node1 = node1.next;
                node2 = node2.next;
            }
        }
        return set.contains(pHead) ? pHead.next : pHead;//最后判断头结点是否重复*/

        //方法2：优化方法1，遍历的同时，删除重复节点。双指针，cur指向当前节点，pre指向当前节点的前驱节点。
        if (pHead == null) return null;
        ListNode virHead = new ListNode(-1);//虚拟头结点，方便处理删除操作
        virHead.next=pHead;
        ListNode pre = virHead;
        ListNode cur = pHead;
        boolean dupFlag = false;
        while (cur!=null){
            while (cur.next!=null && cur.val==cur.next.val) {//cur节点的后继节点是否有重复，有重复的将cur.val对应的所有重复节点都找出来
                cur = cur.next;
                dupFlag=true;
            }
            if (dupFlag) {//如果重复了，pre不变，cur指向最后一个重复节点的下一个节点
                pre.next=cur.next;
                cur = cur.next;
                dupFlag=false;
            } else {//如果没有重复
                pre = cur;
                cur = cur.next;
            }
        }
        return virHead.next;

    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 4, 4, 5};
        ListNode head = initLinkedList(array);
        ListNode newHead = deleteDuplication(head);
        ListNode node = newHead;
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

}
