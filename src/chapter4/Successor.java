package chapter4;

import java.util.Stack;

public class Successor {
    /**
     * 请设计一个算法，寻找二叉树中指定结点的下一个结点（即中序遍历的后继）。
     * 给定树的根结点指针TreeNode* root和结点的值int p，请返回值为p的结点的后继结点的值。
     * 保证结点的值大于等于零小于等于100000且没有重复值，若不存在后继返回-1。
     */
    public int findSucc(TreeNode root, int p) {
        if (root == null) return -1;
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        while(cur !=null || !s.isEmpty()){
            if(cur!=null){
                s.push(cur);
                cur = cur.left;
            }else{
                cur = s.pop();
                if(cur.val == p) break;
                else{
                    cur = cur.right;
                }
            }
        }
        if(cur == null) return -1;//没找到
        else{
            if(cur.right!=null){
                cur = cur.right;
                while(cur.left !=null ) cur = cur.left;
                return cur.val;
            }else{
                return s.pop().val;
            }
        }
    }
}