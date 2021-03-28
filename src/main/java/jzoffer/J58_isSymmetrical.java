package jzoffer;

/**
 * @description:
 * @author: suyue
 * @time: 2021/3/28 22:27
 */
public class J58_isSymmetrical {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    boolean isSymmetrical(TreeNode pRoot) {
        //这递归万万没想到。开始自己的思路是，镜像前和镜像后分别前序遍历，如果遍历后的值都相等，则返回true。但是这种方法有一种情况不适用，就是当所有节点值都相等时，即使不是对称二叉树，两次遍历结果也是一样的
        //递归参数，入参左右子树根节点，返回值boolean。功能：判断二叉树是否对称
        //递归终止条件：root1和root2都为null，或者root1和root1只有一个为null
        //单层递归逻辑：左右子树根节点值相等，并且左右子树根节点的左右子树对称节点值相等
        return isSame(pRoot, pRoot);

    }

    private boolean isSame(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        return root1.val==root2.val && isSame(root1.left,root2.right) && isSame(root1.right,root2.left);
    }
}
