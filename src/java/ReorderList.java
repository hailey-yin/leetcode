package java;

/**
 * Created by haileyyin on 1/15/18.
 */
public class ReorderList {
    /*
    time limit exceeded
    */
    public void reorderList(ListNode head) {
        reorderSubList(head);
    }

    private ListNode reorderSubList(ListNode head){
        if(head==null)
            return null;
        if(head.next==null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = slow.next.next;
        ListNode newTail = reorderSubList(head);
        newTail.next = temp;
        temp.next = null;
        return temp;

    }

    /*
    update
     */
    public void reorderList2(ListNode head) {
        if(head==null || head.next==null)
            return;

        //find the parent of the middle(slow)
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        //reverse the latter half of the list
        ListNode newMiddle = helper(slow.next, null);
        slow.next = newMiddle;

        //interweave the former half with the latter half one by one
        ListNode pointer1 = head;
        ListNode pointer2 = slow;
        while(pointer1!=slow){
            ListNode temp1 = pointer1.next;
            ListNode temp2 = pointer2.next;
            pointer2.next = pointer2.next.next;
            pointer1.next = temp2;
            temp2.next = temp1;
            pointer1 = temp1;
        }
    }

    private ListNode helper(ListNode head, ListNode pre){
        if(head==null){
            return pre;
        }
        ListNode next = head.next;
        head.next = pre;
        return helper(next, head);
    }

}
