package chapter1;

public class Clearer {
    // 请编写一个算法，若N阶方阵中某个元素为0，则将其所在的行与列清零。
    // 给定一个N阶方阵int[][](C++中为vector<vector><int>>)mat和矩阵的阶数n，
    // 请返回完成操作后的int[][]方阵(C++中为vector<vector><int>>)，
    // 保证n小于等于300，矩阵中的元素为int范围内。</int></vector></int></vector>
    public int[][] clearZero(int[][] mat, int n) {
        // write code here
        //使用第一行第一列作为记录
        boolean firRow=false,firCol=false;
        //记录一下第一行第一列是否需要置0
        for (int j = 0; j < n; j++)
            if (mat[0][j] == 0) {
                firRow = true;
                break;
            }
        for (int i = 0; i < n; i++)
            if (mat[i][0] == 0) {
                firCol = true;
                break;
            }
        //遍历并记录
        for (int x = 1; x < n; x++) {
            for (int y = 1; y < n; y++) {
                if(mat[x][y] == 0){
                    mat[0][y] = 0;
                    mat[x][0] = 0;
                }
            }
        }
        //对第一行和第一列以外的进行置0
        for (int x = 1; x < n; x++) {
            for (int y = 1; y < n; y++) {
                if(mat[x][0]==0 || mat[0][y]==0){
                    mat[x][y] = 0;
                }
            }
        }
        //对第一行和第一列
        if (firRow) {
            for (int i = 0; i < n; i++)
                mat[0][i] = 0;
        }
        if (firCol) {
            for (int j = 0; j < n; j++)
                mat[j][0] = 0;
        }

        return mat;
    }
}
