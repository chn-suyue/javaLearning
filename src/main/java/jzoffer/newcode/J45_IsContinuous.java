package jzoffer.newcode;

import java.util.HashMap;

/**
 * @description:
 * @author: suyue
 * @time: 2021/3/14 1:58
 */
public class J45_IsContinuous {

    public boolean IsContinuous(int[] numbers) {
        //思路：除0之外，最大值-最小值<=4，且除0外无重复数字
        if (numbers == null || numbers.length == 0) return false;
        int max = 0, min = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != 0) {
                max = Math.max(max, numbers[i]);
                min = Math.min(min, numbers[i]);
                if (map.get(numbers[i]) == null) {
                    map.put(numbers[i], 1);
                } else {
                    return false;
                }
            }
        }
        return (max - min) <= 4;
    }

}
