package jzoffer.newcode;

/**
 * @description:
 * @author: suyue
 * @time: 2021/3/14 1:12
 */
public class J43_LeftRotateString {

    public static String LeftRotateString(String str, int n) {
        //方法1：转成char数组处理
        /*if (str == null || str.equals("")) return str;
        char[] chars = str.toCharArray();
        int num = n % chars.length;
        char[] tempChars = new char[num];
        for (int i = 0; i < tempChars.length; i++) {//需要从数组头部调整到的尾部的num个字符用临时数组存储
            tempChars[i] = chars[i];
        }
        for (int j = 0; j < chars.length - num; j++) {//将数组后方chars.length-num个字符移至数组前方
            chars[j] = chars[j + num];
        }
        for (int m = 0; m < tempChars.length; m++) {//将临时数组中存放的num个字符移至原始数据的后方
            chars[chars.length - num + m] = tempChars[m];
        }
        return String.valueOf(chars);*/

        //方法2：使用substring()方法
        if (str == null || str.equals("")) return str;
        int num = n % str.length();
        return str.substring(num, str.length()) + str.substring(0, num);

    }

    public static void main(String[] args) {
        String str = "";
        int n = 3;
        String s = LeftRotateString(str, 3);
        System.out.println(s);
    }

}
