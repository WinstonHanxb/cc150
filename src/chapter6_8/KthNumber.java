package chapter6_8;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class KthNumber {
    /**
     * 有一些数的素因子只有3、5、7，请设计一个算法，找出其中的第k个数。
     * 给定一个数int k，请返回第k个数。保证k小于等于100。
     */
    public  int findKth(int k) {
        Queue<Integer> q3 = new LinkedList<>();
        Queue<Integer> q5 = new LinkedList<>();
        Queue<Integer> q7 = new LinkedList<>();
        q3.add(3);
        q5.add(5);
        q7.add(7);
        int count = 0;
        int temp = 0;
        while(count < k){
            temp = Math.min(Math.min(q3.peek(),q5.peek()),q7.peek());
            if(temp == q3.peek()){
                q3.poll();
                q3.add(3*temp);
                q5.add(5*temp);
                q7.add(7*temp);
            }
            if(temp == q5.peek()){
                q5.poll();
                q5.add(temp*5);
                q7.add(temp*7);
            }
            if(temp == q7.peek()){
                q7.poll();
                q7.add(temp*7);
            }
            count++;
        }
        return temp;
    }
}
