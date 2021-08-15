package jzoffer.one;

/**
 * @description:
 * @author: suyue
 * @time: 2021/2/18 16:01
 */
public class J16_Merge {

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

    public static ListNode Merge(ListNode list1, ListNode list2) {
        //方法1：新开辟一个list，分别遍历两个单链表，选择两者较小的数放入list，然后重复。最后用list新建一个单链表
        //时间复杂度：O(m+n)，2*（m+n）
        //空间复杂度：O(m+n)，2*（m+n）
        /*if (list1==null && list2==null) return null;
        List<ListNode> tList = new ArrayList<>();
        ListNode node1 = list1;
        ListNode node2 = list2;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                tList.add(node1);
                node1 = node1.next;
            } else {
                tList.add(node2);
                node2 = node2.next;
            }
        }
        if (node1 != null) {
            while (node1!=null) {
                tList.add(node1);
                node1 = node1.next;
            }
        }
        if (node2 != null) {
            while (node2!=null){
                tList.add(node2);
                node2 = node2.next;
            }
        }

        ListNode head = tList.get(0);
        ListNode node = head;
        for (int i = 1; i < tList.size(); i++) {
            node.next = tList.get(i);
            node = node.next;
            if (i == tList.size() - 1) node.next = null;
        }
        return head;*/

        //方法2：迭代。使用指针cur指向当前需要处理的节点，node1和node2指向两个单链表最前面待处理的节点。cur.next赋值node1和node2之间值较小的节点，然后循环处理.
        //时间复杂度：O(m+n)
        //空间复杂度：O(1)
        /*if (list1 == null && list2 == null) return null;
        ListNode head = new ListNode(0);
        ListNode node1 = list1;
        ListNode node2 = list2;

        ListNode cur = head;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                cur.next = node1;
                node1 = node1.next;
            } else {
                cur.next = node2;
                node2 = node2.next;
            }
            cur = cur.next;
        }
        cur.next = node1 != null ? node1 : node2;
        return head.next;*/

        //方法3：递归。写递归代码，最重要的要明白递归函数的功能。可以不必关心递归函数的具体实现。比如这里Merge函数功能：合并两个单链表，返回两个单链表头结点值小的那个节点
        //时间复杂度：O(m+n)
        //空间复杂度：O(1)
        if (list1 == null && list2 == null) return null;
        if (list1 != null && list2 == null) return list1;
        if (list1 == null && list2 != null) return list2;

        if (list1.val < list2.val) {
            list1.next = Merge(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge(list1, list2.next);
            return list2;
        }

    }

    public static void main(String[] args) {
        int[] array1 = {1, 3, 5};
        ListNode head1 = initLinkedList(array1);
        int[] array2 = {2, 4, 6, 8};
        ListNode head2 = initLinkedList(array2);
        ListNode node = Merge(head1, head2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }

}
