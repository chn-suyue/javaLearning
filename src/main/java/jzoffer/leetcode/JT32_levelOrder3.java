package jzoffer.leetcode;

import java.util.*;

/**
 * @description:
 * @author: suyue
 * @time: 2021/9/8 20:17
 */
public class JT32_levelOrder3 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;

        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node = root;
        queue.add(node);
        int count = 0;

        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            while (size > 0) {
                node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                size--;
            }

            if (count % 2 == 0) {
                Collections.reverse(list);
            }

            result.add(new ArrayList<>(list));
            list.clear();
        }

        return result;

    }

}
