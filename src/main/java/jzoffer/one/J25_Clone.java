package jzoffer.one;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: suyue
 * @time: 2021/2/27 17:00
 */
public class J25_Clone {

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead) {
        //深拷贝：在堆内存中开辟新的内存空间来存储目标对象的属性值，新的对象和原来的对象互不影响。
        //浅拷贝：拷贝引用值
        //思路：先遍历一次目标链表，初始化新链表节点，并使用map存储；再遍历一次目标链表，对新链表节点next和random属性赋值
        if (pHead == null) return null;
        RandomListNode pNode1 = pHead;
        RandomListNode pNode2 = pHead;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while (pNode1 != null) {
            map.put(pNode1, new RandomListNode(pNode1.label));
            pNode1 = pNode1.next;
        }
        RandomListNode rHead = map.get(pNode2);
        RandomListNode rNode = rHead;
        while (pNode2 != null) {
            rNode.next = map.get(pNode2.next);
            rNode.random = map.get(pNode2.random);
            pNode2 = pNode2.next;
            rNode = rNode.next;
        }
        return rHead;
    }


}
