package chapter1;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Reverse rv = new Reverse();
        while (sc.hasNext()) System.out.println(rv.reverseString(sc.next()));
    }

//    请实现一个算法，在不使用额外数据结构和储存空间的情况下，翻转一个给定的字符串(可以使用单个过程变量)。
//    给定一个string iniString，请返回一个string，为翻转后的字符串。保证字符串的长度小于等于5000。
    // java不允许直接操纵字符串,因此申请一个数组来使用
    public String reverseString(String iniString) {
        // write code here
        char[] chars = iniString.toCharArray();
        char temp;
        for (int i = 0; i < chars.length /2; i++) {
            temp = chars[i];
            chars[i] = chars[chars.length-1-i];
            chars[chars.length-1-i] = temp;
        }
        return new String(chars);
    }
}