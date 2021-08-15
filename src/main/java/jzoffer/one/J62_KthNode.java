package jzoffer.one;

/**
 * @description:
 * @author: suyue
 * @time: 2021/4/2 0:03
 */
public class J62_KthNode {

    TreeNode node = null;
    int count = 0;

    TreeNode KthNode(TreeNode pRoot, int k) {
        count = k;
        helpKthNode(pRoot);
        return node;
    }

    private void helpKthNode(TreeNode pNode) {
        if (pNode == null || node != null || count < 1) return;
        helpKthNode(pNode.left);
        if (count == 1) node = pNode;
        count--;
        helpKthNode(pNode.right);
    }

}
