package chapter6_8;

import java.util.HashMap;

public class DenseLine {
    /**
     * 在二维平面上，有一些点，请找出经过点数最多的那条线。
     * <p>
     * 给定一个点集vector<point>p和点集的大小n,
     * 没有两个点的横坐标相等的情况,
     * 请返回一个vector<double>，
     * 代表经过点数最多的那条直线的斜率和截距。</double></point>
     */
    public double[] getLine(Point[] p, int n) {
        HashMap<Result, Integer> hashCount = new HashMap<>();
        int max = 0;
        double slope,intercept;
        slope = intercept =0;
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p.length; j++) {
                double k = (double) (p[j].y - p[i].y) / (p[j].x - p[i].x);
                double b = (double) (p[i].y - k * p[i].x);
                Result line = new Result(k, b);
                if (hashCount.containsKey(line)) {
                    int num = hashCount.get(line) + 1;
                    hashCount.put(line, num);
                    //不断调整最大值
                    if (num > max) {
                        max = num;
                        slope = k;
                        intercept = b;
                    }
                } else
                    hashCount.put(line, 1);
            }
        }
        return new double[]{slope,intercept};
    }


    class Result {
        double k;
        double b;
        double epsilon = 0.0001; //误差

        public Result(double k, double b) {
            this.k = k;
            this.b = b;
        }

        public boolean isEquals(double a, double b) {
            return (Math.abs(a - b) < epsilon);
        }

        public boolean equals(Object obj) {
            if (obj instanceof Result) {
                if (isEquals(k, ((Result) obj).k) && isEquals(b, ((Result) obj).b))
                    return true;
                return false;
            }
            return super.equals(obj);
        }

        public int hashCode() {
            String str = String.valueOf(k) + String.valueOf(b);
            return str.hashCode();
        }
    }
}
