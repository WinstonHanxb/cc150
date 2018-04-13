package chapter4;

import java.util.LinkedList;
import java.util.Queue;

public class LCA {
    public static void main(String[] args) {
        LCA lca = new LCA();
        System.out.println(lca.getLCA(8,9));
    }
    /**
     * 有一棵无穷大的满二叉树，其结点按根结点一层一层地从左往右依次编号，根结点编号为1。
     * 现在有两个结点a，b。
     * 请设计一个算法，求出a和b点的最近公共祖先的编号。
     * 给定两个int a,b。
     * 为给定结点的编号。
     * 请返回a和b的最近公共祖先的编号。
     * 注意这里结点本身也可认为是其祖先。
     */
    public int getLCA(int a, int b) {
        // write code here
        if (a == b) return a;
        TreeNode root = createTree(Math.max(a, b));
        return getLCA(root,a,b);
    }

    public int getLCA(TreeNode root, int a, int b) {
        boolean findALeft = find(root.left, a);
        boolean findARight = find(root.right, a);
        boolean findBLeft = find(root.left, b);
        boolean findBRight = find(root.right, b);
        if((root.val == a) && (findBLeft||findBRight)) return a;
        if((root.val == b) && (findALeft||findARight)) return b;
        if(findALeft && findBLeft) return getLCA(root.left,a,b);
        if(findARight && findBRight) return getLCA(root.right,a,b);
        return root.val;
    }

    private boolean find(TreeNode root, int target) {
        if (root == null) return false;
        if (root.val == target) return true;
        return find(root.left, target) || find(root.right, target);
    }


    TreeNode createTree(int range) {
        if (range <= 0) return null;
        TreeNode root, p;
        int temp = 1;
        root = p = new TreeNode(temp++);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (temp <= range) {
            p = q.poll();
            if (temp <= range) {
                p.left = new TreeNode(temp++);
                q.offer(p.left);
            }
            if (temp <= range) {
                p.right = new TreeNode(temp++);
                q.offer(p.right);
            }
        }
        return root;
    }
}
