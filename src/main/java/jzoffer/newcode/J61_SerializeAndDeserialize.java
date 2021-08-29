package jzoffer.newcode;

/**
 * @description:
 * @author: suyue
 * @time: 2021/4/1 23:25
 */
public class J61_SerializeAndDeserialize {

    String Serialize(TreeNode root) {
        //前序遍历，拼接字符串
        if (root == null) return "#";
        return root.val + "," + Serialize(root.left) + "," + Serialize(root.right);
    }

    int index = -1;

    TreeNode Deserialize(String str) {
        //前序遍历的顺序，初始化二叉树
        String[] strings = str.split(",");
        index++;
        TreeNode node =null;
        if (index > strings.length - 1) return null;
        if (!strings[index].equals("#")) {
            node = new TreeNode(Integer.parseInt(strings[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }

}
