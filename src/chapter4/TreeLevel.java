package chapter4;

import java.util.LinkedList;
import java.util.Queue;

public class TreeLevel {
    /**
     * 对于一棵二叉树，请设计一个算法，创建含有某一深度上所有结点的链表。
     * 给定二叉树的根结点指针TreeNode* root，以及链表上结点的深度，
     * 请返回一个链表ListNode，代表该深度上所有结点的值，
     * 请按树上从左往右的顺序链接，保证深度不超过树的高度，树上结点的值为非负整数且不超过100000。
     */
    public ListNode getTreeLevel(TreeNode root, int dep) {
        // write code here
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelCount = 1;
        int nextLevelCount;
        TreeNode temp;
        while (dep-- >1) {
            nextLevelCount = 0;
            while (levelCount-- > 0) {
                temp = queue.poll();
                if (temp.left != null) {
                    queue.offer(temp.left);
                    nextLevelCount++;
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                    nextLevelCount++;
                }
            }
            levelCount = nextLevelCount;
        }
        if (queue.isEmpty()) return null;
        ListNode head, p;
        p = head = new ListNode(-1);
        while (!queue.isEmpty()) {
            ListNode node = new ListNode(queue.poll().val);
            p.next = node;
            p = p.next;
        }
        return head.next;
    }

}