package jzoffer.one;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author: suyue
 * @time: 2021/3/31 0:16
 */
public class J60_Print {

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        //思路：BFS常见模板，逐层遍历，没有约束
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> tempList = new ArrayList<>();
            while (size > 0) {
                TreeNode node = queue.poll();
                tempList.add(node.val);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                size--;
            }
            result.add(tempList);
        }
        return result;

    }

}
