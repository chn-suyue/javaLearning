package jzoffer.newcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @description:
 * @author: suyue
 * @time: 2021/3/22 0:03
 */
public class J54_FirstAppearingOnce {

    //自己的思路：两个list，分别存放只出现一次和出现多次的字符。思路是可以的，只是牛客网的测试没有通过
    /*List<Character> onlyList = new ArrayList<>();
    List<Character> overList = new ArrayList<>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (!onlyList.contains(ch) && !overList.contains(ch)) {
            onlyList.add(ch);
        }
        if (onlyList.contains(ch) && !overList.contains(ch)) {
            onlyList.remove(ch);
            overList.add(ch);
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        if (onlyList.isEmpty()) {
            return '#';
        } else {
            return onlyList.get(0);
        }
    }*/


    //另一种思路：重复（hashmap），先进先出（queue）

    Map<Character, Integer> map = new HashMap<>();
    Queue<Character> queue = new LinkedList<>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (map.get(ch) == null) {
            queue.add(ch);
            map.put(ch, 1);
        } else {
            map.put(ch, map.get(ch) + 1);
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        while (!queue.isEmpty()) {
            Character ch = queue.peek();
            if (map.get(ch) == 1) {
                return ch;
            } else {
                queue.remove();
            }
        }
        return '#';
    }


}
