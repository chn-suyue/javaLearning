package jzoffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: suyue
 * @time: 2021/3/28 0:45
 */
public class J55_EntryNodeOfLoop {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        //方法1：用map存储每个节点出现的次数，如果超过1次，则return
        //时间复杂度：O(n)
        //空间复杂度：O(n)
        if (pHead == null) return null;
        Map<ListNode, Integer> map = new HashMap<>();
        ListNode node = pHead;
        while (node != null) {
            if (map.get(node) == null) {
                map.put(node, 1);
            } else {
                return node;
            }
            node = node.next;
        }
        return null;

        //方法2：
        //时间复杂度：O(n)
        //空间复杂度：O(1)

    }

}
