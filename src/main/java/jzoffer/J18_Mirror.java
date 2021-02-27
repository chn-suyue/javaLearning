package jzoffer;

/**
 * @description:
 * @author: suyue
 * @time: 2021/2/20 18:13
 */
public class J18_Mirror {

    public void Mirror(TreeNode root) {
        //递归。递归函数Mirror的功能：二叉树镜像。
        if (root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }

    public static void main(String[] args) {

    }
}
