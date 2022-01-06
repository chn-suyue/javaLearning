package jzoffer.leetcode;

import java.util.Arrays;

/**
 * @description:
 * @author: suyue
 * @time: 2021/10/24 17:35
 */
public class JT07_buildTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //思路：递归
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) return null;

        TreeNode root = new TreeNode(preorder[0]);

        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                index = i;
                break;
            }
        }
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1), Arrays.copyOfRange(inorder, 0, index));
        root.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length), Arrays.copyOfRange(inorder, index + 1, inorder.length));

        return root;

    }

}
