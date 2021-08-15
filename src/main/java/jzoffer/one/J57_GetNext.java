package jzoffer.one;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: suyue
 * @time: 2021/3/28 21:28
 */
public class J57_GetNext {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;//指向父结点

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    List<TreeLinkNode> list;

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        //方法1：通过pnode找到根节点，根据只有根节点的next==null这个特征找到。之后，中序遍历二叉树，并存储到list，再找到pnode下一个节点即可
        //时间复杂度：O(n)，2n
        //空间复杂度：O(n)
        if (pNode == null) return null;
        list = new ArrayList<>();
        TreeLinkNode tNode = pNode;
        while (tNode.next != null) {
            tNode = tNode.next;
        }
        //中序遍历
        midOrder(tNode);
        return list.indexOf(pNode) < list.size() - 1 ? list.get(list.indexOf(pNode) + 1) : null;

        //方法2：分类讨论，每种情况对应处理，时间复杂度和空间复杂度可以优化，下次有时间再思考下

    }

    private void midOrder(TreeLinkNode node) {
        if (node == null) return;
        midOrder(node.left);
        list.add(node);
        midOrder(node.right);
    }


}
