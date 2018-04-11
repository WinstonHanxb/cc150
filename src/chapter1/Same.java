package chapter1;

public class Same {
//    给定两个字符串，请编写程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
//    这里规定大小写为不同字符，且考虑字符串重点空格。
//    给定一个string stringA和一个string stringB，请返回一个bool，
//    代表两串是否重新排列后可相同。保证两串的长度都小于等于5000。
    public boolean checkSam(String stringA, String stringB) {
        // write code here
        int temp=stringA.charAt(0);
        for (int i = 1; i < stringA.length(); i++) {
            temp = temp ^ stringA.charAt(i);
        }
        for (int i = 0; i < stringB.length(); i++) {
            temp = temp ^ stringB.charAt(i);
        }
        return temp==0;
    }
}
