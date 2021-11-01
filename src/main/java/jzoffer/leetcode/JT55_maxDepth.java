package jzoffer.leetcode;

/**
 * @description:
 * @author: suyue
 * @time: 2021/10/24 14:44
 */
public class JT55_maxDepth {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        //方法一：BFS遍历二叉树，计数器记录树的深度
        /*if (root == null) return 0;

        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }

        return depth;*/

        //方法二：DFS递归求树的深度
        //递归函数功能，入参及返回值
        //递归终止条件
        //单层递归逻辑
        if (root == null) return 0;

        int depth = 0;
        depth = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;

        return depth;

    }

}
