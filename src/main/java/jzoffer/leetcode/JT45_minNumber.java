package jzoffer.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @description:
 * @author: suyue
 * @time: 2021/10/17 20:04
 */
public class JT45_minNumber {

    public String minNumber(int[] nums) {
        //思路：表面上看这道题是排列组合的题目，实际可以转化为数据排序题。为什么不能直接使用排列组合？因为转成整数比较大小会溢出。
        if (nums==null || nums.length==0) return null;

        List<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(String.valueOf(num));
        }

        //排序
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (Long.parseLong(o1+o2) > Long.parseLong(o2+o1)) {
                    return 1;
                }
                return -1;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String ele : list) {
            sb.append(ele);
        }

        return sb.toString();


        // 参考答案写的，但是排序部分是自己写的冒泡排序，上面是改进方法
        /*if (nums==null || nums.length==0) return null;

        String[] array = new String[nums.length];
        for (int i=0; i<nums.length; i++) {
            array[i]=String.valueOf(nums[i]);
        }

        for (int i=0; i<nums.length; i++) {
            for (int j=0; j<nums.length-i-1; j++) {
                //当 x+y > y+x ，说明x较大，要交换顺序放到后面
                if (Long.parseLong(array[j]+array[j+1]) > Long.parseLong(array[j+1]+array[j])) {
                    String tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<nums.length; i++) {
            sb.append(array[i]);
        }

        return sb.toString();*/

    }

}
