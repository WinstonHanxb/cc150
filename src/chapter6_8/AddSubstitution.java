package chapter6_8;

public class AddSubstitution {
    /**
     * 请编写一个方法，
     * 实现整数的乘法、减法和除法运算(这里的除指整除)。
     * 只允许使用加号。
     * <p>
     * 给定两个正整数int a,int b,
     * 同时给定一个int type代表运算的类型，
     * 1为求a ＊ b，
     * 0为求a ／ b，
     * -1为求a － b。
     * 请返回计算的结果，
     * 保证数据合法且结果一定在int范围内。
     */
    private static final int MULTIPLY = 1;
    private static final int DIVISION = 0;
    private static final int MINUS = -1;

    public int calc(int a, int b, int type) {
        int res = 0;
        switch (type) {
            case MULTIPLY: {
                for (int i = 0; i < b; i++) {
                    res += a;
                }
                break;
            }
            case DIVISION: {
                while (a >= b) {
                    res++;
                    a = a + ~b + 1;
                }
                break;
            }
            case MINUS: {
                res = a + ~b + 1;
                break;
            }
        }
        return res;
    }
}