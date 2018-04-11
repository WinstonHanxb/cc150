package chapter3;

import java.util.ArrayList;

public class SetOfStacks {

    public static void main(String[] args) {
        int[][] test= {{1,97868},{1,69995},{1,28525},{1,72341},{1,86916},{1,5966},{2,58473},{2,93399},{1,84955},{1,
                16420},{1,96091},{1,45179},{1,59472},{1,49594},{1,67060},{1,25466},{1,50357},{1,83509},{1,39489},{2,51884},{1,34140},{1,8981},{1,50722},{1,65104},{1,61130},{1,92187},{2,2191},{1,2908},{1,63673},{2,92805},{1,29442}};
        setOfStacks(test,2);
    }
    /**
     * 请实现一种数据结构SetOfStacks，由多个栈组成，
     * 其中每个栈的大小为size，当前一个栈填满时，新建一个栈。
     * 该数据结构应支持与普通栈相同的push和pop操作。
     * 给定一个操作序列int[][2] ope(C++为vector&ltvector&ltint>>)，
     * 每个操作的第一个数代表操作类型，
     * 若为1，则为push操作，后一个数为应push的数字；
     * 若为2，则为pop操作，后一个数无意义。
     * 请返回一个ArrayList<ArrayList<Integer>>，
     * 为完成所有操作后的SetOfStacks，
     * 顺序应为从下到上，默认初始的SetOfStacks为空。保证数据合法。
     */
    private static final int PUSH = 1;
    private static final int POP = 2;

    public static ArrayList<ArrayList<Integer>> setOfStacks(int[][] ope, int size) {
        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(ope.length == 0|| ope == null) return res;
        int stackCount = 0;
        ArrayList<Integer> cur = new ArrayList<>(size);
        int stackSize = 0;
        for (int[] operates : ope) {
            switch (operates[0]) {
                case PUSH: {
                    if (stackSize == size) {
                        res.add(cur);
                        stackCount++;
                        cur = new ArrayList<>(size);
                        stackSize = 0;
                    }
                    cur.add(operates[1]);
                    stackSize++;
                    break;
                }
                case POP: {
                    if (stackSize == 0) {
                        cur = res.remove(--stackCount);
                        stackSize = size;
                    }
                    cur.remove(--stackSize);
                    break;
                }
            }
        }
        if(stackSize!=0) res.add(cur);
        return res;
    }
}
