package jzoffer.leetcode;

/**
 * @description:
 * @author: suyue
 * @time: 2022/1/5 20:55
 */
public class JT56_singleNumbers2 {

    public static int singleNumber(int[] nums) {
        //计算数组中，所有数转为二进制后，每一位上1的个数，结果用数组count保存
        int[] count = new int[32];
        for (int i = 0; i < nums.length; i++) {
            int m = 1;
            for (int j = 0; j < 32; j++) {
                if ((nums[i] & m) > 0) {
                    count[j]++;
                }
                m = m << 1;
            }
        }
        //对数组count中每一位对3取余操作，得到只出现一次数字的每一位的二进制数
        for (int i = 0; i < 32; i++) {
            count[i] = count[i] % 3;
        }
        //将取余操作后的数组count恢复成数值
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            result = result | count[31 - i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array = {3, 3, 3, 4};
        int result = singleNumber(array);
        System.out.println(result);
    }

}
