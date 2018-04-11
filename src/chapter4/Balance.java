package chapter4;


import java.util.HashMap;

public class Balance {
    /**
     * 实现一个函数，检查二叉树是否平衡，
     * 平衡的定义如下，对于树中的任意一个结点，其两颗子树的高度差不超过1。
     * 给定指向树根结点的指针TreeNode* root，请返回一个bool，代表这棵树是否平衡。
     */
    public boolean isBalance(TreeNode root) {
        // write code here
        if (root == null) return true;
        maps = new HashMap<>();
        return isBalance(root.left) && isBalance(root.right) && (Math.abs(maps.getOrDefault(root.left,height(root.left))-maps.getOrDefault(root.right,height(root.right))) < 2);
    }

    HashMap<TreeNode,Integer> maps;
    private int height(TreeNode root) {
        if (root == null) return 0;
        else {
            int left = maps.getOrDefault(root.left,height(root.left));
            int right = maps.getOrDefault(root.right,height(root.right));
            int height = Math.max(left,right) + 1;
            maps.put(root,height);
            return height;
        }
    }
}