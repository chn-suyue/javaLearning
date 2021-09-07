package jzoffer.leetcode;

/**
 * @description:
 * @author: suyue
 * @time: 2021/9/2 20:42
 */
public class JT53_missingNumber_2 {

    public static int missingNumber(int[] nums) {

        //思路：排序数组的查询问题，使用二分法，没有给定目标数，但是根据题意可知目标数就是下标
        //找出数组中第一个下标和值不相等的位置
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] != mid) {
                //[left...mid]
                right = mid;
            } else {
                //[mid+1...right]
                left = mid + 1;
            }
        }

        if (left == nums.length - 1 && nums[left] == left) {//根据题意，需要特别注意这个判断
            return left + 1;
        }

        return left;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3};
        int result = missingNumber(nums);
        System.out.println(result);
    }

}
