package jzoffer.leetcode;

/**
 * @description:
 * @author: suyue
 * @time: 2021/9/2 20:42
 */
public class JT53_missingNumber {

    public int missingNumber(int[] nums) {

        //思路：本题等价于，从排序数组中，找出第一个不等于下标的数。同上一题，排序数组中的查询问题，使用二分法变形
        int low = 0;
        int high = nums.length - 1;
        int index = nums.length;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] != mid) {
                high = mid - 1;
                index = mid;
            } else {
                low = mid + 1;
            }
        }

        return index;
    }

}
