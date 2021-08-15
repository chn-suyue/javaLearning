package jzoffer.one;

import java.util.ArrayList;

/**
 * @description:
 * @author: suyue
 * @time: 2021/2/27 15:40
 */
public class J24_FindPath {

    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    private ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        //方法：递归。要反应过来，局部变量没法保存全部路径，需使用全局变量。
        //递归函数的功能：找到和为target的路径
        //递归终止条件：target-val==0且到达叶子节点
        //下次递归参数：root.left或者root.right，target-root.val
        if (root == null) return result;
        helpFind(root, target);
        return result;
    }

    private void helpFind(TreeNode root, int target) {
        if (root == null) return;
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null)
            result.add(new ArrayList<>(list));
        helpFind(root.left, target);
        helpFind(root.right, target);
        //当前节点处理完，要将该节点从list去掉，保证切换路径后，list中val的正确性
        list.remove(list.size() - 1);
    }


}
