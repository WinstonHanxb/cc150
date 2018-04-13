package chapter6_8;


public class Bipartition {
    /**
     * 在二维平面上，有两个正方形，请找出一条直线，能够将这两个正方形对半分。
     * 假定正方形的上下两条边与x轴平行。
     *
     * 给定两个vecotrA和B，分别为两个正方形的四个顶点。请返回一个vector，代表所求的平分直线的斜率和截距，保证斜率存在。
     */
    public double[] getBipartition(Point[] A, Point[] B) {
        double x1 = (double)(A[0].x+A[1].x+A[2].x+A[3].x)/(double)4;
        double y1 = (double)(A[0].y+A[1].y+A[2].y+A[3].y)/(double)4;
        double x2 = (double)(B[0].x+B[1].x+B[2].x+B[3].x)/(double)4;
        double y2 = (double)(B[0].y+B[1].y+B[2].y+B[3].y)/(double)4;
        double s = (y1-y2) / (x1 -x2);
        double y = (y2 - x2*(y1-y2) / (x1 - x2));
        return new double[]{s,y};
    }
}


