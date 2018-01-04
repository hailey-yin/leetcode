package java;

/**
 * Created by haileyyin on 11/15/17.
 */
public class RotateList {
    /*
    use two pointers: slow and fast
    move the fast to the kth node, then move both of them step by step until fast points at the last node. Now the slow's next points to the new head.

    time limie exceeded.
    */
    public ListNode rotateRight1(ListNode head, int k) {
        if(head==null)
            return null;
        if(k==0||head.next==null)
            return head;
        ListNode slow = new ListNode(0);
        slow.next = head;
        ListNode fast = slow;
        while(k>0){
            if(fast.next!=null){
                fast = fast.next;
            } else {
                fast = head;
            }
            k--;
        }
        if(fast.next==null){
            return head;
        }
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = head;
        ListNode newHead = slow.next;
        slow.next = null;
        return newHead;
    }

    /*
    get the remainder when fast arrives the end but k is still bigger than 0.
     */
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null)
            return null;
        if(k==0||head.next==null)
            return head;
        ListNode slow = new ListNode(0);
        slow.next = head;
        ListNode fast = slow;
        int index = k;
        while(index>0){
            if(fast.next!=null){
                fast = fast.next;
            } else {
                index = k%(k-index);
                if(index==0){
                    return head;
                } else {
                    fast = head;
                }
            }
            index--;
        }
        if(fast.next==null){
            return head;
        }
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = head;
        ListNode newHead = slow.next;
        slow.next = null;
        return newHead;
    }
}
