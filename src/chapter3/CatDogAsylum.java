package chapter3;

import java.util.ArrayList;

public class CatDogAsylum {
    /**
     * 有家动物收容所只收留猫和狗，但有特殊的收养规则，
     * 收养人有两种收养方式，
     * 第一种为直接收养所有动物中最早进入收容所的，
     * 第二种为选择收养的动物类型（猫或狗），并收养该种动物中最早进入收容所的。
     * <p>
     * <p>
     * 给定一个操作序列int[][2] ope代表所有事件。
     * <p>
     * 若第一个元素为1，则代表有动物进入收容所，
     * 第二个元素为动物的编号，正数代表狗，负数代表猫；
     * <p>
     * 若第一个元素为2，则代表有人收养动物，
     * 第二个元素若为0，则采取第一种收养方式，若为1，则指定收养狗，若为-1则指定收养猫。
     * <p>
     * <p>
     * 请按顺序返回收养的序列。
     * <p>
     * <p>
     * 若出现不合法的操作，即没有可以符合领养要求的动物，则将这次领养操作忽略。
     */

    private final static int PUSH = 1;
    private final static int POP = 2;
    private final static int ADOPT_FIRST = 0;
    private final static int ADOPT_DOG = 1;
    private final static int ADOPT_CAT = -1;

    public ArrayList<Integer> asylum(int[][] ope) {
        // write code here
        ArrayList<Integer> shelter = new ArrayList<>();
        ArrayList<Integer> adopt_sequence = new ArrayList<>();
        int tempIndex;
        for (int[] operate : ope) {
            switch (operate[0]) {
                case PUSH: {
                    if(operate[1] != 0) shelter.add(operate[1]);
                    break;
                }
                case POP: {
                    if(shelter.isEmpty()) break;
                    switch (operate[1]) {
                        case ADOPT_FIRST: {
                            adopt_sequence.add(shelter.remove(0));
                            break;
                        }
                        case ADOPT_DOG: {
                            tempIndex = 0;
                            while(tempIndex<shelter.size() && shelter.get(tempIndex) < 0) tempIndex++;
                            if(tempIndex<shelter.size()) adopt_sequence.add(shelter.remove(tempIndex));
                            break;
                        }
                        case ADOPT_CAT: {
                            tempIndex = 0;
                            while(tempIndex<shelter.size() && shelter.get(tempIndex) > 0) tempIndex++;
                            if(tempIndex<shelter.size()) adopt_sequence.add(shelter.remove(tempIndex));
                            break;
                        }
                        default:
                            break;
                    }
                    break;
                }
                default:
                    break;
            }
        }
        return adopt_sequence;
    }


    public static void main(String[] args) {
        int[][] ope = {{1,-5},{1,-1},{1,9},{1,9},{2,0},{2,1},{1,-8},{2,1},{1,-71},{1,-92},{1,18},{1,91},{1,61},{2,
                -1},{1,-35},{1,95},{1,-49},{1,9},{1,78},{2,0},{1,91},{1,-96},{2,-1},{2,0},{2,-1},{2,1},{1,38},{2,0},{1,45},{2,0},{1,-51},{2,1},{2,1},{2,-1},{1,39},{1,59},{1,45},{2,0},{1,-70},{2,0},{1,23},{1,88},{1,83},{1,69},{1,-78},{1,-3},{1,-9},{1,-20},{1,-74},{1,-62},{1,5},{1,55},{1,-36},{1,-21},{1,-94},{1,-27},{1,-69},{2,0},{1,-30},{1,-84},{2,0},{2,0},{2,-1},{1,92},{1,60},{2,1},{2,0},{1,-63},{2,0},{1,-87},{1,66},{2,0},{1,17},{2,0},{2,1},{1,-41},{1,-3},{1,-29},{1,72},{2,1},{1,35},{1,81},{1,-83},{1,-17},{1,36},{1,99},{1,-17},{1,8},{2,0},{1,80},{1,50},{1,80},{2,0},{1,-48},{1,-82},{1,-63},{1,2},{2,1},{1,-43},{1,59},{1,93},{1,55},{1,-93},{2,-1},{1,2},{1,13},{2,0}};
        CatDogAsylum asylum = new CatDogAsylum();
        asylum.asylum(ope);
    }
}