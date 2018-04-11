package chapter2;

public class Plus {
    /**
     * 有两个用链表表示的整数，每个结点包含一个数位。
     * 这些数位是反向存放的，也就是个位排在链表的首部。
     * 编写函数对这两个整数求和，并用链表形式返回结果。
     * 给定两个链表ListNode* A，ListNode* B，请返回A+B的结果(ListNode*)。
     */
    public ListNode plusAB(ListNode a, ListNode b) {
        // write code here
        ListNode head, p, tempNode;
        head = p = null;
        boolean carry = false;
        int temp;
        while (a != null || b != null) {
            temp = (a == null ? 0 : a.val) + (b == null ? 0 : b.val) + (carry ? 1 : 0);
            if (temp >= 10) {
                carry = true;
                temp = temp - 10;
            } else {
                carry = false;
            }
            if (head == null) {
                head = p = new ListNode(temp);
            } else {
                tempNode = new ListNode(temp);
                p.next = tempNode;
                p = tempNode;
            }
            a = a == null ? null : a.next;
            b = b == null ? null : b.next;
        }
        if(carry){
            tempNode = new ListNode(1);
            p.next = tempNode;
        }
        return head;
    }
}
