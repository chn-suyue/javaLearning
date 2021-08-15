package jzoffer.one;

/**
 * @description:
 * @author: suyue
 * @time: 2021/3/14 2:19
 */
public class J46_LastRemaining_Solution {

    public static int LastRemaining_Solution(int n, int m) {
        //方法1：模拟，使用数组，巨麻烦，时间复杂度巨大
        /*if (n <= 0) return -1;
        int result = 0;
        int count = 0;
        int aCount = 0;
        int index = 0;
        int num = m % n;
        boolean flag = true;
        int[] array = new int[n];
        Arrays.fill(array, 1);
        while (flag) {
            while (index < array.length) {//从当前位置index遍历循环array数组，数出第m个置为-1
                if (array[index] == 1) aCount++;
                if (aCount == num) {
                    array[index] = -1;
                    aCount=0;
                    break;
                }
                index++;
                if (index == array.length) index = 0;
            }
            count++;
            if (count == n - 1) flag = false;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] != -1) {
                result = i;
            }
        }
        return result;*/

        //方法2：模拟，使用linkedList，找到选中元素，删除该元素，list长度减1
        //时间复杂度：O(mn)，每次都要对linkedList遍历m次，找到index位置元素并将其删除
        //空间复杂度：O(1)
        /*if (n <= 0) return -1;
        //初始化list
        LinkedList<Integer> list = new LinkedList<>();
        for (int i=0; i<n; i++) {
            list.add(i);
        }

        int index =0;
        while (n>1) {
            index = (index+m-1)%n;//关键：每次去掉一个选中元素后，下个选中元素的下标
            list.remove(index);
            n--;
        }
        return list.get(0);*/

        //方法3：递归，约瑟夫环问题，f(n,m)=(f(n-1,m)+m)%n
        //时间复杂度：O(n)
        //空间复杂度：O(1)
        /*if (n <= 0) return -1;
        if (n == 1) return 0;
        return (LastRemaining_Solution(n - 1, m) + m) % n;*/

        //方法4：动态规划
        //时间复杂度：O(n)
        //空间复杂度：O(n)
        if (n <= 0) return -1;
        // 初始化
        int[] dp = new int[n];
        // 初始条件
        dp[0] = 0;
        // 转移方程和计算顺序
        for (int i = 1; i < n; i++) {
            dp[i] = (dp[i - 1] + m) % (i+1);
        }
        return dp[n - 1];

    }

    public static void main(String[] args) {
        int i = LastRemaining_Solution(5, 3);
        System.out.println(i);
    }

}
