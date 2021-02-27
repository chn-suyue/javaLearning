package jzoffer;

/**
 * @description:
 * @author: suyue
 * @time: 2021/2/15 19:19
 */
public class J12_Power {

    public static double Power(double base, int exponent) {

        double ans = 1.0;
        if (exponent == 0 ) return ans;
        if (exponent <0) {
            base = 1/base;
            exponent = -exponent;
        }
        for (int i=0; i<exponent; i++) {
            ans = ans * base;
        }
        return ans;
    }

    public static void main(String[] args) {
        double base = 2.0;
        int exponent = 4;
        double power = Power(base, exponent);
        System.out.println(power);

    }

}
