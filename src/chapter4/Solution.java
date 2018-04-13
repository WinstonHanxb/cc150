package chapter4;

import java.util.ArrayList;

public class Solution {
    /**
     * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
     * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        if (root.left == null && root.right == null && root.val == target) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(root.val);
            res.add(temp);
        }
        FindPath(root.left, target - root.val).forEach(list -> addRes(root, res, list));
        FindPath(root.right, target - root.val).forEach(list -> addRes(root, res, list));
        return res;
    }

    private void addRes(TreeNode root, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list) {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(root.val);
        list.forEach(val -> temp.add(val));
        res.add(temp);
    }

}