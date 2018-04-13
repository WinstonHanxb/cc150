package chapter5;

public class CloseNumber {
    /**
     * 有一个正整数，
     * 请找出其二进制表示中1的个数相同、且大小最接近的那两个数。(一个略大，一个略小)
     * 给定正整数int x，
     * 请返回一个vector，
     * 代表所求的两个数（小的在前）。
     * 保证答案存在。
     */
    public int[] getCloseNumber(int x) {
        // write code here
        return new int[]{getPrev(x), getNext(x)};
    }

    //获取前一个数
    int getNext(int x) {
        int c = x;
        int c0 = 0;
        int c1 = 0;
        while (((c & 1) == 0) && (c != 0)) { //统计最右边为0的个数
            c0++;
            c = c >> 1;
        }
        while ((c & 1) == 1) { //统计1的个数
            c1++;
            c = c >> 1;
        }
        return x + (1 << c0) + (1 << (c1 - 1)) - 1;
    }

    //获取下一个数
    int getPrev(int x) {
        int c = x;
        int c0 = 0;
        int c1 = 0;

        while ((c & 1) == 1) {
            c1++;
            c = c >> 1;
        }
        while (((c & 1) == 0) && (c != 0)) {
            c0++;
            c = c >> 1;
        }
        return x - (1<< c1 ) - (1<<(c0 - 1)) +1;
    }

}
