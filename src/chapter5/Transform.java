package chapter5;

public class Transform {
    /**
     * 编写一个函数，确定需要改变几个位，才能将整数A转变成整数B。
     * 给定两个整数int A，int B。请返回需要改变的数位个数。
     */
    public int calcCost(int A, int B) {
        int temp = A ^ B;
        int count = 0;
        while(temp!=0){
            temp = temp & (temp-1);
            count++;
        }
        return count;
    }
}
