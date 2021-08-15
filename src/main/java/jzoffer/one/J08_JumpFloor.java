package jzoffer.one;

/**
 * @description:
 * 同J07 斐波那契数列实现的三种方式
 * @author: suyue
 * @time: 2021/1/13 20:06
 */
public class J08_JumpFloor {

    public static int JumpFloor(int target) {
        if (target <= 2) return target;
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

    public static void main(String[] args) {
        int target = 5;
        System.out.println(JumpFloor(target));;
    }

}
