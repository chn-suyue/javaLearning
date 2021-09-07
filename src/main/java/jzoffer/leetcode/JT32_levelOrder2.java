package jzoffer.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description:
 * @author: suyue
 * @time: 2021/9/7 20:36
 */
public class JT32_levelOrder2 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root==null) return result;

        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size>0) {
                root = queue.poll();
                list.add(root.val);
                if (root.left!=null) queue.add(root.left);
                if (root.right!=null) queue.add(root.right);
                size--;
            }
            result.add(new ArrayList(list));
            list.clear();
        }

        return result;

    }

}
