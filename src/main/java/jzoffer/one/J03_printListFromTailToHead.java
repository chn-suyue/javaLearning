package jzoffer.one;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;

/**
 * @description: 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * 示例：
 * 输入：{67,0,24,58}
 * 输出：[58,24,0,67]
 * @author: suyue
 * @time: 2021/1/9 17:00
 */
public class J03_printListFromTailToHead {

    public static class ListNode {
        private int val;
        private ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    //通过数组初始化单链表
    public static ListNode initLinkedList(int[] array) {
        if (array.length==0) return null;

        ListNode head = new ListNode(array[0]);
        ListNode node = head;
        for (int i = 1; i < array.length; i++) {
            node.next = new ListNode(array[i]);
            node = node.next;
        }
        return head;
    }

    private static ArrayList<Integer> list = new ArrayList<>();

    public static void printListFromTailToHead(ListNode listNode) {
        //方法1：非递归
        //先遍历链表，从头到尾将val放到list，再将list中的元素反转
        /*ListNode temp = listNode;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        Collections.reverse(list);*/

        //方法2：非递归
        //使用list.add(index,value), list.add(0,value)相当于头插法插入list
        /*ListNode temp = listNode;
        while (temp != null) {
            list.add(0,temp.val);
            temp = temp.next;
        }*/

        //方法3：递归
        if (listNode != null) {
            printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }

    }

    public static void main(String[] args) {
        int[] array = {67,0,24,58};
        ListNode head = initLinkedList(array);
        printListFromTailToHead(head);
        System.out.println(JSON.toJSONString(list));
    }

}
