package chapter2;

public class Partition {
    /**
     * 编写代码，以给定值x为基准将链表分割成两部分，
     * 所有小于x的结点排在大于或等于x的结点之前
     * 给定一个链表的头指针 ListNode* pHead，
     * 请返回重新排列后的链表的头指针。
     * 注意：分割以后保持原来的数据顺序不变。
     */
    public ListNode partition(ListNode pHead, int x) {
        // write code here
        ListNode tail1,head1;
        ListNode tail2,head2;
        tail1 = head1 = tail2 = head2 = null;
        ListNode temp;
        while(pHead != null){
            temp = pHead.next;
            pHead.next =null;
            if(pHead.val < x){
                if(head1==null){
                    tail1 = head1 = pHead;
                }else{
                    tail1.next = pHead;
                    tail1 = tail1.next;
                }
            }else{
                if(head2 == null){
                    tail2 = head2 = pHead;
                }else{
                    tail2.next = pHead;
                    tail2 = tail2.next;
                }
            }
            pHead = temp;
        }
        if(head1 ==null) return head2;
        else{
            tail1.next = head2;
            return head1;
        }
    }
}
