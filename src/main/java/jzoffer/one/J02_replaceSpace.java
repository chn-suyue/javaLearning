package jzoffer.one;

/**
 * @description:
 * @author: suyue
 * @time: 2021/1/8 20:51
 */
public class J02_replaceSpace {

    public static String replaceSpace(StringBuffer str) {
//        return str.toString().replace(" ", "%20");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.toString().length(); i++) {
            if (str.toString().charAt(i) == ' ') {
                result.append("%20");
            } else {
                result.append(str.toString().charAt(i));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("we are happy");
        System.out.println(stringBuffer);
        System.out.println(replaceSpace(stringBuffer));

    }

}
