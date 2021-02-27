package jzoffer;

/**
 * @description:
 * @author: suyue
 * @time: 2021/2/15 20:19
 */
public class J13_reOrderArray {

    public static void reOrderArray(int[] array) {
        //方法1：开辟新的数组。时间复杂度O(n)，空间复杂度O(n)
        /*int[] dupArr = new int[array.length];
        int m=0;
        for (int i=0; i<array.length; i++) {
            if (array[i]%2==1) {
                dupArr[m]=array[i];
                m++;
            }
        }
        int n = m;
        for (int i=0; i<array.length; i++) {
            if (array[i]%2==0) {
                dupArr[n]=array[i];
                n++;
            }
        }
        for(int i=0; i<array.length; i++) {
            array[i]=dupArr[i];
        }*/

        //方法2：不开辟新的数组。循环n次，如果遇到偶数，则将后面所有数均向前平移一位，该偶数移至数组最后一位。时间复杂度O(n^2)，空间复杂度O(1)
        /*int count = 0;
        for (int i = 0; i < array.length - count; i++) {
            if (array[i] % 2 == 0) {
                int temp = array[i];
                for (int j = i + 1; j < array.length; j++) {
                    array[j - 1] = array[j];
                }
                array[array.length - 1] = temp;
                count++;
            }
        }*/

        //方法3：不开辟新的数组。有两个指针，i和j，i用来判断array[i]是否需要交换位置(即array[i]为偶数)，如果需要交换，那么和谁来交换，j即用来指向被交换的数(即array[i]最近的奇数)
        //时间复杂度O(n^2)，空间复杂度O(1)
        if(array.length <= 1){ // 数组空或长度为1
            return;
        }
        for (int i=0; i<array.length; i++) {
            if (array[i]%2==0) {
                int j = i+1;
                while (array[j]%2==0) {
                    if (j==array.length-1) return;
                    j++;
                }
                int temp = array[j];
                for (int m=j; m>i; m--) {
                    array[m] = array[m-1];
                }
                array[i] = temp;
            }
        }

        /*int len = array.length;
        if(len <= 1){ // 数组空或长度为1
            return;
        }
        int i = 0;
        while(i < len){
            int j = i + 1;
            if(array[i]%2 == 0){ // a[i]为偶数，j前进，直到替换
                while(array[j]%2 == 0){ // j为偶数，前进
                    if(j==len-1)// i为偶数，j也为偶数，一直后移到了末尾，证明后面都是偶数
                        return;
                    j++;
                }
                // 此时j为奇数
                int count = j-i;
                int temp = array[i];
                array[i] = array[j];
                while(count>1){
                    array[i+count] = array[i+count-1];//数组后移
                    count--;
                }
                array[i+1] = temp;
            }
            i++;
        }*/

    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        reOrderArray(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

}
