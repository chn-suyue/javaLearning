package jzoffer.leetcode;

/**
 * @description:
 * @author: suyue
 * @time: 2022/1/4 20:19
 */
public class JT56_singleNumbers1 {

    public int[] singleNumbers(int[] nums) {
        //计算整个数组的异或结果r
        int r = 0;
        for (int i=0; i<nums.length; i++) {
            r = r ^ nums[i];
        }
        //找出r中某一位为1的位数（此处取最低位），仅该位为1，其余位为0，对应数m
        int m = 1;
        while ((r&m) == 0) {
            m = m << 1;
        }
        //遍历数组，分别与m做逻辑与运算，结果等于0的数为一组，不等于0的数为另一组
        int x = 0;
        int y = 0;
        for (int i=0; i<nums.length; i++) {
            int q = nums[i]&m;
            if (q==0) {
                x = x ^ nums[i];
            } else {
                y = y ^ nums[i];
            }
        }
        //分别对两组数做逻辑异或运算，即可得到这两个只出现一次的数
        int[] result = new int[2];
        result[0] = x;
        result[1] = y;

        return result;
    }

}
