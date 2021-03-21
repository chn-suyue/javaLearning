package jzoffer;

/**
 * @description:
 * @author: suyue
 * @time: 2021/3/21 20:08
 */
public class J49_StrToInt {

    public int StrToInt(String str) {
        //使用库函数
        int num = 0;
        try {
            num = Integer.parseInt(str);
        } catch (NumberFormatException ignored) {

        }
        return num;
    }

}
