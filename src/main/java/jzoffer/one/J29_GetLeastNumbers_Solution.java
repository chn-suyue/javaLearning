package jzoffer.one;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @description:
 * @author: suyue
 * @time: 2021/3/5 19:41
 */
public class J29_GetLeastNumbers_Solution {

    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (k<=0 || k>input.length) return result;
        Arrays.sort(input);
        for (int i=0; i<k; i++) {
            result.add(input[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {5,4,3,2,1};
        ArrayList<Integer> list = GetLeastNumbers_Solution(array, 3);
        System.out.println(JSON.toJSONString(list));
    }


}
