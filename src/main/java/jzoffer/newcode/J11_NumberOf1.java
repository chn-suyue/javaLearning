package jzoffer.newcode;

/**
 * @description:
 * @author: suyue
 * @time: 2021/2/8 17:46
 */
public class J11_NumberOf1 {

    public static int NumberOf1(int n) {
        int ans = 0;
        int mark = 0x01;
        while (mark != 0) {
            if ((mark & n) != 0) ans++;
            mark <<= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = -7;
        int num = NumberOf1(n);
        System.out.println(num);
    }

}
