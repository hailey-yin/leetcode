package java;

/**
 * Created by haileyyin on 10/22/17.
 */
public class ReverseLinkedList {
    /*
    方法一：iteration
     */
    public ListNode reverseList1(ListNode head) {
        ListNode newHead = null;
        while(head!=null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
    /*
    方法二：recursion
     */
    public ListNode reverseList2(ListNode head) {
        return helper(head, null);
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
