package jzoffer;

/**
 * @description: 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * 输入：{3,4,5,1,2}
 * 输出：1
 *
 * 解析：这种二分查找难就难在，arr[mid]跟谁比.
 * 我们的目的是：当进行一次比较时，一定能够确定答案在mid的某一侧。一次比较为 arr[mid]跟谁比的问题。
 * 一般的比较原则有：
 *
 * 如果有目标值target，那么直接让arr[mid] 和 target 比较即可。
 * 如果没有目标值，一般可以考虑 端点
 * @author: suyue
 * @time: 2021/1/12 20:51
 */
public class J06_minNumberInRotateArray {

    public static int minNumberInRotateArray(int[] array) {
        if (array.length == 0) return 0;

        int low = 0;
        int high = array.length - 1;
        int mid = 0;

        while (high != low) {
            mid = (low + high) / 2;
            if (array[mid] < array[high]) {
                high = mid;
            } else if (array[mid] > array[high]) {
                low = mid + 1;
            } else {
                high--;
            }
        }
        return array[high];
    }


    public static void main(String[] args) {
        int[] array = {0,1,1,1,1};
        int minNum = minNumberInRotateArray(array);
        System.out.println(minNum);
    }

}
