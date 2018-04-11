package chapter2;

import java.util.Stack;

public class Palindrome {
    /**
     * 请编写一个函数，检查链表是否为回文。
     * 给定一个链表ListNode* pHead，请返回一个bool，代表链表是否为回文。
     */
    public boolean isPalindrome(ListNode pHead) {
        // write code here
        if(pHead == null || pHead.next == null) return true;
        Stack<ListNode> nodes = new Stack();
        ListNode fast,slow;
        fast = slow = pHead;
        while(fast.next != null && fast.next.next != null){
            nodes.push(slow);
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast.next != null){//偶数长度
            nodes.push(slow);
        }
        slow = slow.next;
        while(!nodes.isEmpty()){
            if(nodes.pop().val != slow.val) return false;
            slow = slow.next;
        }
        return true;
    }
}
