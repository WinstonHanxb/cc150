package chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class TwoStacks {
    /**
     * 请编写一个程序，按升序对栈进行排序（即最大元素位于栈顶），
     * 要求最多只能使用一个额外的栈存放临时数据，但不得将元素复制到别的数据结构中。
     * 给定一个int[] numbers(C++中为vector&ltint>)，其中第一个元素为栈顶，请返回排序后的栈。
     * 请注意这是一个栈，意味着排序过程中你只能访问到第一个元素。
     */

    public static void main(String[] args) {
        TwoStacks ts = new TwoStacks();
        int[] test = {1,2,2,3,4,4,5,5};
        System.out.println(Arrays.toString(ts.twoStacksSort(test).toArray()));

    }
    int[] stackArr = null;
    int top;
    int end;
    public ArrayList<Integer> twoStacksSort(int[] numbers) {
        // write code here
        stackArr = numbers;
        top = 0;
        end = numbers.length-1;
        Stack<Integer> stack = new Stack<>();
        int temp;
        int count;
        while(!isEmpty()){
            temp = pop();
            count = 0;
           //将这个弹出来插入合适的位置
            while(!stack.isEmpty() && temp <= stack.peek()){
                push(stack.pop());
                count++;
            }
            stack.push(temp);
            while(count-->0) stack.push(pop());
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(!stack.isEmpty()) res.add(stack.pop());
        return res;
    }

    public void push(int n){
        stackArr[--top] = n;
    }
    boolean isEmpty(){
        return top > end;
    }

    public int pop(){
        return stackArr[top++];
    }

}