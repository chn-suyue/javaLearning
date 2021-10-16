package jzoffer.leetcode;

import java.util.Arrays;

/**
 * @description:
 * @author: suyue
 * @time: 2021/10/16 20:18
 */
public class JT40_getLeastNumbers {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0) return new int[0];

        //自己写个排序算法（冒泡）
        // for (int i=0; i<arr.length; i++) {
        //     for (int j=0; j<arr.length-i-1; j++) {
        //         if (arr[j]>arr[j+1]) {
        //             int tmp = arr[j];
        //             arr[j]=arr[j+1];
        //             arr[j+1]=tmp;
        //         }
        //     }
        // }

        //或者直接使用封装好的函数
        Arrays.sort(arr);

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }

        return result;

    }

}
