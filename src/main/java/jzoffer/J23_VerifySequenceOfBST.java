package jzoffer;


/**
 * @description:
 * @author: suyue
 * @time: 2021/2/26 20:15
 */
public class J23_VerifySequenceOfBST {

    public boolean VerifySequenceOfBST(int[] sequence) {
        //二叉搜索树的性质：根节点值均大于左子树节点值，小于右子树节点值。
        if (sequence == null || sequence.length == 0) return false;
        return helpVerify(sequence, 0, sequence.length - 1);
    }

    private boolean helpVerify(int[] sequence, int l, int r) {
        if (l >= r) return true;
        int pivot = sequence[r];
        int index = 0;
        for (int i = 0; i < r; i++) {
            if (sequence[index++] > pivot) break;
        }
        for (int j = index; j < r; j++) {
            if (sequence[j] <= pivot) return false;
        }
        return helpVerify(sequence, l, index - 1) && helpVerify(sequence, index, r - 1);
    }


}
