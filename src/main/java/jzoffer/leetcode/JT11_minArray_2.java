package jzoffer.leetcode;

/**
 * @description:
 * @author: suyue
 * @time: 2021/9/3 20:22
 */
public class JT11_minArray_2 {

    public static int minArray(int[] numbers) {
        //思路：排序数组的查询问题，使用二分法。没有指定目标数，那就用端点做条件判断
        //注意：需要用右端点作为目标数numbers[right]做比较，左端点不行，不知道为啥，也是奇怪了！？
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] > numbers[right]) {
                //[mid+1...right]
                left = mid + 1;
            } else if (numbers[mid] == numbers[right]) {//根据题意，这里要特别注意，没法判断要找的数是在mid左侧还是右侧，所以right--来缩减范围，这道题相当于二分法和暴力法的结合
                //[left...right-1]
                right--;
            } else {
                //[left...mid]
                right = mid;
            }
        }

        return numbers[left];
    }

    public static void main(String[] args) {
        int[] nums = {10,1,10,10,10};
        int result = minArray(nums);
        System.out.println(result);
    }

}
