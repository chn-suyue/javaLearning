package jzoffer;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;

/**
 * @description:
 * @author: suyue
 * @time: 2021/3/13 22:12
 */
public class J42_FindNumbersWithSum {

    public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        //方法1：双指针（首首）
        /*ArrayList<Integer> result = new ArrayList<>();
        if (array == null || array.length == 0) return result;
        int l = 0, r = 0;
        boolean flag = false;
        for (l = 0; l < array.length; l++) {
            for (r = l + 1; r < array.length; r++) {
                if (array[l] + array[r] == sum) {
                    result.add(array[l]);
                    result.add(array[r]);
                    flag = true;
                    break;
                } else if (array[l] + array[r] > sum) {
                    break;
                }
            }
            if (flag) break;
        }
        return result;*/

        //方法2：双指针（首尾）
        ArrayList<Integer> result = new ArrayList<>();
        if (array == null || array.length == 0) return result;
        int l = 0, r = array.length - 1;
        while (l < r) {
            if (array[l] + array[r] > sum) {
                r--;
            } else if (array[l] + array[r] < sum) {
                l++;
            } else {
                result.add(array[l]);
                result.add(array[r]);
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {};
        int sum = 0;
        ArrayList<Integer> list = FindNumbersWithSum(array, sum);
        System.out.println(JSON.toJSONString(list));
    }

}
