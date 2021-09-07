package jzoffer.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: suyue
 * @time: 2021/8/29 21:46
 */
public class JT35_copyRandomList {

    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {

        Node node1 = head;
        Map<Node, Node> map = new HashMap<>();
        while (node1 != null) {
            map.put(node1, new Node(node1.val));
            node1 = node1.next;
        }


        Node newHead = map.get(head);
        Node node2 = head;
        while (node2 != null) {
            Node node = map.get(node2);
            node.next = map.get(node2.next);
            node.random = map.get(node2.random);
            node2 = node2.next;
        }

        return newHead;
    }

}
