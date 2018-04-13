package chapter5;

public class Exchange {
    /**
     * 请编写程序交换一个数的二进制的奇数位和偶数位。
     * （使用越少的指令越好）
     * 给定一个int x，请返回交换后的数int。
     */
    public int exchangeOddEven(int x) {
        int maskOdd = 0xaaaaaaaa;
        int maskEven = 0x55555555;
        return ((x & maskOdd)>>1) |((x&maskEven)<<1);
    }
}
