package java;

/**
 * Created by haileyyin on 1/14/18.
 */
public class RemoveDuplicatesfromSortedListII {
    /*
    create a dummy head, a pre pointer and a cur pointer.
    each iteration make cur point to the number that occurs last, if the number is next to pre, then it occurs only once; otherwise it is repeated.
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while(cur!=null){
            while(cur.next!=null && cur.val==cur.next.val){
                cur = cur.next;
            }
            if(pre.next==cur){
                pre = pre.next;
            } else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
