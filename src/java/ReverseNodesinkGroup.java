package java;

/**
 * Created by haileyyin on 1/14/18.
 */
public class ReverseNodesinkGroup {
    /*
    recursion
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while(cur!=null && count!=k){
            cur = cur.next;
            count++;
        }
        if(count==k){  //if enough nodes to reverse
            cur = reverseKGroup(cur, k);
            while(count>0){  //reverse backwards
                ListNode temp = head.next;
                head.next = cur;
                cur = head;
                head = temp;
                count--;
            }
            head = cur;
        }
        return head;
    }
}
