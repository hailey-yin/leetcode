package java;

/**
 * Created by haileyyin on 10/22/17.
 */
public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode newHead = head.next;
        ListNode parent = null;
        ListNode pointer = head;
        while(pointer!=null&&pointer.next!=null){
            swap(pointer, pointer.next, parent);
            if(pointer.next!=null){
                parent = pointer;
                pointer = pointer.next;
            } else {
                pointer = null;
            }
        }
        return newHead;
    }

    public void swap(ListNode l1, ListNode l2, ListNode parent){
        l1.next = l2.next;
        l2.next = l1;
        if(parent!=null){
            parent.next = l2;
        }
    }
}
