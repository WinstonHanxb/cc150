package chapter9;

import java.util.Stack;

public class Parenthesis {
    /**
     * 对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。
     * 给定一个字符串A和它的长度n，请返回一个bool值代表它是否为一个合法的括号串。
     */
    public boolean chkParenthesis(String A, int n) {
        Stack<Character> s = new Stack<>();
        for(char ch:A.toCharArray()){
            switch(ch){
                case('('):{
                    s.push(ch);
                    break;
                }
                case(')'):{
                    if(s.isEmpty()) return false;
                    else s.pop();
                    break;
                }
                default:{
                    return false;
                }
            }
        }
        return true;
    }
}