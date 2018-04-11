package chapter2;

public class Remove {
    public boolean removeNode(ListNode pNode) {
        // write code here
        if(pNode.next == null||pNode == null) return false;
        pNode.val = pNode.next.val;
        pNode.next = pNode.next.next;
        return true;
    }
}
