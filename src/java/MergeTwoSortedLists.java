package java;

/**
 * Created by haileyyin on 10/22/17.
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2== null)
            return l1;
        if(l1.val<l2.val){
            ListNode merge = l1;
            merge.next = mergeTwoLists(l1.next, l2);
            return merge;
        } else {
            ListNode merge = l2;
            merge.next = mergeTwoLists(l1, l2.next);
            return merge;
        }
    }
}
