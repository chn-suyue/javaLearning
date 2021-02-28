package jzoffer;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: suyue
 * @time: 2021/2/28 14:48
 */
public class J26_Convert {

    public static TreeNode Convert(TreeNode pRootOfTree) {
        //思路：中序遍历二叉搜索树就已经排好序了，存入ArrayList，得到各节点引用值；再循环遍历list，更新left=list[i-1],right=list[i+1]
        //时间复杂度：O(n)，2n
        //空间复杂度：O(n)
        if (pRootOfTree == null) return null;
        List<TreeNode> list = new ArrayList<>();
        midOrder(pRootOfTree, list);
        if (list.size() > 1) {
            for (int i = 0; i < list.size() - 1; i++) {
                list.get(i + 1).left = list.get(i);
                list.get(i).right = list.get(i + 1);
            }
        }
        return list.get(0);
    }

    private static void midOrder(TreeNode pRootOfTree, List<TreeNode> list) {
        if (pRootOfTree == null) return;
        midOrder(pRootOfTree.left, list);
        list.add(pRootOfTree);
        midOrder(pRootOfTree.right, list);
    }

    public static void main(String[] args) {
        String[] str1 = {"10", "6", "14", "4", "8", "12", "16"};
        BinTree tree1 = new BinTree(str1);
        TreeNode head = Convert(tree1.getRoot());
        TreeNode tail = null;
        ArrayList<Integer> l2r = new ArrayList<>();
        ArrayList<Integer> r2l = new ArrayList<>();

        while (head != null) {
            l2r.add(head.val);
            tail = head;
            head = head.right;
        }
        while (tail != null) {
            r2l.add(tail.val);
            tail = tail.left;
        }
        System.out.println(JSON.toJSONString(l2r));
        System.out.println(JSON.toJSONString(r2l));

    }

}
