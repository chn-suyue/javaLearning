package jzoffer;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * @author: suyue
 * @time: 2021/1/9 19:13
 */
public class J04_reConstructBinaryTree {

    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static List<Integer> pre;

    private static List<Integer> in;

    //前序遍历二叉树
    public static void preTree(TreeNode root) {
        if (root == null) return;
        pre.add(root.val);
        preTree(root.left);
        preTree(root.right);
    }

    //中序遍历二叉树
    public static void inTree(TreeNode root) {
        if (root == null) return;
        inTree(root.left);
        in.add(root.val);
        inTree(root.right);
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) return null;
        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            // 在中序中找到前序的根值
            if (pre[0] == in[i]) {
                // 左子树，注意 copyOfRange 函数，左闭右开
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                // 右子树，注意 copyOfRange 函数，左闭右开
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] preArray = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inArray = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = reConstructBinaryTree(preArray, inArray);

        pre = new ArrayList<>();
        preTree(root);
        System.out.println(JSON.toJSONString(pre));

        in = new ArrayList<>();
        inTree(root);
        System.out.println(JSON.toJSONString(in));
    }

}
