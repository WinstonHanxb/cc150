package chapter4;

import java.util.Stack;

public class Checker {
    /**
     * 请实现一个函数，检查一棵二叉树是否为二叉查找树。
     * 给定树的根结点指针TreeNode* root，请返回一个bool，代表该树是否为二叉查找树。
     */

    /**
     * 若任意节点的左子树不空，则左子树上所有节点的值均小于它的根节点的值；
     * 若任意节点的右子树不空，则右子树上所有节点的值均大于它的根节点的值；
     * 任意节点的左、右子树也分别为二叉查找树；
     */
    public boolean checkBST(TreeNode root) {
        // write code here
        if (root == null) return true;
        Stack<TreeNode> treeStack = new Stack<>();
        int mark = Integer.MIN_VALUE;
        TreeNode cur = root;
        while (cur!=null||!treeStack.isEmpty()) {
            if (cur != null) {
                treeStack.push(cur);
                cur = cur.left;
            } else {
                cur = treeStack.pop();
                if (cur.val <= mark) return false;
                mark = cur.val;
                cur = cur.right;
            }
        }
        return true;
    }

}