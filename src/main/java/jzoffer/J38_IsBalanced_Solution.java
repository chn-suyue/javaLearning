package jzoffer;

/**
 * @description:
 * @author: suyue
 * @time: 2021/3/13 2:20
 */
public class J38_IsBalanced_Solution {

    public boolean IsBalanced_Solution(TreeNode root) {
        //思路：二叉树，递归。
        if (root == null) return true;
        if (Math.abs(treeDepth(root.left) - treeDepth(root.right)) > 1) return false;
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);

    }

    private int treeDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return Math.max(treeDepth(root.left) + 1, treeDepth(root.right) + 1);
    }

}
