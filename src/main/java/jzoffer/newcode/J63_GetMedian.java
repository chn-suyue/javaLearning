package jzoffer.newcode;

import java.util.*;

/**
 * @description:
 * @author: suyue
 * @time: 2021/4/3 12:45
 */
public class J63_GetMedian {

    List<Integer> list = new ArrayList<>();

    // 方法1：暴力法。insert方法直接add进去，然后在getMedian方法中排序，再取中位数
    //时间复杂度：
    //空间复杂度：
    public void Insert(Integer num) {
        list.add(num);
    }

    public Double GetMedian() {
        Collections.sort(list);
        Double result;
        if (list.size() % 2 == 1) {//奇数
            result = Double.valueOf(list.get((list.size() - 1) / 2));
        } else {
            result = (list.get(list.size() / 2) + list.get(list.size() / 2 - 1)) / 2.0;
        }
        return result;
    }

    //方法2：insert方法中，用插入排序，然后在getMedian方法中即可直接取中位数。

    //方法3：堆

}
