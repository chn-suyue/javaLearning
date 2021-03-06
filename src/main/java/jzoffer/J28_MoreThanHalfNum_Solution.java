package jzoffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: suyue
 * @time: 2021/3/4 19:55
 */
public class J28_MoreThanHalfNum_Solution {

    public static int MoreThanHalfNum_Solution(int[] array) {
        //哈希法：首先遍历一遍数据，用map记录每个数出现的次数。再次遍历数组，找出出现次数大于一半数组长度的数
        if (array == null || array.length == 0) return 0;
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            Integer count = map.get(array[i]);
            if (count == null) {
                map.put(array[i], 1);
            } else {
                map.put(array[i], count + 1);
            }
        }
        for (int j = 0; j < array.length; j++) {
            Integer count = map.get(array[j]);
            if (2 * count > array.length)
                result = array[j];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {4, 2, 1, 4, 2, 4};
        System.out.println(MoreThanHalfNum_Solution(array));

    }


}
