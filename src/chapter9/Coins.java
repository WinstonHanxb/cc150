package chapter9;


public class Coins {
    public static void main(String[] args) {
        countWays(11746);
    }
    /**
     * 有数量不限的硬币，币值为25分、10分、5分和1分，请编写代码计算n分有几种表示法。
     * 给定一个int n，请返回n分有几种表示法。保证n小于等于100000，为了防止溢出，请将答案Mod 1000000007。
     */
    public static int countWays(int n) {
        int[][] dp = new int[5][n+1];
        dp[0][0] = 1;
        int[] coins ={1,5,10,25};
        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i-1][j] + (j >= coins[i-1] ? dp[i][j-coins[i-1]] : 0))%1000000007;
            }
        }
        return dp[coins.length][n];
    }
}
