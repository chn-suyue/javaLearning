package jzoffer.one;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: suyue
 * @time: 2021/3/21 14:51
 */
public class J50_duplicate {

    public int duplicate (int[] numbers) {
        if (numbers==null || numbers.length==0) return -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<numbers.length; i++) {
            if (map.get(numbers[i])==null) {
                map.put(numbers[i],1);
            } else {
                return numbers[i];
            }
        }
        return -1;
    }

}
