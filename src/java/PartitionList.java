package java;

/**
 * Created by haileyyin on 1/12/18.
 */
public class PartitionList {
    /*
    iterate through the list, if node is smaller than x, link it to a new list and remove it from the original list. After that, Link the new list in front of the original list.
     */
    public ListNode partition(ListNode head, int x) {
        ListNode res = new ListNode(0);
        ListNode pointer1 = res;
        ListNode newHead = new ListNode(0);
        ListNode pointer2 = newHead;
        newHead.next = head;

        while(pointer2!=null && pointer2.next!=null){
            if(pointer2.next.val<x){
                pointer1.next = pointer2.next;
                pointer1 = pointer1.next;
                pointer2.next = pointer2.next.next;
            } else {
                pointer2 = pointer2.next;
            }
        }

        pointer1.next = newHead;
        return res.next;
    }
}
