package chapter5;

public class BinDecimal {
    /**
     * 有一个介于0和1之间的实数，类型为double，返回它的二进制表示。
     * 如果该数字无法精确地用32位以内的二进制表示，返回“Error”。
     * 给定一个double num，表示0到1的实数，请返回一个string，代表该数的二进制表示或者“Error”。
     */
    public String printBin(double num) {
        // write code here
        if(num <=0 || num >=1) return "Error";
        StringBuilder sb = new StringBuilder();
        sb.append(".");
        while (num > 0) {
            if (sb.length() >= 32) {
                return "Error";
            }

            double r = num*2;
            if (r >= 1) {
                sb.append(1);
                num = r-1;
            }else{
                sb.append(0);
                num = r;
            }
        }
        return sb.toString();
    }
}