package jzoffer.leetcode;

/**
 * @description:
 * @author: suyue
 * @time: 2022/1/6 19:45
 */
public class JT39_majorityElement {

    public int majorityElement(int[] nums) {
        //方法1、暴力法
        /*int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], 1);
            } else {

                map.put(nums[i], 1 + map.get(nums[i]));
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue()>nums.length/2) {
                result = entry.getKey();
            }
        }

        return result;*/

        //方法2、摩尔投票法
        int votes = 0;
        int result = 0;

        for (int i=0; i<nums.length; i++) {
            if (votes==0) {
                result = nums[i];
                votes++;
                continue;
            }
            if (nums[i]==result) {
                votes++;
            } else {
                votes--;
            }
        }

        return result;
    }

}
