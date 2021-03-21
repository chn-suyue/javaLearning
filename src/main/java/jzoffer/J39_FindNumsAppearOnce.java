package jzoffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: suyue
 * @time: 2021/3/13 13:57
 */
public class J39_FindNumsAppearOnce {

    public int[] FindNumsAppearOnce(int[] array) {
        // 思路：哈希
        if (array == null || array.length == 0) return null;
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            Integer count = map.get(array[i]);
            if (count == null) {
                map.put(array[i], 1);
            } else {
                map.put(array[i], count + 1);
            }
        }
        int index = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1 && index <= 1) {
                result[index] = key;
                index++;
            }
        }

        if (result[0] > result[1]) {
            int temp = result[0];
            result[0] = result[1];
            result[1] = temp;
        }
        return result;
    }

}
