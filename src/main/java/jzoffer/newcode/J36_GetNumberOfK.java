package jzoffer.newcode;

import java.util.Arrays;

/**
 * @description:
 * @author: suyue
 * @time: 2021/3/12 0:30
 */
public class J36_GetNumberOfK {

    public static int GetNumberOfK(int[] array, int k) {
        //思路：二分法快速查找k，再左右两侧找出k的个数
        //时间复杂度：O(log2n)
        //空间复杂度：O(1)
        if (array == null || array.length == 0) return 0;
        int index = Arrays.binarySearch(array, k);
        if (index < 0) return 0;
        int count = 1, i = index - 1, j = index + 1;
        while (i >= 0 && array[i] == k) {
            count++;
            i--;
        }
        while (j < array.length && array[j] == k) {
            count++;
            j++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 3, 3, 4, 5};
        int k = 3;
        int result = GetNumberOfK(array, k);
        System.out.println(result);

    }

}
