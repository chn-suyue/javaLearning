package jzoffer.one;

/**
 * @description:
 * @author: suyue
 * @time: 2021/3/13 2:00
 */
public class J37_TreeDepth {

    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }

}
