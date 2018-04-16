package chapter9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Subset {

    public static void main(String[] args) {
        Subset sb = new Subset();
        int[] test = {123,456,789};
        sb.getSubsets(test,test.length);
    }
    /**
     * 请编写一个方法，返回某集合的所有非空子集。
     *
     * 给定一个int数组A和数组的大小int n，请返回A的所有非空子集。
     * 保证A的元素个数小于等于20，且元素互异。各子集内部从大到小排序,子集之间字典逆序排序，见样例。
     */
    public ArrayList<ArrayList<Integer>> getSubsets(int[] A, int n) {
        // write code here
        return DFS(A,n,0);
    }

    public ArrayList<ArrayList<Integer>> DFS(int[] A,int n,int index){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(index >= n) return res;
        ArrayList<ArrayList<Integer>> subList = DFS(A,n,index+1);
        for(ArrayList<Integer> list:subList){
            ArrayList<Integer> tmp = new ArrayList<>(list);
            tmp.add(A[index]);
            res.add(tmp);
            res.add(list);
        }
        ArrayList<Integer> self = new ArrayList<>();
        self.add(A[index]);
        res.add(self);
        return res;
    }
}
