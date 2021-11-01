package jzoffer.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: suyue
 * @time: 2021/10/17 20:31
 */
public class MedianFinder {

    List<Integer> list;

    /** initialize your data structure here. */
    public MedianFinder() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        list.add(num);
    }

    public double findMedian() {
        Integer[] array = (Integer[]) list.toArray();
        Arrays.sort(array);

        double result = 0.0;
        int length = array.length;
        if (length%2==0) {
            result = (array[length/2] + array[length/2 - 1])/2.0;
        } else {
            result = array[(length-1)/2];
        }

        return result;

    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 4, 3, 1, 5);
        Integer[] array = (Integer[]) list.toArray();
        System.out.println(array);
    }

}
