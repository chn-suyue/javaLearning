package jzoffer.leetcode;

/**
 * @description:
 * @author: suyue
 * @time: 2022/1/6 20:41
 */
public class JT66_constructArr {

    public int[] constructArr(int[] a) {
        //方法1、暴力法, 超时了。。。
        /*int[] b = new int[a.length];
        for (int i=0; i<b.length; i++) {
            int temp = 1;
            for (int j=0; j<a.length; j++) {
                if (j!=i) {
                    temp = temp * a[j];
                }
            }
            b[i]=temp;
        }

        return b;*/

        //方法2、上三角和下三角
        int length = a.length;
        int[] b = new int[length];

        int[] m = new int[length];
        int[] n = new int[length];

        //上三角
        for (int i=0; i<length; i++) {
            if (i==0) {
                m[i]=1;
            } else {
                m[i] = m[i-1]*a[i-1];
            }
        }
        //下三角
        for (int j=length-1; j>=0; j--) {
            if (j==length-1) {
                n[j]=1;
            } else {
                n[j]=n[j+1]*a[j+1];
            }
        }

        for (int i=0; i<length; i++) {
            b[i]=m[i]*n[i];
        }

        return b;

    }

}
