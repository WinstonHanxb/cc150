package chapter9;

import java.util.stream.IntStream;

public class Robot {

    public static void main(String[] args) {
        countWays(1,11);
    }
    /**
     * 有一个XxY的网格，
     * 一个机器人只能走格点且只能向右或向下走，
     * 要从左上角走到右下角。
     * 请设计一个算法，计算机器人有多少种走法。
     *
     * 给定两个正整数int x,int y，
     * 请返回机器人的走法数目。
     * 保证x＋y小于等于12。
     */
    public static int countWays(int x, int y) {
        int[] dp = new int[y];
        for (int i = 0; i < y; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                dp[j] = dp[j-1] + dp[j];
            }
        }
        return dp[y-1];
//        int[] dp = new int[x];
//        for (int i = 0; i < x; i++) {
//            dp[i] = 1;
//        }
//        for (int i = 1; i < y; i++) {
//            for (int j = 1; j < x; j++) {
//                dp[j] =dp[j-1] + dp[j];
//            }
//        }
//        return dp[x-1];
    }
}
