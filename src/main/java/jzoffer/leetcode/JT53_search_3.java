package jzoffer.leetcode;

/**
 * @description:
 * @author: suyue
 * @time: 2021/8/31 20:31
 */
public class JT53_search_3 {


    public static int search(int[] nums, int target) {
        //思路：排序数组中的查询，使用二分法，
        // 找出目标数第一次出现的位置 firstIndex 和最后一次出现的位置 lastIndex, 答案即为 lastIndex-firstIndex+1
        //查找第一次出现的位置没啥问题，但是查找最后一次出现的位置，要注意：
        // 1、求mid时要加个1，否则会死循环；
        // 2、先判断firstIndex，再查找lastIndex，否则会出现数组越界异常。
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int firstIndex = findFirstIndex(nums, target);
        if (firstIndex < 0) {
            return 0;
        }

        int lastIndex = findLastIndex(nums, target);//注意：先判断firstIndex，再查找lastIndex，否则会出现数组越界异常。
        return lastIndex - firstIndex + 1;

    }

    private static int findFirstIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                //[left...mid-1]
                right = mid - 1;
            } else if (nums[mid] == target) {
                //[left...mid]
                right = mid;
            } else {
                //[mid+1...right]
                left = mid + 1;
            }
        }
        if (nums[left] == target) {
            return left;
        }

        return -1;
    }

    private static int findLastIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left + 1) / 2;//特别注意：这里加1是为了防止死循环
            if (nums[mid] > target) {
                //[left...mid-1]
                right = mid - 1;
            } else if (nums[mid] == target) {
                //[mid...right]
                left = mid;
            } else {
                //[mid+1...right]
                left = mid + 1;
            }
        }
        if (nums[left] == target) {
            return left;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2,2};
        int target = 3;
        int result = search(nums, target);
        System.out.println(result);
    }

}
