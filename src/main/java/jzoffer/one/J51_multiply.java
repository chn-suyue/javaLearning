package jzoffer.one;

/**
 * @description:
 * @author: suyue
 * @time: 2021/3/21 15:01
 */
public class J51_multiply {

    public int[] multiply(int[] A) {
        //方法1：分两种情况，包含0和不包含0。但是题目要求不能使用除法，见方法2
        /*if (A == null || A.length <= 1) return null;
        int[] B = new int[A.length];
        List<Integer> zeroList = new ArrayList<>();
        int mul = 1;
        for (int i = 0; i < A.length; i++) {
            mul = mul * A[i];
            if (A[i] == 0) zeroList.add(i);
        }

        if (zeroList.size() == 0) {//不包含0
            for (int j = 0; j < B.length; j++) {
                B[j] = mul / A[j];
            }
        } else if (zeroList.size() == 1) {//只包含一个0
            Arrays.fill(B, 0);
            int mult = 1;
            for (int m = 0; m < A.length; m++) {
                if (m != zeroList.get(0)) {
                    mult = mult * A[m];
                }
            }
            B[zeroList.get(0)] = mult;
        } else {//不止一个0
            Arrays.fill(B, 0);
        }
        return B;*/

        //方法2：递归或动态规划
        // B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]=left[i]*right[i]
        // left[i]=A[0]*A[1]*...*A[i-1] -> left[i+1]=left[i]*A[i], left[0]=1
        // right[i]=A[i+1]*...*A[n-1] -> right[i]=right[i+1]*A[i+1], right[n-1]=1
        if (A == null || A.length <= 1) return null;
        int[] B = new int[A.length];
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        left[0] = 1;
        right[right.length - 1] = 1;
        for (int i = 1; i < left.length; i++) {
            left[i] = left[i - 1] * A[i - 1];
        }
        for (int j = right.length - 2; j >= 0; j--) {
            right[j] = right[j + 1] * A[j + 1];
        }
        for (int m = 0; m < B.length; m++) {
            B[m] = left[m] * right[m];
        }
        return B;

    }

}
