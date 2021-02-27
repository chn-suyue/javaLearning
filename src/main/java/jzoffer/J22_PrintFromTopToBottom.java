package jzoffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author: suyue
 * @time: 2021/2/24 20:32
 */
public class J22_PrintFromTopToBottom {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        //用队列存储访问过的节点，再从队列访问一遍
        //时间复杂度：O(n)
        //空间复杂度：O(n)
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            result.add(temp.val);
            if (temp.left != null) queue.offer(temp.left);
            if (temp.right != null) queue.offer(temp.right);
        }
        return result;
    }

}
