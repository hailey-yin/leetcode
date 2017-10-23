package java;

/**
 * Created by haileyyin on 10/22/17.
 */
public class ReverseLinkedList2 {
    /*
    创造新的头节点
    维护两个指针：
    pre 父亲节点
    cur 当前节点
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy.next;
        for(int i=1; i<m; i++){
            pre = pre.next;
            cur = cur.next;
        }
        for(int i=0; i<n-m; i++){
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        return dummy.next;
    }
}
