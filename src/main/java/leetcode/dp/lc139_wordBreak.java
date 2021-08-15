package leetcode.dp;

import java.util.List;

/**
 * @description:
 * @author: suyue
 * @time: 2021/8/15 15:07
 */

public class lc139_wordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {

        /**
         * 思路：单词拆分，这道题目可以转化为子问题，有套娃的地方，比如 s = "applepenapple"，要判断s是否满足拆分要求，
         *      只需要判断 "applepen" 和 "apple" 是否满足。这道题难点在于之前动态规划的题目都是数值运算，这次是逻辑运算。
         *
         * 动态规划（普通-逻辑运算型）
         *
         * dp[i]的含义：对于 s[0,i) 子字符串，是否满足题目拆分要求。
         * 状态方程：dp[i] 如果为true, 则在 [0,i) 之间，存在一个数 j， 使得 dp[j] && wordDict.contains(s[j,i)) 为true
         * 初始条件：dp[0]=true
         * 计算顺序：从小到大
         *
         * 时间复杂度：O()
         * 空间复杂度：O()
         */

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];

    }







    /*public static void main(String[] args) {
        String s = "applepenapple";
        List wordDict = Arrays.asList("apple", "pen");
        boolean result = wordBreak(s, wordDict);
        System.out.println(result);
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }*/

}

