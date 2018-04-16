package chapter9;

import java.util.ArrayList;

public class Queens {
    public static void main(String[] args) {
        nQueens(9);
    }

    /**
     * 请设计一种算法，解决著名的n皇后问题。
     * 这里的n皇后问题指在一个nxn的棋盘上放置n个棋子，使得每行每列和每条对角线上都只有一个棋子，求其摆放的方法数。
     * <p>
     * 给定一个int n，请返回方法数，保证n小于等于15
     */
    public static int nQueens(int n) {
        return DFS(n, 0, new ArrayList<>());
    }

    private static int DFS(int n, int col, ArrayList<Integer> rows) {
        int count = 0;
        if (n == col) //说明全部排序完了
        {
            return 1;
        } else {
            for (int row = 0; row < n; row++) {
                if (!rows.contains(row) && !onDiagonal(row, col, rows)) {
                    rows.add(row);
                    count += DFS(n, col + 1, rows);
                    rows.remove(col);
                }
            }
        }
        return count;
    }

    //判断是否和前面的在同一个对角线上
    private static boolean onDiagonal(int row2, int col2, ArrayList<Integer> rows) {

        for (int col1 = 0; col1 < col2; col1++) {
            int row1 = rows.get(col1);
            if (Math.abs(row2 - row1) == col2 - col1) {
                return true;
            }
        }
        return false;
    }


}