package jzoffer.one;

/**
 * @description:
 * @author: suyue
 * @time: 2021/1/18 20:30
 */
public class J10_rectCover {

    public static int rectCover(int target) {
        if (target==1 || target==2) return target;
        return rectCover(target-1)+rectCover(target-2);
    }

    public static void main(String[] args) {
        int target = 4;
        System.out.println(rectCover(target));
    }

}
