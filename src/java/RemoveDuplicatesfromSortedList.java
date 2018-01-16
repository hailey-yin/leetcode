package java;

/**
 * Created by haileyyin on 1/12/18.
 */
public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pointer = head;
        while(pointer!=null && pointer.next!=null){
            if(pointer.next.val==pointer.val){
                pointer.next = pointer.next.next;
            } else {
                pointer = pointer.next;
            }

        }
        return head;
    }
}
