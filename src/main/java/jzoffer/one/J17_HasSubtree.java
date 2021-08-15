package jzoffer.one;

/**
 * @description:
 * @author: suyue
 * @time: 2021/2/20 10:21
 */
public class J17_HasSubtree {

    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        //思路：首先.从树1中找到树2根节点值相同的节点。然后，分别比对左右子树是否为子结构。
        //递归函数HasSubtree的功能：根节点值不同时，判断root2是否为root1的子结构
        //递归函数SameRootHasSubtree的功能：根节点值相同时，判断root2是否为root1的子结构
        if (root1 == null || root2 == null) return false;
        boolean result = false;
        if (root1.val == root2.val) {
            result = SameRootHasSubtree(root1, root2);
        }
        if (!result) {
            result = HasSubtree(root1.left, root2);
        }
        if (!result) {
            result = HasSubtree(root1.right, root2);
        }
        return result;
    }

    private static boolean SameRootHasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 != null && root2 == null) return true;
        if (root1 == null && root2 != null) return false;
        if (root1.val != root2.val) return false;
        return SameRootHasSubtree(root1.left, root2.left) && SameRootHasSubtree(root1.right, root2.right);
    }


    public static void main(String[] args) {
        String[] str1 = {"8", "8", "#", "9", "#", "#", "#", "2", "#", "#", "#", "#", "#", "#", "#", "5"};
        BinTree tree1 = new BinTree(str1);
        String[] str2 = {"8", "9", "#", "2"};
        BinTree tree2 = new BinTree(str2);
        boolean result = HasSubtree(tree1.getRoot(), tree2.getRoot());
        if (result) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

}
