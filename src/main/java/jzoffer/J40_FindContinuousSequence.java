package jzoffer;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;

/**
 * @description:
 * @author: suyue
 * @time: 2021/3/13 14:24
 */
public class J40_FindContinuousSequence {

    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        //方法1：双指针，嵌套for循环穷举
        /*ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = null;
        int tempSum = 0;
        for (int i = 1; i <= sum / 2; i++) {
            tempSum += i;
            list = new ArrayList<>();
            list.add(i);
            for (int j = i + 1; j <= (sum / 2 + 1); j++) {
                tempSum += j;
                list.add(j);
                if (tempSum == sum) {
                    result.add(list);
                    tempSum = 0;
                    break;
                }
                if (tempSum > sum) {
                    tempSum = 0;
                    break;
                }
            }
        }
        return result;*/

        //方法2：滑动窗口
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = null;
        int l = 1, r = 2, tempSum = l;
        while (l <= sum / 2) {
            if (tempSum < sum) {
                tempSum += r;
                r++;
            } else if (tempSum > sum) {
                tempSum -= l;
                l++;
            } else {
                list = new ArrayList<>();
                for (int i = l; i < r; i++) {
                    list.add(i);
                }
                result.add(list);
                tempSum += r;
                r++;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = FindContinuousSequence(9);
        System.out.println(JSON.toJSONString(list));
    }

}
