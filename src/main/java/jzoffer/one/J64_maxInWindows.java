package jzoffer.one;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;

/**
 * @description:
 * @author: suyue
 * @time: 2021/4/4 1:03
 */
public class J64_maxInWindows {

    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        //方法1：暴力法。每次滑动一个窗口即为一个新数组，查询该数组最大元素。

        //方法2：优化方法1，如果当前窗口的数组中，包含上一个窗口的最大值，则只需要比较当前窗口最后一个元素即可；否则全部比较一遍。
        //时间复杂度：(n-k+1)*k
        //空间复杂度：O(1)
        ArrayList<Integer> result = new ArrayList<>();
        if (num == null || num.length == 0 || num.length < size || size==0) return result;
        int low = 0, high = size - 1;
        int index = -1;//上一个窗口的最大值index

        while (high < num.length) {
            if (index >= low && index < high) {
                result.add(Math.max(num[index], num[high]));
            } else {
                index = helpMaxInWindows(num, low, high);
                result.add(num[index]);
            }
            low++;
            high++;
        }

        return result;

        //方法3：使用单调队列。
        //时间复杂度：O(n)
        //空间复杂度：O(k)

    }

    private static int helpMaxInWindows(int[] array, int low, int high) {
        int max = array[low];
        int index = low;
        for (int i = low + 1; i <= high; i++) {
            if (array[i] >= max) {
                max = array[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 4, 2, 6, 2, 5, 1};
        int size = 3;
        ArrayList<Integer> list = maxInWindows(array, size);
        System.out.println(JSON.toJSONString(list));
    }

}
