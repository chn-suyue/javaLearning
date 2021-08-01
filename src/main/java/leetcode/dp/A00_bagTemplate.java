package leetcode.dp;

/**
 * @description: 背包问题模板总结
 * <p>
 * 首先，确定此问题属于背包问题。
 * 然后，确定此问题是背包问题的哪种类型。
 * 最后，根据背包问题类型模板求解。
 * <p>
 * 背包问题的定义：给定一个背包容量target，再给定一个数组weight(物品)，能否按一定方式选取weight中的元素得到target。
 * 注意：
 * 1、背包容量target和物品weight的类型可能是数，也可能是字符串
 * 2、target可能题目已经给出(显式)，也可能是需要我们从题目的信息中挖掘出来(非显式)(常见的非显式target比如sum/2等)
 * 3、选取方式有常见的一下几种：每个元素选一次/每个元素选多次/选元素进行排列组合
 * <p>
 * 背包问题的分类：
 * 常见的背包类型主要有以下几种：
 * 1、0/1背包问题：每个元素最多选取一次
 * 2、完全背包问题：每个元素可以重复选择
 * <p>
 * 而每个背包问题要求的也是不同的，按照所求问题分类，又可以分为以下几种：
 * 1、最值问题：要求最大值/最小值
 * 2、存在问题：是否存在…………，满足…………
 * 3、计数问题：求所有满足……的排列组合数量
 * <p>
 * 因此把背包类型和问题类型结合起来就会出现以下细分的题目类型：
 * 1、0/1背包最值问题
 * 2、0/1背包存在问题
 * 3、0/1背包计数问题
 * 4、完全背包最值问题
 * 5、完全背包存在问题
 * 6、完全背包计数问题
 * @author: suyue
 * @time: 2021/7/31 16:46
 */
public class A00_bagTemplate {

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] values = {15, 20, 30};
        int target = 4;

        int maxValue = basicBagTemplate(weight, values, target);
        System.out.println(maxValue);

    }

    /**
     * 01背包基础问题：
     * 有 n 件物品和⼀个容量为 target 的背包。第i件物品的重量是 weight[i]，得到的价值是value[i] 。
     * 每件物品只能用⼀次，求解将哪些物品装⼊背包里物品价值总和最⼤。
     * <p>
     * 基础模板:
     */
    public static int basicBagTemplate(int[] weight, int[] values, int target) {

        /**
         * dp[i][j]的含义：
         *      从0到i件物品中，选取若干物品，装入容量为 j 的背包，使得背包内物品价值总和最大为 dp[i][j]
         * 状态方程：
         *      dp[i][j]=max{dp[i-1][j], dp[i-1][j-weight[i]]+values[i]}
         * 初始条件：
         *      当j=0时，dp[i][0]=0；
         *      当i=0时，分两种情况：
         *          一、当j<weight[0]时，dp[i][j]=0；
         *          二、当j>=weight[0]，dp[i][j]=values[0]
         * 计算顺序：
         *      外层物品从小到大，内层背包从大到小
         */

        int[][] dp = new int[weight.length][target + 1];

        for (int i = 0; i < weight.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < target + 1; j++) {
            if (j >= weight[0]) {
                dp[0][j] = values[0];
            } else {
                dp[0][j] = 0;
            }
        }

        for (int i = 1; i < weight.length; i++) {
            for (int j = target; j >= 1; j--) {
                if (j >= weight[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + values[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[weight.length - 1][target];

    }


}
