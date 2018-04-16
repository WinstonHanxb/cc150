package chapter9;

public class RobotII {
    /**
     * 有一个XxY的网格，
     * 一个机器人只能走格点且只能向右或向下走，
     * 要从左上角走到右下角。
     * 请设计一个算法，计算机器人有多少种走法。
     * 注意这次的网格中有些障碍点是不能走的。
     * <p>
     * 给定一个int[][] map(C++ 中为vector >),表示网格图，
     * 若map[i][j]为1则说明该点不是障碍点，否则则为障碍。
     * <p>
     * 另外给定int x,int y，表示网格的大小。
     * 请返回机器人从(0,0)走到(x - 1,y - 1)的走法数，为了防止溢出，请将结果Mod 1000000007。保证x和y均小于等于50
     */
    public int countWays(int[][] map, int x, int y) {
        if(map[0][0] != 1) return 0;
        int[] dp = new int[y];
        dp[0] = 1;
        for (int i = 1; i < y; i++) {
            if (map[0][i] == 1) dp[i] = dp[i-1];
            else dp[i] = 0;
        }
        for (int i = 1; i < x; i++) {
            if(map[i][0] != 1) dp[0] = 0;
            for (int j = 1; j < y; j++) {
                if (map[i][j] != 1) dp[j] = 0;
                else {
                    dp[j] = (dp[j-1]+dp[j]) % 1000000007;
                }
            }
        }
        return dp[y - 1];
    }
}
