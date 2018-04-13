package chapter6_8;

import java.math.BigDecimal;

public class CrossLine {
    /**
     * 给定直角坐标系上的两条直线，
     * 确定这两条直线会不会相交。
     * 线段以斜率和截距的形式给出，
     * 即double s1，double s2，double y1，double y2，
     * 分别代表直线1和2的斜率(即s1,s2)和截距(即y1,y2)，
     * <p>
     * 请返回一个bool，
     * 代表给定的两条直线是否相交。
     * 这里两直线重合也认为相交。
     */
    public boolean checkCrossLine(double s1, double s2, double y1, double y2) {
        BigDecimal S1 =new BigDecimal(s1);
        BigDecimal S2 = new BigDecimal(s2);
        BigDecimal Y1 = new BigDecimal(y1);
        BigDecimal Y2 = new BigDecimal(y2);
        if (S1.compareTo(S2) == 0 && Y1.compareTo(Y2) == 0) return true;//重合
        return S1.compareTo(S2) != 0;
    }
}
