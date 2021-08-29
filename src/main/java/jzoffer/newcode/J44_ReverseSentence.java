package jzoffer.newcode;

/**
 * @description:
 * @author: suyue
 * @time: 2021/3/14 1:34
 */
public class J44_ReverseSentence {

    public String ReverseSentence(String str) {
        //思路：用空格分割，再倒序拼接
        if (str == null || str.trim().equals("")) return str;
        String[] arr = str.split(" ");
        StringBuilder sb = new StringBuilder();
        if (arr.length > 0) {
            for (int i = arr.length - 1; i >= 0; i--) {
                sb.append(arr[i]);
                if (i != 0) sb.append(" ");
            }
        }
        return sb.toString();
    }


}
