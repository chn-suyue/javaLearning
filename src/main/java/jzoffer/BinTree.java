package jzoffer;

import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: suyue
 * @time: 2021/2/20 17:13
 */
public class BinTree {

    //表示二叉树的字符串数组
    private String[] str;
    //表示二叉树的List集合(按照层级遍历的顺序存储，没有节点的位置用null代替)
    private List<TreeNode> list;

    //构造函数,传入字符串数组
    BinTree(String[] str) {
        this.str = str;
        createBinTree();
    }

    //创建二叉树
    public void createBinTree() {
        list = new LinkedList<TreeNode>();

        //遍历字符串数组，将字符串转成相应的节点
        for (String s : str) {
            //如果s是#，那么对应null
            if ("#".equals(s)) {
                list.add(null);
            }
            //否则对应有值的节点
            else {
                list.add(new TreeNode(Integer.parseInt(s)));
            }
        }

        //构建二叉树父子节点直接的关系
        for (int index = 0; index < str.length / 2 - 1; index++) {
            //如果节点不是null的，需要加上其左右儿子节点
            if (list.get(index) != null) {
                list.get(index).left = list.get(index * 2 + 1);
                list.get(index).right = list.get(index * 2 + 2);
            }
        }

        //单独处理最后一个节点(防止数组越界)
        int lastIndex = str.length / 2 - 1;
        //添加左儿子
        list.get(lastIndex).left = list.get(lastIndex * 2 + 1);

        //如果数组长度是奇数，说明有右儿子
        if (str.length % 2 != 0) {
            list.get(lastIndex).right = list.get(lastIndex * 2 + 2);
        }
    }

    //获取二叉树根
    public TreeNode getRoot(){
        if(list != null){
            return list.get(0);
        }
        System.out.println("请先创建二叉树");
        return null;
    }

    //前序遍历
    public void preOrder(TreeNode root) {

    }
    //中序遍历

    //后序遍历

}
