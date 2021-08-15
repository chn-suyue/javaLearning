package jzoffer.one;

/**
 * @description:
 * @author: suyue
 * @time: 2021/1/14 20:38
 */
public class J09_JumpFloorII {

    public static int JumpFloorII(int target) {
        if (target == 1) return target;
        int sum = 1;
        for (int i=target-1; i>0; i--) {
            sum = sum + JumpFloorII(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        int target = 3;
        System.out.println(JumpFloorII(target));
    }

}
