package chapter9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Permutation {

    public static void main(String[] args) {
        Permutation pr = new Permutation();
        pr.getPermutation("NXX");
    }
    /**
     * 编写一个方法，确定某字符串的所有排列组合。
     * <p>
     * 给定一个string A和一个int n,代表字符串和其长度，
     * 请返回所有该字符串字符的排列，
     * 保证字符串长度小于等于11且字符串中字符均为大写英文字符，
     * 排列中的字符串按字典序从大到小排序。(不合并重复字符串)
     */
    public ArrayList<String> getPermutation(String A) {
        // write code here
        char[] chs = A.toCharArray();
        ArrayList<String> res = new ArrayList<>();
        getPermutation(res,chs,0,chs.length-1);
        Collections.sort(res);
        Collections.reverse(res);
        return res;
    }

    private static void getPermutation(ArrayList<String> list,char[] chs,int start,int end) {
        if(start == end){
            list.add(new String(chs));
        }
        for (int i = start; i <= end; i++) {
            swap(chs,i,start);
            getPermutation(list,chs,start+1,end);
            swap(chs,i,start);
        }
    }

    private static void swap(char[] chs,int i,int j){
        char temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
    }
}