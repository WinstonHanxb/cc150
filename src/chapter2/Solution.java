package chapter2;


public class Solution {
    /*输入一个链表，输出该链表中倒数第k个结点。*/
    public ListNode FindKthToTail(ListNode head,int k) {
        if(null == head ) return null;
        ListNode fast,slow;
        fast = slow = head;
        int i =0;
        for(;fast!=null;i++){
            if(i>=k) slow = slow.next;
            fast = fast.next;
        }
        return i < k ? null : slow;
    }
}
