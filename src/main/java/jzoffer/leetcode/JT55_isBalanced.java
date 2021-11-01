package jzoffer.leetcode;

import java.util.Arrays;

/**
 * @description:
 * @author: suyue
 * @time: 2021/10/24 15:06
 */
public class JT55_isBalanced {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        //思路：若二叉树为平衡二叉树，则左右子树也为平衡二叉树，且深度差为不超过1
        if (root == null) return true;
        return isBalanced(root.left) && isBalanced(root.right)
                && getMaxDepth(root.left) - getMaxDepth(root.right) >= -1
                && getMaxDepth(root.left) - getMaxDepth(root.right) <= 1;
    }

    public int getMaxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getMaxDepth(root.left), getMaxDepth(root.right)) + 1;
    }


    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] newData;
        newData = Arrays.copyOfRange(data, 2, 7);
        for (int i : newData)
            System.out.print(i + " ");
    }

}
