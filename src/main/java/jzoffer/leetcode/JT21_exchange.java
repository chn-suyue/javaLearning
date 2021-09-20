package jzoffer.leetcode;

/**
 * @description:
 * @author: suyue
 * @time: 2021/9/19 17:12
 */
public class JT21_exchange {

    public int[] exchange(int[] nums) {
        //方法一：新建一个数组，第一次遍历原数组，把所有奇数往新数组中填充，第二次遍历原数组，将所有偶数继续往新数组填充
        //时间复杂度：O(n)
        //空间复杂度：O(n)
        /*if (nums==null || nums.length==0) return nums;

        int[] array = new int[nums.length];
        int index = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i]%2==1) {
                array[index]=nums[i];
                index++;
            }
        }
        for (int i=0; i<nums.length; i++) {
            if (nums[i]%2==0) {
                array[index]=nums[i];
                index++;
            }
        }

        return array;*/

        //方法二：双指针，首尾指针
        //时间复杂度：O(n)
        //空间复杂度：O(1)
        if (nums==null || nums.length==0) return nums;

        int left=0;
        int right=nums.length-1;

        while (left<right) {
            if (nums[left]%2==0 && nums[right]%2==1) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            } else if (nums[left]%2==0 && nums[right]%2!=1) {
                right--;
            } else if (nums[left]%2!=0 && nums[right]%2==1) {
                left++;
            } else {
                left++;
                right--;
            }
        }

        return nums;


    }

}
