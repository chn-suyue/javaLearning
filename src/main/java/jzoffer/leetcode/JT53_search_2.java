package jzoffer.leetcode;

/**
 * @description:
 * @author: suyue
 * @time: 2021/8/31 20:31
 */
public class JT53_search_2 {


    public int search(int[] nums, int target) {
        //思路：排序数组中的查询，自然而然想到了二分法，但是传统的二分法是解决存在型问题，本题是计数型问题，需要对传统的二分法做下改造。
        //查出目标数target在数组中最左侧下标 leftIndex, 再查出最右侧下标 rightIndex, 出现次数即为 rightIndex-leftIndex+1

        int leftIndex = binarySearch(nums, target, true);
        int rightIndex = binarySearch(nums, target, false) - 1;
        if (rightIndex >= leftIndex && rightIndex < nums.length && nums[leftIndex] == target && nums[rightIndex] == target) {
            return rightIndex - leftIndex + 1;
        }

        return 0;

    }

    public int binarySearch(int[] nums, int target, boolean leftFlag) {
        int low = 0;
        int high = nums.length - 1;
        int index = nums.length;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > target || (leftFlag && nums[mid] >= target)) {
                high = mid - 1;
                index = mid;
            } else {
                low = mid + 1;
            }
        }

        return index;
    }


}
