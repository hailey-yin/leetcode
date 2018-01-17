package java;

/**
 * Created by haileyyin on 1/16/18.
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        /*
        merge sort
        divide & conquer
        */
        if(head==null || head.next==null){
            return head;
        }
        ListNode middle = findMiddle(head);
        ListNode head2 = middle.next;
        middle.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(head2);
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode pointer = dummy;
        while(l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                pointer.next = l1;
                l1 = l1.next;
            } else {
                pointer.next = l2;
                l2 = l2.next;
            }
            pointer = pointer.next;
        }
        if(l1!=null){
            while(l1!=null){
                pointer.next = l1;
                l1 = l1.next;
                pointer = pointer.next;
            }
        } else if(l2!=null){
            while(l2!=null){
                pointer.next = l2;
                l2 = l2.next;
                pointer = pointer.next;
            }
        }
        return dummy.next;
    }

    private ListNode findMiddle(ListNode head){
        if(head==null||head.next==null)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
