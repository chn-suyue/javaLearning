package jzoffer.leetcode;

/**
 * @description:
 * @author: suyue
 * @time: 2021/10/10 20:02
 */
public class JT54_kthLargest {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int result;
    private int num;

    public int kthLargest(TreeNode root, int k) {
        if (root == null) return 0;

        num = k;
        dfs(root);

        return result;
    }

    public void dfs(TreeNode node) {
        //递归终止条件
        if (node == null) return;
        if (num <= 0) return;

        dfs(node.right);

        if (--num == 0) {
            result = node.val;
            return;
        }

        dfs(node.left);
    }

}
