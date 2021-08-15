package jzoffer.one;

import java.util.*;

/**
 * @description:
 * @author: suyue
 * @time: 2021/3/30 23:52
 */
public class J59_Print {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        //BFS常见套路1：逐层遍历，无其他条件
        /*if (pRoot == null) return null;
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            //在这里对获取的节点做逻辑处理
            list.add(node.val);

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }*/

        //BFS常见套路2：逐层遍历，指定遍历层数
        /*if (pRoot == null) return null;
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                //在这里对获取的节点做逻辑处理
                list.add(node.val);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                size--;
            }
            level++;
        }*/

        //BFS常见套路3：逐层遍历，指定每层遍历顺序
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> tempList = new ArrayList<>();
            while (size > 0) {
                TreeNode node = queue.poll();
                //在这里对获取的节点做逻辑处理
                tempList.add(node.val);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                size--;
            }
            if ((level & 1) != 0) Collections.reverse(tempList);
            result.add(tempList);
            level++;
        }
        return result;
    }

}
