package chapter1;

public class Transform {
    // 有一副由NxN矩阵表示的图像，这里每个像素用一个int表示，
    // 请编写一个算法,在不占用额外内存空间的情况下(即不使用缓存矩阵)，将图像顺时针旋转90度。
    // 给定一个NxN的矩阵,和矩阵的阶数N,请返回旋转后的NxN矩阵,保证N小于等于500，图像元素小于等于256。
    public int[][] transformImage(int[][] mat, int n) {
        // write code here
        if(mat == null || n==1) return mat;
        int temp;
        for(int i=0;i<n/2;i++){
            for(int j=i;j<n-1-i;j++){
                temp = mat[i][j];
                mat[i][j]=mat[n-j-1][i];
                mat[n-j-1][i]=mat[n-i-1][n-j-1];
                mat[n-i-1][n-j-1]=mat[j][n-i-1];
                mat[j][n-i-1]=temp;
            }
        }
        return mat;
    }
}
