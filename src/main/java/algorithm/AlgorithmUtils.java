package algorithm;

/**
 * @description:
 * @author: suyue
 * @time: 2021/2/17 14:01
 */
public class AlgorithmUtils {

    //快速排序实现方法1：严蔚敏版本
    //参考：https://www.bilibili.com/video/BV1at411T75o?from=search&seid=3122363825036744402
    public static void quickSort1(int[] array, int L, int R) {
        if (L >= R) return;
        int left = L;
        int right = R;
        int pivot = array[L];
        while (left < right) {
            while (left < right && array[right] >= pivot) {
                right--;
            }
            if (left < right) array[left] = array[right];
            while (left < right && array[left] < pivot) {
                left++;
            }
            if (left < right) array[right] = array[left];
            if (left == right) {
                array[left] = pivot;
            }
        }
        //左子序列
        quickSort1(array, L, right - 1);
        //右子序列
        quickSort1(array, right + 1, R);
    }

    //快速排序实现方法2：算法导论版本
    public static void quickSort2(int[] array, int L, int R) {
        if (L >= R) return;
        int position = partition(array, L, R);
        quickSort2(array, L, position - 1);
        quickSort2(array, position + 1, R);

    }

    private static int partition(int[] array, int L, int R) {
        int pivot = array[R];
        int i = L - 1;
        for (int j = i + 1; j < R; j++) {
            if (array[j] < pivot) {
                i++;
                exchange(array, i, j);
            }
        }
        exchange(array, i + 1, R);
        return i + 1;
    }

    private static void exchange(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void main(String[] args) {
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        AlgorithmUtils.quickSort2(array, 0, 8);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

}
