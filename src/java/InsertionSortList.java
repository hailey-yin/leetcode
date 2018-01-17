package java;

/**
 * Created by haileyyin on 1/16/18.
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if(head==null)
            return head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode insertPos = dummy;
        ListNode cur = head;
        while(cur!=null){
            ListNode next = cur.next;
            while( insertPos.next!=null && insertPos.next.val < cur.val ){
                insertPos = insertPos.next;
            }
            cur.next = insertPos.next;
            insertPos.next = cur;
            insertPos = dummy;
            cur = next;
        }
        return dummy.next;
    }
}
