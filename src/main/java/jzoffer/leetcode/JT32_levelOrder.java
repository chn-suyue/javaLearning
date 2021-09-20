package jzoffer.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description:
 * @author: suyue
 * @time: 2021/9/6 18:26
 */
public class JT32_levelOrder {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public int[] levelOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root==null) return new int[0];

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node = root;
        queue.add(node);

        while (!queue.isEmpty()) {
            node = queue.poll();
            list.add(node.val);
            if (node.left!=null) queue.add(node.left);
            if (node.right!=null) queue.add(node.right);
        }

        int[] result = new int[list.size()];
        if (list!=null || list.size()>0) {
            for (int i=0; i<list.size(); i++) {
                result[i] = list.get(i);
            }
        }

        return result;

    }

}
