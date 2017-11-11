package java;

/**
 * Created by haileyyin on 11/11/17.
 */
public class RemoveNthNodeFromEndofList {
    /*
    two pointers
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode slow = start;
        ListNode fast = start;

        for(int i=0; i<=n; i++){
            fast = fast.next;
        }

        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }

        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }
}
