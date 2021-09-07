package jzoffer.leetcode;

/**
 * @description:
 * @author: suyue
 * @time: 2021/8/31 20:31
 */
public class JT53_search {


    public static int search(int[] nums, int target) {
        //显然，刚才那种方法非常鸡肋，比普通遍历查找时间复杂度还要高，二分查找并没有用对，那要怎样处理呢？
        //二分查找变种，查询升序数组中，最左边或者最右边第一个与目标值相等的下标。
        if (nums == null || nums.length == 0) return 0;

        int leftIndex = binarySearch(nums, target, true);
        int rightIndex = binarySearch(nums, target, false) - 1;
        if (rightIndex >= leftIndex && rightIndex < nums.length && nums[leftIndex] == target && nums[rightIndex] == target) {
            return rightIndex - leftIndex + 1;
        }

        return 0;
    }

    public static int binarySearch(int[] nums, int target, boolean leftFlag) {
        int index = nums.length;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (leftFlag && nums[mid] >= target)) {
                right = mid - 1;
                index = mid;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }

    /*public int search(int[] nums, int target) {
        //思路：先用二分法查找，如果找到目标数字，则左右分别遍历计数
        //时间复杂度：O(n)
        //空间复杂度：O(1)
        if (nums == null || nums.length == 0) return 0;

        int index = binarySearch(nums, target);
        if (index < 0) return 0;

        int count = 1;
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] != target) break;
            count++;
        }
        for (int i = index - 1; i >= 0; i--) {
            if (nums[i] != target) break;
            count++;
        }
        return count;
    }

    public int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (target > nums[mid]) {
                low = mid + 1;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }*/

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        int search = search(nums, target);

        System.out.println(search);
    }

}
