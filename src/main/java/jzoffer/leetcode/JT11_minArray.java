package jzoffer.leetcode;

/**
 * @description:
 * @author: suyue
 * @time: 2021/9/3 20:22
 */
public class JT11_minArray {

    public static int minArray(int[] numbers) {
        //思路：本题等价于，找出最左侧比 numbers[0] 小的数，本质上还是排序数组的查询问题，使用二分法的变形来解答
        //但是，二分法一般有个目标值做比较，但是本题没有，咋办？没有的话一般使用端点来做比较
        int index = binarySearch(numbers);
        return numbers[index];
    }

    public static int binarySearch(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        int index = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (numbers[mid] < numbers[high]) {
                high = mid;
                index = mid + 1;
            } else if (numbers[mid] > numbers[high]) {
                low = mid + 1;
            } else {
                high--;
                index = high + 1;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        int[] numbers = {3, 4, 5, 1, 2};
    }

}
