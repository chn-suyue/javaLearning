package jzoffer.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: suyue
 * @time: 2021/10/16 19:58
 */
public class JT61_isStraight {

    public boolean isStraight(int[] nums) {

        //思路：数组中的5个数，需要满足以下两个条件，才能保证为顺子。
        //1、最大数与最小数之差小于5
        //2、除零外无重复数字
        int maxNum = 0;
        int minNum = Integer.MAX_VALUE;

        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (map.get(nums[i]) != null) {
                    return false;
                } else {
                    map.put(nums[i], 1);
                    maxNum = Math.max(maxNum, nums[i]);
                    minNum = Math.min(minNum, nums[i]);
                }
            }
        }

        return maxNum - minNum < 5;


        //自己的思路还是比较蠢的，但是挺快的
        /*int zeroNum = 0;
        //排序
        for (int i=0; i<nums.length; i++) {
            for (int j=0; j<nums.length-i-1; j++) {
                if (nums[j]>nums[j+1]) {
                    int tmp = nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=tmp;
                }
            }
        }

        // 计数（0的个数）
        for (int i=0; i<nums.length; i++) {
            if (nums[i]==0) {
                zeroNum++;
            }
        }

        //做差
        for (int i=0; i<nums.length-1; i++) {
            if (nums[i]==0) {
                continue;
            }
            if (zeroNum<0) {
                return false;
            }
            if (nums[i+1]-nums[i]==1) {
                continue;
            } else if (nums[i+1]-nums[i]>1) {
                zeroNum = zeroNum - (nums[i+1]-nums[i]-1);
            } else {
                return false;
            }
        }

        return zeroNum >= 0;*/
    }

}
